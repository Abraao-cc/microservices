package br.ind.cmil.gestao.respositories;

import br.ind.cmil.gestao.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrativo
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
