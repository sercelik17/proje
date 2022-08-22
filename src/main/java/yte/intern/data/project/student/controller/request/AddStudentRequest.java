package yte.intern.data.project.student.controller.request;

import yte.intern.data.project.student.entity.Student;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record AddStudentRequest(
        @NotBlank
        @Size(max = 25)
        String name,
        @NotBlank
        @Size(max = 25)
        String surname,
        String username,
        String email,
        String password

) {
    public Student toDomainEntity() {

        return new Student(name, surname,  username, email, password);
    }
}
