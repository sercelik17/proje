package yte.intern.data.project.lesson.controller.responses;

import yte.intern.data.project.lesson.service.LessonService;
import yte.intern.data.project.lesson.entity.Lesson;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public record LessonQueryModel(
        Long id,
        String name,
        String definition,
        String type,
        String code,
        String room,
        String source,

        LocalDateTime time
) {
    public LessonQueryModel(Lesson lesson) {
        this(
                lesson.getId(),
                lesson.getName(),
                lesson.getDefinition(),
                lesson.getType(),
                lesson.getCode(),
                lesson.getRoom(),
                lesson.getSource(),
                lesson.getTime()


        );
    }


}
