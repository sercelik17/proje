package yte.intern.data.project.exam.controller.request;

import yte.intern.data.project.exam.entity.Exam;
public record AddExamRequest(
    String name,
    String room,
    String time,
    String info,
    Long lessonId
 ) {
public Exam toDomainEntity() {
        return new Exam(name,room,time,info,lessonId);
        }
}
