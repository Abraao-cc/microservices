package br.ind.cmil.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author Administrativo
 */
public record ProfileDTO(
        String id,
        @NotBlank
        @NotNull
        String type) {

}
