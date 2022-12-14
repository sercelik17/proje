package yte.intern.data.project.authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.*;
import yte.intern.data.project.akademisyen.entity.Akademisyen;
import yte.intern.data.project.akademisyen.service.repository.AkademisyenRepository;
import yte.intern.data.project.asistan.entity.Asistan;
import yte.intern.data.project.asistan.repository.AsistanRepository;
import yte.intern.data.project.authentication.entity.Users;
import yte.intern.data.project.lesson.repository.LessonRepository;
import yte.intern.data.project.student.entity.Student;
import yte.intern.data.project.student.repository.StudentRepository;

@Component
public class AuthenticationService {


    private AkademisyenRepository akademisyenRepository;

    private StudentRepository studentRepository;
    private AsistanRepository asistanRepository;


    public Akademisyen akademisyen() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof Users) {
            Users users = (Users) principal;
            return akademisyenRepository.findAkademisyenById(users.getId()).orElseThrow(RuntimeException::new);
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

    public Asistan asistan() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof Users) {
            Users users = (Users) principal;
            return asistanRepository.findAsistanById(users.getId()).orElseThrow(RuntimeException::new);
        }

        throw new RuntimeException();
    }

}
