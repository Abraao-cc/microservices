package br.ind.cmil.gestao.service;

import br.ind.cmil.gestao.domain.Category;
import br.ind.cmil.gestao.dto.CategoryDTO;
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
