
package br.ind.cmil.gestao.persistence.dao;

import br.ind.cmil.gestao.persistence.model.Localization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrativo
 */
@Repository
public interface LocalizationRepository extends JpaRepository<Localization,String> {
    
}
