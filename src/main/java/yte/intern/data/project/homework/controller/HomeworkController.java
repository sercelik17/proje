package yte.intern.data.project.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.intern.data.project.common.response.MessageResponse;
import yte.intern.data.project.homework.controller.request.AddHomeworkRequest;
import yte.intern.data.project.homework.controller.request.UpdateHomeworkRequest;
import yte.intern.data.project.homework.controller.response.HomeworkQueryModel;
import yte.intern.data.project.homework.service.HomeworkService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/homeworks")
@Validated
@RequiredArgsConstructor
public class HomeworkController {


    private final HomeworkService homeworkService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('Akademisyen','Asistan')")
    public MessageResponse addExam(@Valid @RequestBody AddHomeworkRequest addExamRequest) {
        return homeworkService.addHomework(addExamRequest.toDomainEntity());
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAnyAuthority('Akademisyen','Asistan')")
    public MessageResponse updateExam(@Valid @RequestBody UpdateHomeworkRequest updateExamRequest, @PathVariable Long id) {
        return homeworkService.updateHomework(id, updateExamRequest.toDomainEntity());

    }

    @DeleteMapping("{id}")
    public MessageResponse getExamById(@PathVariable Long id) {
        return homeworkService.deleteHomeworkById(id);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('Akademisyen','Asistan','Student')")
    public List<HomeworkQueryModel> getAllExams() {
        return homeworkService.getAllHomework()
                .stream()
                .map(homework -> new HomeworkQueryModel(homework))
                .toList();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAnyAuthority('Akademisyen','Asistan','Student')")
    public HomeworkQueryModel getById(@PathVariable Long id) {
        return new HomeworkQueryModel(homeworkService.getById(id));
    }

}
