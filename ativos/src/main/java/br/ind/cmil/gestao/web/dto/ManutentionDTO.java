package br.ind.cmil.gestao.web.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Administrativo
 */
public record ManutentionDTO(
        String id,
        int ativoId,
        LocalDate dataManutencao,
        String descricao,
        BigDecimal custo) {

}
