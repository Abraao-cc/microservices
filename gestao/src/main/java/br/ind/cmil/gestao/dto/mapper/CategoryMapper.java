package br.ind.cmil.gestao.dto.mapper;

import br.ind.cmil.gestao.domain.Category;
import br.ind.cmil.gestao.dto.CategoryDTO;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrativo
 */
@Component
public class CategoryMapper {

    public CategoryDTO toDTO(Category category) {
        if (category == null) {
            return null;
        }

        return new CategoryDTO(category.getId(), category.getName());
    }

    public Category toEntity(CategoryDTO categoryDTO) {

        if (categoryDTO == null) {
            return null;
        }

        Category category = new Category();
        if (categoryDTO.id() != null) {
            category.setId(categoryDTO.id());
        }
        category.setName(categoryDTO.name());

        return category;
    }

}
