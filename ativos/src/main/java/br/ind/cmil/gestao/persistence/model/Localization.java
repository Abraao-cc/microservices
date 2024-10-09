package br.ind.cmil.gestao.persistence.model;

import br.ind.cmil.gestao.persistence.base.EntityID;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 *
 * @author Administrativo
 */
@Entity
@Table(name = "tbl_localizacoes")
public class Localization extends EntityID {
    
    private String name;
    
    public Localization() {
    }

    public Localization(String name) {
        this.name = name;
    }

   
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
}
