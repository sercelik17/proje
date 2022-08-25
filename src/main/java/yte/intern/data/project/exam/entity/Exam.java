package yte.intern.data.project.exam.entity;

import lombok.Getter;
import lombok.Setter;
import yte.intern.data.project.common.entity.BaseEntity;
import yte.intern.data.project.lesson.entity.Lesson;


import javax.persistence.*;

@Entity
@Getter
@Setter
public class Exam extends BaseEntity {

    private String name;
    private String room;
    private String time;
    private String info;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", referencedColumnName = "ID")
    private Lesson lesson;


    public Exam(String name,
                String room,
                String time,
                String info,
                Long lesson_id) {
        this.name = name;
        this.room = room;
        this.time = time;
        this.info = info;

        this.lesson = new Lesson();
        this.lesson.setId(lesson_id);
    }

    public Exam() {

    }

    public void update(Exam updateExam) {
        this.name = updateExam.name;
        this.room = updateExam.room;
        this.time = updateExam.time;
        this.info = updateExam.info;
        this.lesson = updateExam.lesson;

    }
}
