package yte.intern.data.project.lesson.controller.request;

import yte.intern.data.project.lesson.entity.Lesson;


public record UpdateLessonRequest(

        String name,
        String definition,
        String type,
        String code,
        String room,
        String timeSlot,
        Long akademisyenId


) {
    public Lesson toDomainEntity() {

        return new Lesson(name, definition, type, code, room, timeSlot, akademisyenId);
    }
}
