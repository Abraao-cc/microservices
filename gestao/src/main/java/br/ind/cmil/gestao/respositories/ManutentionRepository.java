
package br.ind.cmil.gestao.respositories;

import br.ind.cmil.gestao.domain.Manutention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrativo
 */
@Repository
public interface ManutentionRepository extends JpaRepository<Manutention,Long> {
    
}
