package yte.intern.data.project.lesson.controller.request;

import yte.intern.data.project.lesson.entity.Lesson;

import java.time.LocalDateTime;


public record UpdateLessonRequest(

        String name,
        String definition,
        String type,
        String code,
        String room,
        String source,
        LocalDateTime time,

        Long akademisyenId,
        Long asistanId

) {
    public Lesson toDomainEntity() {

        return new Lesson(name, definition, type, code, room, source, akademisyenId, asistanId);
    }
}
