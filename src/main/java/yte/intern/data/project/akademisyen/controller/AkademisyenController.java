package yte.intern.data.project.akademisyen.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.intern.data.project.akademisyen.controller.request.AddAkademisyenRequest;
import yte.intern.data.project.akademisyen.controller.request.UpdateAkademisyenRequest;
import yte.intern.data.project.akademisyen.service.AkademisyenService;
import yte.intern.data.project.authentication.AuthenticationService;
import yte.intern.data.project.authentication.Role;
import yte.intern.data.project.authentication.entity.Users;
import yte.intern.data.project.common.response.MessageResponse;
import yte.intern.data.project.akademisyen.controller.responses.AkademisyenQueryModel;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/akademisyen")
@RequiredArgsConstructor
@Validated
public class AkademisyenController {
    private final AkademisyenService akademisyenService;
    private final AuthenticationService authenticationService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public MessageResponse addAkademisyen(@Valid @RequestBody AddAkademisyenRequest addAkademisyenRequest) {
        Users a = new Users();
        a.setPassword("");
        //a.setAuthorities().AKADEMISYEN); liste içinde geç
        a.setUsername("");

        return akademisyenService.addAkademisyen(addAkademisyenRequest.toDomainEntity());
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<AkademisyenQueryModel> getAllAkademisyen() {
        return akademisyenService.getAllAkademisyen()
                .stream()
                .map(akademisyen -> new AkademisyenQueryModel(akademisyen))
                .toList();
    }

    @GetMapping("/{id}")
    public AkademisyenQueryModel getAkademisyenById(@NotNull @PathVariable Long id) {
        return new AkademisyenQueryModel(akademisyenService.getById(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public MessageResponse deleteAkademisyenById(@PathVariable @NotNull Long id) {
        return akademisyenService.deleteAkademisyenById(id);
    }

    @PutMapping("/{id}")
    public MessageResponse updateAkademisyen(@Valid @RequestBody UpdateAkademisyenRequest request, @PathVariable Long id) {
        return akademisyenService.updateAkademisyen(id, request.toDomainEntity());
    }
}
