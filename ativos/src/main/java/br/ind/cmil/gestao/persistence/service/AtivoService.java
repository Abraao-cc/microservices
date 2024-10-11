package br.ind.cmil.gestao.persistence.service;

import br.ind.cmil.gestao.web.dto.AtivoDTO;
import java.util.List;

/**
 *
 * @author Administrativo
 */
public interface AtivoService {

    AtivoDTO save(AtivoDTO ativo);

    AtivoDTO update(AtivoDTO ativo);

    void delete(String id);

    AtivoDTO findById(String id);

    List<AtivoDTO> getAtivos();

    //boolean AtivoExists(AtivoDTO ativo);
}
