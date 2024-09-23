package br.ind.cmil.gestao.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author Administrativo
 */
public record RegisterUserDTO(
        @NotBlank
        @NotNull
        String name,
        @NotBlank
        @NotNull
        @Email
        String email,
        @NotBlank
        @NotNull
        String password) {

}
