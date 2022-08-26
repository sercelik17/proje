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
    @PreAuthorize("hasAnyAuthority('AKADEMISYEN','ASISTAN')")
    public MessageResponse addHomework(@Valid @RequestBody AddHomeworkRequest addHomeworkRequest) {
        return homeworkService.addHomework(addHomeworkRequest.toDomainEntity());
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAnyAuthority('AKADEMISYEN','ASISTAN')")
    public MessageResponse updateHomework(@Valid @RequestBody UpdateHomeworkRequest updateHomeworkRequest, @PathVariable Long id) {
        return homeworkService.updateHomework(id, updateHomeworkRequest.toDomainEntity());

    }

    @DeleteMapping("{id}")
    public MessageResponse getHomeworkById(@PathVariable Long id) {

        return homeworkService.deleteHomeworkById(id);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('AKADEMISYEN','ASISTAN','STUDENT')")
    public List<HomeworkQueryModel> getAllHomework() {
        return homeworkService.getAllHomework()
                .stream()
                .map(homework -> new HomeworkQueryModel(homework))
                .toList();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAnyAuthority('AKADEMISYEN','ASISTAN','STUDENT')")
    public HomeworkQueryModel getById(@PathVariable Long id) {
        HomeworkQueryModel homeworkQueryModel = new HomeworkQueryModel(homeworkService.getById(id));
        return homeworkQueryModel;
    }

}
