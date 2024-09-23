package br.ind.cmil.gestao.service;

import br.ind.cmil.gestao.dto.ProfileDTO;
import java.util.Set;

/**
 *
 * @author Administrativo
 */
public interface ProfileService {

    ProfileDTO save(ProfileDTO dto);

    ProfileDTO findById(String id);

    Set<ProfileDTO> profiles();

    void delete(String id);

    /*ProfileDTO findByName(String name);
    String tipoPerfil(String tipo);
    Set<ProfileDTO> list(Pageable pageable);
     List<Profile> perfis(List<String> perfil);*/
}
