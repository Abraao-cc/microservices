package br.ind.cmil.gestao.domain.user;

import br.ind.cmil.gestao.converts.ProfileConvert;
import br.ind.cmil.gestao.base.UserAndProfileID;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 *
 * @author Administrativo
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "tbl_profiles")
public class Profile extends UserAndProfileID {

    @Column(name = "profile", nullable = false, unique = true)
    @Convert(converter = ProfileConvert.class)
    private TypeProfile type;

    public Profile() {
        
    }
    public Profile(String id) {
       super.setId(id);
    }
    public Profile(TypeProfile type) {
        this.type = type;
    }

    public TypeProfile getType() {
        return type;
    }

    public void setType(TypeProfile type) {
        this.type = type;
    }
    
    
}
