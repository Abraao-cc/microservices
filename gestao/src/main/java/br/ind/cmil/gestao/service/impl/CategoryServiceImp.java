package br.ind.cmil.gestao.service.impl;

import br.ind.cmil.gestao.domain.Category;
import br.ind.cmil.gestao.exception.RecordNotFoundException;
import br.ind.cmil.gestao.dto.CategoryDTO;
import br.ind.cmil.gestao.dto.mapper.CategoryMapper;
import br.ind.cmil.gestao.respositories.CategoryRepository;
import br.ind.cmil.gestao.service.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.List;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrativo
 */
@Service
public class CategoryServiceImp implements CategoryService {

   // private final Category cat;
    private final CategoryRepository categoryRepo;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImp(CategoryRepository categoryRepo, CategoryMapper categoryMapper) {
        this.categoryRepo = categoryRepo;
        this.categoryMapper = categoryMapper;
    }

   

    @Override
    public CategoryDTO save(@Valid @NotNull CategoryDTO categoryDTO) {
        //var category = categoryMapper.toEntity(categoryDTO);
        //categoryRepo.save(category);
        return categoryMapper.toDTO(categoryRepo.save(categoryMapper.toEntity(categoryDTO)));
    }

    @Override
    public void delete(@Positive Long id) {
        categoryRepo.delete(categoryRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.valueOf(id),"Not Found")));
    }

    @Override
    public CategoryDTO findById(@Positive Long id) {
        return categoryRepo.findById(id).map(categoryMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(String.valueOf(id),"Not Found"));
    }

    @Override
    public List<Category> getCategorys() {
        // Page<Category> pageCategory = categoryRepo.findAll(PageRequest.of(page, pageSize));
        //List<CategoryDTO> courses = pageCategory.get().map(categoryMapper::toDTO).collect(Collectors.toList());
        //return new CoursePageDTO(courses, pageCourse.getTotalElements(), pageCourse.getTotalPages());
        return categoryRepo.findAll(Sort.by("id"));
    }

}
