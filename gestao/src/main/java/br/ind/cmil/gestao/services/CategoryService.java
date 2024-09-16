package br.ind.cmil.gestao.services;

import br.ind.cmil.gestao.entitys.Category;
import br.ind.cmil.gestao.model.CategoryDTO;
import java.util.List;

/**
 *
 * @author Administrativo
 */
public interface CategoryService {

    CategoryDTO save(CategoryDTO category);

    void delete(Long id);

    CategoryDTO findById(Long id);

    List<Category> getCategorys();
}
