package br.ind.cmil.gestao.persistence.service;

import br.ind.cmil.gestao.persistence.model.Category;
import br.ind.cmil.gestao.web.dto.CategoryDTO;
import java.util.List;

/**
 *
 * @author Administrativo
 */
public interface CategoryService {

    CategoryDTO save(CategoryDTO category);

    void delete(String id);

    CategoryDTO findById(String id);

    List<Category> getCategorys();
}
