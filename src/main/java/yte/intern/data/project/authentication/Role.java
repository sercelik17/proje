package yte.intern.data.project.authentication;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    AKADEMISYEN,
    STUDENT,
    ADMIN,
    ASISTAN;

    @Override
    public String getAuthority() {
        return name();
    }
}