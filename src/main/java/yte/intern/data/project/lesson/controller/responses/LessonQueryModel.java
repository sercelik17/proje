package yte.intern.data.project.lesson.controller.responses;

import yte.intern.data.project.lesson.service.LessonService;
import yte.intern.data.project.lesson.entity.Lesson;



public record LessonQueryModel(
        Long id,
        String name,
        String definition,
        String type,
        String code,
        String room,
        String timeSlot,
        Long akademisyenId
) {
    public LessonQueryModel(Lesson lesson) {
        this(
                lesson.getId(),
                lesson.getName(),
                lesson.getDefinition(),
                lesson.getType(),
                lesson.getCode(),
                lesson.getRoom(),
                lesson.getTimeSlot(),
                lesson.getAkademisyen().getId()


        );
    }


}
