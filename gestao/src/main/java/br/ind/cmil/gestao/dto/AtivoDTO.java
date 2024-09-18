package br.ind.cmil.gestao.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Administrativo
 */
public record AtivoDTO(
        Long id,
        String name, 
        String status,
        BigDecimal price,
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate datePay,
        Long category,
        Long local) {

}
