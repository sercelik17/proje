package yte.intern.data.project.lesson.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.intern.data.project.akademisyen.entity.Akademisyen;
import yte.intern.data.project.asistan.entity.Asistan;
import yte.intern.data.project.common.entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;



@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lesson extends BaseEntity {

    private String name;
    private String definition;
    private String type;
    private String code;
    private String room;
    private String source;
    private LocalDateTime time;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "akademisyen_id", referencedColumnName = "ID")
    private Akademisyen akademisyen;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "asistan_id",referencedColumnName = "ID")
    private Asistan asistan;
    private Long id;


    public Lesson(String name,
                  String definition,
                  String type,
                  String code,
                  String source,
                  String time,
                  Long akademisyenId,
                  Long asistanId) {
        this.name = name;
        this.definition = definition;
        this.type = type;
        this.code = code;
        this.room = room;
        this.source = source;
        this.time = LocalDateTime.parse(time);

        this.akademisyen = new Akademisyen();
        this.akademisyen.setId(akademisyenId);

        this.asistan = new Asistan();
        this.asistan.setId(asistanId);
    }

    public void update(Lesson updateLesson) {
        this.name = updateLesson.name;
        this.definition = updateLesson.definition;
        this.type = updateLesson.type;
        this.code = updateLesson.code;
        this.time = updateLesson.time;
        this.room = updateLesson.room;
        this.source = updateLesson.source;

        this.akademisyen = updateLesson.akademisyen;
        this.asistan = updateLesson.asistan;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}





