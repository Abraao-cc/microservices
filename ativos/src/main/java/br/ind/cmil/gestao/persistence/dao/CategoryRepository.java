package br.ind.cmil.gestao.persistence.dao;

import br.ind.cmil.gestao.persistence.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrativo
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    @Query("select c from Category c where c.name = :name")
    Category findByName(String name);

}
