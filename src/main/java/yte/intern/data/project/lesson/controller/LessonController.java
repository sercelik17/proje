package yte.intern.data.project.lesson.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.intern.data.project.lesson.controller.request.AddLessonRequest;
import yte.intern.data.project.lesson.controller.request.UpdateLessonRequest;
import yte.intern.data.project.lesson.controller.responses.LessonQueryModel;
import yte.intern.data.project.common.response.MessageResponse;
import yte.intern.data.project.lesson.service.LessonService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/lessons")
@RequiredArgsConstructor
@Validated
public class LessonController {
    private final LessonService lessonService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public MessageResponse addLesson(@Valid @RequestBody AddLessonRequest addLessonRequest) {

        return lessonService.addLesson(addLessonRequest.toDomainEntity());
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('STUDENT','ADMIN','AKADEMISYEN','ASISTAN')")
    public List<LessonQueryModel> getAllLesson() {
        return lessonService.getAllLesson()
                .stream()
                .map(lesson -> new LessonQueryModel(lesson))
                .toList();
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','AKADEMISYEN','ASISTAN')")
    public LessonQueryModel getLessonById(@NotNull @PathVariable Long id) {
        return new LessonQueryModel(lessonService.getLessonById(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public MessageResponse deleteLessonById(@PathVariable @NotNull Long id) {
        return lessonService.deleteLessonById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','AKADEMISYEN','ASISTAN')")
    public MessageResponse updateLesson(@Valid @RequestBody UpdateLessonRequest request, @PathVariable Long id) {
        return lessonService.updateLesson(id, request.toDomainEntity());
    }
}
