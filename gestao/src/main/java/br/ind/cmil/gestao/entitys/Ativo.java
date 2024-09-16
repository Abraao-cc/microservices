package br.ind.cmil.gestao.entitys;

import br.ind.cmil.gestao.base.EntidadeID;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Administrativo
 */
@Entity
@Table(name = "tbl_ativos")
public class Ativo extends EntidadeID {

    private String name;
    private Category category;
    private Localization local;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePay;
    private BigDecimal price;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Localization getLocal() {
        return local;
    }

    public void setLocal(Localization local) {
        this.local = local;
    }

    public LocalDate getDatePay() {
        return datePay;
    }

    public void setDatePay(LocalDate datePay) {
        this.datePay = datePay;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
