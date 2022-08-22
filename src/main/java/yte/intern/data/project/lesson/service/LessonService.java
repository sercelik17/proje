package yte.intern.data.project.lesson.service; //security ve security test dependency eklemeyi unutma

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.intern.data.project.akademisyen.entity.Akademisyen;
import yte.intern.data.project.akademisyen.service.AkademisyenService;
import yte.intern.data.project.asistan.entity.Asistan;
import yte.intern.data.project.asistan.service.AsistanService;
import yte.intern.data.project.lesson.entity.Lesson;
import yte.intern.data.project.lesson.repository.LessonRepository;
import yte.intern.data.project.common.response.MessageResponse;
import yte.intern.data.project.common.response.ResponseType;
import yte.intern.data.project.lesson.entity.Lesson;
import yte.intern.data.project.lesson.repository.LessonRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;
    private final AkademisyenService akademisyenService;
    private final AsistanService asistanService;
    public MessageResponse addLesson(Lesson lesson) {
        Akademisyen akademisyen = akademisyenService.getById(lesson.getAkademisyen().getId());
        lesson.setAkademisyen(akademisyen);

        Asistan asistan = asistanService.getById(lesson.getAsistan().getId());
        lesson.setAsistan(asistan);

        lessonRepository.save(lesson);

        return new MessageResponse(ResponseType.SUCCESS, "Lesson has been added successfully");
    }

    public List<Lesson> getAllLesson() {

        return lessonRepository.findAll();
    }

    public Lesson getLessonById(Long id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lesson not found"));
    }

    public MessageResponse deleteLessonById(Long id) {
        lessonRepository.deleteById(id);
        return new MessageResponse(ResponseType.SUCCESS, "Lesson has been deleted successfully");
    }

    public MessageResponse updateLesson(Long id, Lesson updateLesson) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lesson not found"));

        Akademisyen akademisyen = akademisyenService.getById(lesson.getAkademisyen().getId());
        lesson.setAkademisyen(akademisyen);

        lesson.update(updateLesson);

        lessonRepository.save(lesson);

        return new MessageResponse(ResponseType.SUCCESS, "Lesson has been updated successfully");
    }
}
