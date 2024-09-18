
package br.ind.cmil.gestao.controllers;

import br.ind.cmil.gestao.domain.Category;
import br.ind.cmil.gestao.dto.CategoryDTO;
import br.ind.cmil.gestao.service.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.List;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
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
@Validated
@RestController
@RequestMapping("/api/categorys")
public class CategoryController {
     private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

   

    @GetMapping
    public List<Category> list() {
        return categoryService.getCategorys();
    }

    // @GetMapping
    // public List<CourseDTO> list() {
    // return courseService.list();
    // }

    @GetMapping("/{id}")
    public CategoryDTO findById(@PathVariable @NotNull @Positive Long id) {
        return categoryService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CategoryDTO create(@RequestBody @Valid @NotNull CategoryDTO category) {
        return categoryService.save(category);
    }

    @PutMapping("/{id}")
    public CategoryDTO update(@PathVariable @NotNull @Positive Long id,
            @RequestBody @Valid @NotNull CategoryDTO course) {
        return categoryService.save(course);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        categoryService.delete(id);
    }
}
