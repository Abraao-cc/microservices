
package br.ind.cmil.gestao.entitys;

import br.ind.cmil.gestao.base.EntidadeID;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 *
 * @author Administrativo
 */
@Entity
@Table(name = "tbl_categorias")
public class Category extends EntidadeID{
    private String name;

    public Category() {
    }
    public Category(Long id) {
        super.setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
}
