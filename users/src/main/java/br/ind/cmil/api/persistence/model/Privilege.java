
package br.ind.cmil.api.persistence.model;

import br.ind.cmil.api.base.EntityID;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Collection;

/**
 *
 * @author Administrativo
 */
@Entity
@Table(name = "tbl_privileges")
public class Privilege extends EntityID {
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;

    public Privilege(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
    
    
}
