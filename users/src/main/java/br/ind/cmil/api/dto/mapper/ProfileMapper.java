package br.ind.cmil.api.dto.mapper;

import br.ind.cmil.api.persistence.model.Role;
import br.ind.cmil.api.domain.user.TypeProfile;
import br.ind.cmil.api.dto.ProfileDTO;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrativo
 */
@Component
public class ProfileMapper {

    public ProfileDTO toDTO(Role p) {
        if (p == null) {
            return null;
        }

        return new ProfileDTO(p.getId(), p.getType().getValue());
    }

    public Role toEntity(ProfileDTO dto) {
        if (dto == null) {
            return null;
        }
        Role p = new Role();
        p.setType(TypeProfile.convertProfileValue(dto.type()));
        return p;
    }

}
