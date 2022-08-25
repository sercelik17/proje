package yte.intern.data.project.exam.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.intern.data.project.common.response.MessageResponse;
import yte.intern.data.project.exam.controller.request.AddExamRequest;
import yte.intern.data.project.exam.controller.request.UpdateExamRequest;
import yte.intern.data.project.exam.controller.response.ExamQueryModel;
import yte.intern.data.project.exam.service.ExamService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/exams")
public class ExamController {


    private final ExamService examService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('AKADEMISYEN','ASISTAN','ADMIN')")
    public MessageResponse addExam(@Valid @RequestBody AddExamRequest addExamRequest) {
        return examService.addExam(addExamRequest.toDomainEntity());
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAnyAuthority('AKADEMISYEN','ASISTAN','ADMIN')")
    public MessageResponse updateExam(@Valid @RequestBody UpdateExamRequest updateExamRequest, @PathVariable Long id) {
        return examService.updateExam(id, updateExamRequest.toDomainEntity());

    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAnyAuthority('AKADEMISYEN','ASISTAN','ADMIN')")
    public MessageResponse getExamById(@PathVariable Long id) {
        return examService.deleteExamById(id);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('AKADEMISYEN','ASISTAN','STUDENT','ADMIN')")
    public List<ExamQueryModel> getAllExams() {
        return examService.getAllExam()
                .stream()
                .map(exam -> new ExamQueryModel(exam))
                .toList();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','AKADEMİSYEN','ASISTAN')")
    public ExamQueryModel getById(@PathVariable Long id) {

        return new ExamQueryModel(examService.getById(id));
    }


}
