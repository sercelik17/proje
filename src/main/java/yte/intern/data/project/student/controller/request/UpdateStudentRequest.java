package yte.intern.data.project.student.controller.request;

import yte.intern.data.project.student.entity.Student;
import yte.intern.data.project.student.entity.Student;

import javax.validation.constraints.Email;

public record UpdateStudentRequest(
        String name,
        String surname,
        @Email
        String email,
        String username,
        String password
) {
    public Student toDomainEntity() {

        return new Student(name, surname, email, username, password);
    }
}
