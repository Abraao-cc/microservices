package br.ind.cmil.gestao.web.dto;

import java.util.List;

/**
 *
 * @author Administrativo
 */
public record AtivoPageDTO(List<AtivoDTO> ativos, long totalElements, int totalPages) {

}
