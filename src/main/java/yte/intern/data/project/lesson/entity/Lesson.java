package yte.intern.data.project.lesson.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.intern.data.project.akademisyen.entity.Akademisyen;
import yte.intern.data.project.asistan.entity.Asistan;
import yte.intern.data.project.common.entity.BaseEntity;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lesson extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private String name;
    private String definition;
    private String type;
    private String code;
    private String room;
    private String timeSlot;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "akademisyen_id", referencedColumnName = "ID")
    private Akademisyen akademisyen;


    public Lesson(String name,
                  String definition,
                  String type,
                  String code,
                  String room,
                  String timeSlot,
                  Long akademisyenId) {
        this.name = name;
        this.definition = definition;
        this.type = type;
        this.code = code;
        this.room = room;
        this.timeSlot = timeSlot;

        this.akademisyen = new Akademisyen();
        this.akademisyen.setId(akademisyenId);


    }


    public void update(Lesson updateLesson) {
        this.name = updateLesson.name;
        this.definition = updateLesson.definition;
        this.type = updateLesson.type;
        this.code = updateLesson.code;
        this.timeSlot = updateLesson.timeSlot;
        this.room = updateLesson.room;

        this.akademisyen = updateLesson.akademisyen;
    }



}





