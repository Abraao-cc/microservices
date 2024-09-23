package br.ind.cmil.gestao.dto.mapper;

import br.ind.cmil.gestao.domain.user.RoleUser;
import br.ind.cmil.gestao.domain.user.TypeProfile;
import br.ind.cmil.gestao.dto.ProfileDTO;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrativo
 */
@Component
public class ProfileMapper {

    public ProfileDTO toDTO(RoleUser p) {
        if (p == null) {
            return null;
        }

        return new ProfileDTO(p.getId(), p.getType().getValue());
    }

    public RoleUser toEntity(ProfileDTO dto) {
        if (dto == null) {
            return null;
        }
        RoleUser p = new RoleUser();
        p.setType(TypeProfile.convertProfileValue(dto.type()));
        return p;
    }

}
