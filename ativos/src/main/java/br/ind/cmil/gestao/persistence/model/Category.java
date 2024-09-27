
package br.ind.cmil.gestao.persistence.model;

import br.ind.cmil.gestao.persistence.base.EntityID;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 *
 * @author Administrativo
 */
@Entity
@Table(name = "tbl_categorias")
public class Category extends EntityID{
    private String name;

    public Category() {
    }
    public Category(String id) {
        super.setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
}
