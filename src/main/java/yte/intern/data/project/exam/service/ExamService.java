package yte.intern.data.project.exam.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import yte.intern.data.project.common.response.MessageResponse;
import yte.intern.data.project.common.response.ResponseType;
import yte.intern.data.project.exam.entity.Exam;
import yte.intern.data.project.exam.repository.ExamRepository;
import yte.intern.data.project.lesson.entity.Lesson;
import yte.intern.data.project.lesson.service.LessonService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamService {


    private final ExamRepository examRepository;
    private final LessonService lessonService;

    public MessageResponse addExam(Exam exam) {
        Lesson lesson = lessonService.getLessonById(exam.getLesson().getId());
        exam.setLesson(lesson);

        examRepository.save(exam);
        return new MessageResponse(ResponseType.SUCCESS, "Sınav başarıyla kaydedildi");
    }

    public MessageResponse updateExam(Long id, Exam updateExam) {
        Exam exam = examRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("kayıt bulunamadı"));

        Lesson lesson = lessonService.getLessonById(exam.getLesson().getId());
        exam.setLesson(lesson);
        exam.update(updateExam);

        examRepository.save(exam);

        return new MessageResponse(ResponseType.SUCCESS, "Exam has been updated successfully");
    }

    public MessageResponse deleteExamById(Long id) {
        examRepository.deleteById(id);
        return new MessageResponse(ResponseType.SUCCESS, "Exam başarıyla silindi");
    }

    public List<Exam> getAllExam() {

        return examRepository.findAll();
    }


    public Exam getById(Long id) {
        return examRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("kayıt bulunamadı"));
    }



}
