package br.ind.cmil.api.service;

import br.ind.cmil.api.dto.ProfileDTO;
import java.util.Set;

/**
 *
 * @author Administrativo
 */
public interface RoleService {

    ProfileDTO save(ProfileDTO dto);

    ProfileDTO findById(String id);

    Set<ProfileDTO> profiles();

    void delete(String id);

    /*ProfileDTO findByName(String name);
    String tipoPerfil(String tipo);
    Set<ProfileDTO> list(Pageable pageable);
     List<Profile> perfis(List<String> perfil);*/
}
