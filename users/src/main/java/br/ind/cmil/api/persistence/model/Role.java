package br.ind.cmil.api.persistence.model;

import br.ind.cmil.api.converts.ProfileConvert;
import br.ind.cmil.api.base.EntityID;
import br.ind.cmil.api.persistence.model.Privilege;
import br.ind.cmil.api.domain.user.TypeProfile;
import br.ind.cmil.api.persistence.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Collection;

/**
 *
 * @author Administrativo
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "tbl_roles")
public class Role extends EntityID {

    @Column(name = "role", nullable = false, unique = true)
    @Convert(converter = ProfileConvert.class)
    private TypeProfile type;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @ManyToMany
    @JoinTable(
            name = "tbl_roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;

    public Role() {

    }
    

    public Role(String id) {
        super.setId(id);
    }

    public Role(TypeProfile type) {
        this.type = type;
    }

    public TypeProfile getType() {
        return type;
    }

    public void setType(TypeProfile type) {
        this.type = type;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }

}
