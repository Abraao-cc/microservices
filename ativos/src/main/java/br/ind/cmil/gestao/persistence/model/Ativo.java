package br.ind.cmil.gestao.persistence.model;

import br.ind.cmil.gestao.persistence.base.EntityID;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

/**
 *
 * @author Administrativo
 */
@Entity
@Table(name = "tbl_ativos")
public class Ativo extends EntityID {

    private String name;
    private String serie;
    private Category category;
    private Localization local;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePay;
    @NumberFormat(pattern = "#,##0.00", style = NumberFormat.Style.CURRENCY)
    private BigDecimal price;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ativo{");
        sb.append("name=").append(name);
        sb.append(", serie=").append(serie);
        sb.append(", category=").append(category);
        sb.append(", local=").append(local);
        sb.append(", datePay=").append(datePay);
        sb.append(", price=").append(price);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }

   

}
