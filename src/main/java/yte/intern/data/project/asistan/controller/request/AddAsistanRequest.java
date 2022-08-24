package yte.intern.data.project.asistan.controller.request;

import yte.intern.data.project.asistan.entity.Asistan;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record AddAsistanRequest(
        @NotBlank
        @Size(max = 25)
        String name,
        @NotBlank
        @Size(max = 25)
        String surname,

        String username,

        String password,

        Long akademisyenId
)

{
    public Asistan toDomainEntity() {
        return new Asistan(name, surname, username, password,akademisyenId);
    }
}
