package br.ind.cmil.gestao.web.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

/**
 *
 * @author Administrativo
 */
public record AtivoDTO(
        String _id,
        String name,
        String serie,
        String status,
        @NumberFormat(pattern = "#,##0.00", style = NumberFormat.Style.CURRENCY)
        BigDecimal price,
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate datePay,
        String category,
        String localization) {

}
