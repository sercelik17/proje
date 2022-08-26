package yte.intern.data.project.asistan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import yte.intern.data.project.asistan.controller.request.AddAsistanRequest;
import yte.intern.data.project.asistan.controller.request.UpdateAsistanRequest;
import yte.intern.data.project.asistan.controller.responses.AsistanQueryModel;
import yte.intern.data.project.asistan.service.AsistanService;

import yte.intern.data.project.authentication.entity.Authority;
import yte.intern.data.project.authentication.entity.Users;
import yte.intern.data.project.authentication.repository.AuthorityRepository;
import yte.intern.data.project.authentication.repository.UserRepository;
import yte.intern.data.project.common.response.MessageResponse;
import yte.intern.data.project.student.controller.request.AddStudentRequest;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/asistans")
@RequiredArgsConstructor
@Validated
public class AsistanController {
    private final AsistanService asistanService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthorityRepository authorityRepository;
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AKADEMISYEN')")
    public MessageResponse addAsistan(@Valid @RequestBody yte.intern.data.project.asistan.controller.request.
            AddAsistanRequest addAsistanRequest) {
        Users a = new Users();
        Authority asistan = authorityRepository.findByAuthority("ASISTAN")
                .orElseThrow(() -> new EntityNotFoundException("Authority:ASISTAN not found!"));
        a.setUsername(addAsistanRequest.username());
        a.setPassword(passwordEncoder.encode(addAsistanRequest.password()));
        //a.setRole(Role.ASISTAN);

        a.setAuthorities(List.of(asistan));

        userRepository.save(a);


        return asistanService.addAsistan(addAsistanRequest.toDomainEntity());
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','AKADEMISYEN')")
    public List<AsistanQueryModel> getAllAsistans() {
        return asistanService.getAllAsistans()
                .stream()
                .map(asistan -> new yte.intern.data.project.asistan.controller.responses.AsistanQueryModel(asistan))
                .toList();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','AKADEMISYEN')")
    public AsistanQueryModel getById(@NotNull @PathVariable Long id) {
        return new AsistanQueryModel(asistanService.getById(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public MessageResponse deleteAsistanById(@PathVariable @NotNull Long id) {
        return asistanService.deleteAsistanById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public MessageResponse updateAsistan(@Valid @RequestBody UpdateAsistanRequest updateAsistanRequest, @PathVariable Long id) {
        return asistanService.updateAsistan(id, updateAsistanRequest.toDomainEntity());
    }


}
