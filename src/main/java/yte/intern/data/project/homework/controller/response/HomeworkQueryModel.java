package yte.intern.data.project.homework.controller.response;

import yte.intern.data.project.homework.entity.Homework;

public record HomeworkQueryModel(
        Long id,
        String definition,
        String PDF,
        String endTime,
        Long asistanId,
        Long lessonId
) {
    public HomeworkQueryModel(Homework homework) {
        this(
                homework.getId(),
                homework.getDefinition(),
                homework.getPDF(),
                homework.getEndTime(),

                homework.getLesson().getId(),
                homework.getAsistan().getId()

        );
    }
}
