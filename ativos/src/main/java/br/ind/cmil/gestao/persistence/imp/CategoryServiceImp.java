package br.ind.cmil.gestao.persistence.imp;

import br.ind.cmil.gestao.persistence.model.Category;
import br.ind.cmil.gestao.web.error.RecordNotFoundException;
import br.ind.cmil.gestao.web.dto.CategoryDTO;
import br.ind.cmil.gestao.web.mapper.CategoryMapper;
import br.ind.cmil.gestao.persistence.dao.CategoryRepository;
import br.ind.cmil.gestao.persistence.service.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.List;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public CategoryDTO save(@Valid  CategoryDTO categoryDTO) {
        //return categoryMapper.toDTO(categoryRepo.save(categoryMapper.toEntity(categoryDTO)));
        //var category = categoryMapper.toEntity(categoryDTO);
        //categoryRepo.save(category);
        
         if (categoryDTO.id() == null) {          
           var category = categoryMapper.toEntity(categoryDTO);
            return categoryMapper.toDTO(categoryRepo.save(category));
        }
        return this.update(categoryDTO);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    private CategoryDTO update(CategoryDTO dto) {

        Category category = categoryRepo.findById(dto.id()).get();
        category.setId(dto.id());
        category.setName(dto.name());

        return categoryMapper.toDTO(categoryRepo.save(category));
    }

    @Override
    public void delete(@Positive String id) {
        categoryRepo.delete(categoryRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.valueOf(id), "Not Found")));
    }

    @Override
    public CategoryDTO findById(@Positive String id) {
        return categoryRepo.findById(id).map(categoryMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(String.valueOf(id), "Not Found"));
    }

    @Override
    public List<Category> getCategorys() {
        // Page<Category> pageCategory = categoryRepo.findAll(PageRequest.of(page, pageSize));
        //List<CategoryDTO> courses = pageCategory.get().map(categoryMapper::toDTO).collect(Collectors.toList());
        //return new CoursePageDTO(courses, pageCourse.getTotalElements(), pageCourse.getTotalPages());
        return categoryRepo.findAll(Sort.by("id"));
    }

}
