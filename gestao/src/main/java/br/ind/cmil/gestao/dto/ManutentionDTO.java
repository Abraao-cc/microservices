package br.ind.cmil.gestao.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Administrativo
 */
public record ManutentionDTO(
        Long id,
        int ativoId,
        LocalDate dataManutencao,
        String descricao,
        BigDecimal custo) {

}
