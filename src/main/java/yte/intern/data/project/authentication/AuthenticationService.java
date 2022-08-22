package yte.intern.data.project.authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.*;
import yte.intern.data.project.akademisyen.entity.Akademisyen;
import yte.intern.data.project.akademisyen.repository.AkademisyenRepository;
import yte.intern.data.project.authentication.entity.Users;
import yte.intern.data.project.student.entity.Student;
import yte.intern.data.project.student.repository.StudentRepository;

@Component
public class AuthenticationService {


    private AkademisyenRepository academicianRepository;

    private StudentRepository studentRepository;


    public Akademisyen akademisyen() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof Users) {
            Users users = (Users) principal;
            return academicianRepository.findAkademisyenById(users.getId()).orElseThrow(RuntimeException::new);
        }

        throw new RuntimeException();
    }

    public Student student() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof Users) {
            Users users = (Users) principal;
            return studentRepository.findStudentById(users.getId()).orElseThrow(RuntimeException::new);
        }

        throw new RuntimeException();
    }

}
