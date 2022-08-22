package yte.intern.data.project.exam.controller.response;

import yte.intern.data.project.exam.entity.Exam;

public record ExamQueryModel(

        Long id,
        String name,
        String room,
        String time,
        String info,
        Long lessonId
) {

    public ExamQueryModel(Exam exam) {
        this(
                exam.getId(),
                exam.getName(),
                exam.getRoom(),
                exam.getTime(),
                exam.getInfo(),
                exam.getLesson().getId()
        );
    }
}
