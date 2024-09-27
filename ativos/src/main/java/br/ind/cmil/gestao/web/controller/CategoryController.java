package br.ind.cmil.gestao.web.controller;

import br.ind.cmil.gestao.persistence.model.Category;
import br.ind.cmil.gestao.web.dto.CategoryDTO;
import br.ind.cmil.gestao.persistence.service.CategoryService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrativo
 */
@RestController
@RequestMapping("categorys")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> list() {
        return categoryService.getCategorys();
    }

    @GetMapping("/{id}")
    public CategoryDTO findById(@PathVariable String id) {
        return categoryService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CategoryDTO create(@RequestBody @Valid CategoryDTO category) {
        return categoryService.save(category);
    }

    @PutMapping("/edit")
    public CategoryDTO update(@RequestBody @Valid CategoryDTO category) {
        return categoryService.save(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        categoryService.delete(id);
    }
}
