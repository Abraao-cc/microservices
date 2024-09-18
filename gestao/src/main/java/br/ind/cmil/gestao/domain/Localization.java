package br.ind.cmil.gestao.domain;

import br.ind.cmil.gestao.base.EntidadeID;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 *
 * @author Administrativo
 */
@Entity
@Table(name = "tbl_localizacoes")
public class Localization extends EntidadeID {
    
    private String name;
    
    public Localization() {
    }

    public Localization(Long id) {
        super.setId(id);
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
}
