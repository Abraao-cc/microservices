package br.ind.cmil.gestao.persistence.imp;

import br.ind.cmil.gestao.persistence.model.Localization;
import br.ind.cmil.gestao.web.error.RecordNotFoundException;
import br.ind.cmil.gestao.web.dto.LocalizationDTO;
import br.ind.cmil.gestao.web.mapper.LocalizationMapper;
import br.ind.cmil.gestao.persistence.dao.LocalizationRepository;
import br.ind.cmil.gestao.persistence.service.LocalizationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public LocalizationDTO save(@Valid LocalizationDTO localizationDTO) {
        //return localizationMapper.toDTO(localizationRepo.save(localizationMapper.toEntity(localizationDTO)));

        if (localizationDTO.id() == null) {
            var localization = localizationMapper.toEntity(localizationDTO);
            return localizationMapper.toDTO(localizationRepo.save(localization));
        }
        return this.update(localizationDTO);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    private LocalizationDTO update(LocalizationDTO dto) {

        Localization localization = localizationRepo.findById(dto.id()).get();
        localization.setId(dto.id());
        localization.setName(dto.name());

        return localizationMapper.toDTO(localizationRepo.save(localization));
    }

    @Override
    public void delete(@Positive String id) {
        localizationRepo.delete(localizationRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.valueOf(id), "Not Found")));
    }

    @Override
    public LocalizationDTO findById(String id) {
        return localizationRepo.findById(id).map(localizationMapper::toDTO).orElseThrow(() -> new RecordNotFoundException(String.valueOf(id), "Not Found"));
    }

    @Override
    public List<Localization> getLocalizations() {
        // Page<Localization> pageLocalization = localizationRepo.findAll(PageRequest.of(page, pageSize));
        //List<LocalizationDTO> localizations = pageLocalization.get().map(localizationMapper::toDTO).collect(Collectors.toList());
        //return new LocalizationDTO(localizations, pageCourse.getTotalElements(), pageLocalization.getTotalPages());
        return localizationRepo.findAll(Sort.by("id"));
    }

}
