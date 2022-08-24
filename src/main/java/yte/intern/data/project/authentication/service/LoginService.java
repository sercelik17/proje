package yte.intern.data.project.authentication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import yte.intern.data.project.authentication.controller.requests.LoginRequest;
import yte.intern.data.project.common.response.MehmetRecord;
import yte.intern.data.project.common.response.MessageResponse;
import yte.intern.data.project.common.response.ResponseType;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final AuthenticationManager authenticationManager;

    public MehmetRecord login(LoginRequest loginRequest) {
        var preAuthentication = new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password());
        var authority = "";
        try {
            Authentication postAuthentication = authenticationManager.authenticate(preAuthentication);
            SecurityContext newContext = SecurityContextHolder.createEmptyContext();
            newContext.setAuthentication(postAuthentication);
            SecurityContextHolder.setContext(newContext);

            authority = newContext.getAuthentication().getAuthorities().stream().toList().get(0).getAuthority();

            return new MehmetRecord(ResponseType.SUCCESS, "Login is successful",authority);
        } catch (AuthenticationException e) {
            return new MehmetRecord(ResponseType.ERROR, "Authentication exception: %s".formatted(e.getMessage()), authority);
        }
    }
}
