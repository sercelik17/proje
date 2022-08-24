package yte.intern.data.project.authentication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yte.intern.data.project.authentication.controller.requests.LoginRequest;
import yte.intern.data.project.authentication.service.LoginService;
import yte.intern.data.project.common.response.MehmetRecord;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public MehmetRecord login(@Valid @RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest);

    }

}
