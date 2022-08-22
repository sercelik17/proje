package yte.intern.data.project.admin.controller.request;

import yte.intern.data.project.admin.entity.Admin;

import javax.validation.constraints.NotBlank;


public record AddAdminRequest(
        @NotBlank
        String username,
        String password

) {

    public Admin toDomainEntity() {
        return new Admin(username, password);
    }
}
