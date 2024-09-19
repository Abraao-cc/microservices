package br.ind.cmil.gestao.service;

import br.ind.cmil.gestao.dto.AtivoDTO;
import java.util.List;

/**
 *
 * @author Administrativo
 */
public interface AtivoService {

    AtivoDTO save(AtivoDTO ativo);

    void delete(Long id);

    AtivoDTO findById(Long id);

    List<AtivoDTO> getAtivos();
}
