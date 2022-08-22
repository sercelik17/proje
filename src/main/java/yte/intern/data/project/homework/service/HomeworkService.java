package yte.intern.data.project.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import yte.intern.data.project.asistan.entity.Asistan;
import yte.intern.data.project.asistan.service.AsistanService;
import yte.intern.data.project.common.response.MessageResponse;
import yte.intern.data.project.common.response.ResponseType;
import yte.intern.data.project.homework.entity.Homework;
import yte.intern.data.project.homework.repository.HomeworkRepository;
import yte.intern.data.project.lesson.entity.Lesson;
import yte.intern.data.project.lesson.service.LessonService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeworkService {

    private  final HomeworkRepository homeworkRepository;

    private  final AsistanService asistanService;

    private final LessonService lessonService;


    public MessageResponse addHomework(Homework homework) {
        Lesson lesson = lessonService.getLessonById(homework.getLesson().getId());
        homework.setLesson(lesson);

        Asistan asistan = asistanService.getAsistanById(homework.getAsistan().getId());
        homework.setAsistan(asistan);

        homeworkRepository.save(homework);
        return new MessageResponse(ResponseType.SUCCESS, "Ödev başarıyla kaydedildi");
    }

    public MessageResponse updateHomework(Long id, Homework updateHomework) {
        Homework homework = homeworkRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("kayıt bulunamadı"));

        homeworkRepository.save(updateHomework);

        updateHomework.update(homework);
        return new MessageResponse(ResponseType.SUCCESS, "Ödev başarıyla güncellendi");
    }

    public MessageResponse deleteHomeworkById(Long id) {
        homeworkRepository.deleteById(id);
        return new MessageResponse(ResponseType.SUCCESS, "Ödev başarıyla silindi");
    }

    public List<Homework> getAllHomework() {
        return homeworkRepository.findAll();
    }


    public Homework getHomeworkById(Long id) {
        return homeworkRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("kayıt bulunamadı"));
    }

    @GetMapping("{id}")
    public Homework getById(@PathVariable Long id) {
        return homeworkRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("kayıt bulunamadı"));

    }
}
