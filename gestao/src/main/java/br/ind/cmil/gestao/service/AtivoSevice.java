package br.ind.cmil.gestao.service;

import br.ind.cmil.gestao.domain.Ativo;
import br.ind.cmil.gestao.dto.AtivoDTO;
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
