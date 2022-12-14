package yte.intern.data.project.exam.controller.request;

import yte.intern.data.project.exam.entity.Exam;

public record UpdateExamRequest(


        String name,
        String room,
        String time,
        String info,
        Long lesson_id
) {
    public Exam toDomainEntity() {
        return new Exam(name, room, time, info,lesson_id);
    }

}
