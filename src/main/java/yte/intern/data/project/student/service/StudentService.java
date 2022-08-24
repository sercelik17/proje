package yte.intern.data.project.student.service; //security ve security test dependency eklemeyi unutma

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import yte.intern.data.project.authentication.entity.Users;
import yte.intern.data.project.student.entity.Student;
import yte.intern.data.project.student.repository.StudentRepository;
import yte.intern.data.project.common.response.MessageResponse;
import yte.intern.data.project.common.response.ResponseType;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public MessageResponse addStudent(Student student) {
        studentRepository.save(student);

        return new MessageResponse(ResponseType.SUCCESS, "Student has been added successfully");
    }

    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    public Student getById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
    }

    public MessageResponse deleteStudentById(Long id) {
        studentRepository.deleteById(id);
        return new MessageResponse(ResponseType.SUCCESS, "Student has been deleted successfully");
    }

    public MessageResponse updateStudent(Long id, Student updatedStudent) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));

        student.update(updatedStudent);

        studentRepository.save(student);

        return new MessageResponse(ResponseType.SUCCESS, "Student has been updated successfully");
    }

    /*public MessageResponse addStudentAdmin(Student toDomainEntity) {
        Users a = new Users();
        a.setPassword(toDomainEntity.getPassword());
        a.setUsername(toDomainEntity.getUsername());
        Session userRepository = null;
        userRepository.save(a);

        return new MessageResponse(ResponseType.SUCCESS, "Student has been added successfully");
    }*/
}
