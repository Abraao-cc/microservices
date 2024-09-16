package br.ind.cmil.gestao.services.impl;

import br.ind.cmil.gestao.entitys.Localization;
import br.ind.cmil.gestao.exception.RecordNotFoundException;
import br.ind.cmil.gestao.model.LocalizationDTO;
import br.ind.cmil.gestao.model.mapper.LocalizationMapper;
import br.ind.cmil.gestao.respositorys.LocalizationRepository;
import br.ind.cmil.gestao.services.LocalizationService;
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
public class LocalizationServiceImp implements LocalizationService {

   // private final Category cat;
    private final LocalizationRepository localizationRepo;
    private final LocalizationMapper localizationMapper;

    public LocalizationServiceImp(LocalizationRepository localizationRepo, LocalizationMapper localizationMapper) {
        this.localizationRepo = localizationRepo;
        this.localizationMapper = localizationMapper;
    }

   

    @Override
    public LocalizationDTO save(@Valid @NotNull LocalizationDTO localizationDTO) {
        //var category = categoryMapper.toEntity(categoryDTO);
        //categoryRepo.save(category);
        return localizationMapper.toDTO(localizationRepo.save(localizationMapper.toEntity(localizationDTO)));
    }

    @Override
    public void delete(@Positive Long id) {
        localizationRepo.delete(localizationRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }

    @Override
    public Localization findId(Long id) {
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Localization> getLocalizations() {
        // Page<Category> pageCategory = categoryRepo.findAll(PageRequest.of(page, pageSize));
        //List<CategoryDTO> courses = pageCategory.get().map(categoryMapper::toDTO).collect(Collectors.toList());
        //return new CoursePageDTO(courses, pageCourse.getTotalElements(), pageCourse.getTotalPages());
        return localizationRepo.findAll(Sort.by("id"));
    }

}
