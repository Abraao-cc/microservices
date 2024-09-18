package br.ind.cmil.gestao.domain;

import br.ind.cmil.gestao.base.EntidadeID;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Administrativo
 */
@Entity
@Table(name = "tbl_manutencoes")
public class Manutention extends EntidadeID {

    private int ativoId;
    private LocalDate dataManutencao;
    private String descricao;
    private BigDecimal custo;

    public int getAtivoId() {
        return ativoId;
    }

    public void setAtivoId(int ativoId) {
        this.ativoId = ativoId;
    }

    public LocalDate getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao(LocalDate dataManutencao) {
        this.dataManutencao = dataManutencao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }
    
    
    
    
}
