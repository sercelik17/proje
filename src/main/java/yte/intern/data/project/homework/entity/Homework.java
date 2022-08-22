package yte.intern.data.project.homework.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.intern.data.project.asistan.entity.Asistan;
import yte.intern.data.project.common.entity.BaseEntity;
import yte.intern.data.project.lesson.entity.Lesson;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Homework extends BaseEntity {

    private String definition;
    private String PDF;
    private String endTime;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "asistan_id", referencedColumnName = "ID")
    private Asistan asistan;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "lesson_id", referencedColumnName = "ID")
    private Lesson lesson;

    public Homework(String definition,
                    String PDF,
                    String endTime,
                    Long asistanId,
                    Long lessonId
    ) {
        this.definition = definition;
        this.PDF = PDF;
        this.endTime = endTime;

        this.asistan = new Asistan();
        this.asistan.setId(asistanId);

        this.lesson = new Lesson();
        this.lesson.setId(lessonId);
    }

    public void update(Homework updateHomework) {
        this.definition = updateHomework.definition;
        this.PDF = updateHomework.PDF;
        this.endTime = updateHomework.endTime;
    }
}
