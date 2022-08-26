package yte.intern.data.project.homework.controller.request;

import yte.intern.data.project.homework.entity.Homework;

public record UpdateHomeworkRequest(
        String definition,
        String PDF,
        String endTime,
        Long lessonId,
        Long asistanId
) {
    public Homework toDomainEntity() {
        return new Homework(definition, PDF, endTime, lessonId, asistanId);
    }
}
