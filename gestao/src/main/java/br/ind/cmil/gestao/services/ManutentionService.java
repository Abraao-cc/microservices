package br.ind.cmil.gestao.services;

import br.ind.cmil.gestao.entitys.Manutention;
import br.ind.cmil.gestao.model.ManutentionDTO;
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
