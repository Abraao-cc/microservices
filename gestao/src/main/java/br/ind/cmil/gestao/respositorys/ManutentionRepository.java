
package br.ind.cmil.gestao.respositorys;

import br.ind.cmil.gestao.entitys.Manutention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrativo
 */
@Repository
public interface ManutentionRepository extends JpaRepository<Manutention,Long> {
    
}
