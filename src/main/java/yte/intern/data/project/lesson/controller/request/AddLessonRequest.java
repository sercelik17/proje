package yte.intern.data.project.lesson.controller.request;

import yte.intern.data.project.lesson.entity.Lesson;

import java.time.LocalDateTime;


public record AddLessonRequest(
        String name,
        String definition,
        String type,
        String code,
        String room,
        String timeSlot,
        Long akademisyenId





) {
    public Lesson toDomainEntity() {

        return new Lesson(name, definition, code, type, room, timeSlot, akademisyenId);
    }
}
