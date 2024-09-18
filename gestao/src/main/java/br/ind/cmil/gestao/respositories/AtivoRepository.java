package br.ind.cmil.gestao.respositories;

import br.ind.cmil.gestao.domain.Ativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrativo
 */
@Repository
public interface AtivoRepository extends JpaRepository<Ativo, Long> {

}
