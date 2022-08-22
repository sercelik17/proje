package yte.intern.data.project.student.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.intern.data.project.authentication.Role;
import yte.intern.data.project.authentication.entity.Users;
import yte.intern.data.project.student.controller.request.AddStudentRequest;
import yte.intern.data.project.student.controller.request.UpdateStudentRequest;
import yte.intern.data.project.student.controller.responses.StudentQueryModel;
import yte.intern.data.project.common.response.MessageResponse;
import yte.intern.data.project.student.service.StudentService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Validated
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public MessageResponse addStudent(@Valid @RequestBody AddStudentRequest addStudentRequest) {
        Users a = new Users();
        a.setPassword("");
        a.setUsername("");

        return studentService.addStudent(addStudentRequest.toDomainEntity());
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<StudentQueryModel> getAllStudents() {
        return studentService.getAllStudents()
                .stream()
                .map(student -> new StudentQueryModel(student))
                .toList();
    }

    @GetMapping("/{id}")
    public StudentQueryModel getById(@NotNull @PathVariable Long id) {
        return new StudentQueryModel(studentService.getById(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public MessageResponse deleteStudentById(@PathVariable @NotNull Long id) {
        return studentService.deleteStudentById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public MessageResponse updateStudent(@Valid @RequestBody UpdateStudentRequest request, @PathVariable Long id) {
        return studentService.updateStudent(id, request.toDomainEntity());
    }

    @PostMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public MessageResponse addStudentAdmin(@Valid @RequestBody AddStudentRequest addStudentRequest) {
        return studentService.addStudentAdmin(addStudentRequest.toDomainEntity());
    }
}
