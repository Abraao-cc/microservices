package br.ind.cmil.gestao.services;

import br.ind.cmil.gestao.entitys.Ativo;
import br.ind.cmil.gestao.model.AtivoDTO;
import java.util.List;

/**
 *
 * @author Administrativo
 */
public interface AtivoSevice {

    void save(AtivoDTO ativo);

    void delete(Long id);

    Ativo findId(Long id);

    List<Ativo> getAtivos();
}
