package br.ind.cmil.gestao.service;

import br.ind.cmil.gestao.domain.Manutention;
import br.ind.cmil.gestao.dto.ManutentionDTO;
import java.util.List;

/**
 *
 * @author Administrativo
 */
public interface ManutentionService {

    void save(ManutentionDTO manutention);

    void delete(Long id);

    Manutention findId(Long id);

    List<Manutention> getAtivos();
}
