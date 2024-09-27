package br.ind.cmil.gestao.persistence.service;

import br.ind.cmil.gestao.persistence.model.Manutention;
import br.ind.cmil.gestao.web.dto.ManutentionDTO;
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
