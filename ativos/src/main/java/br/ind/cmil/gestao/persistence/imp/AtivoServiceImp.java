package br.ind.cmil.gestao.persistence.imp;

import br.ind.cmil.gestao.persistence.model.Ativo;
import br.ind.cmil.gestao.persistence.model.Category;
import br.ind.cmil.gestao.persistence.model.Localization;
import br.ind.cmil.gestao.web.dto.AtivoDTO;
import br.ind.cmil.gestao.web.mapper.AtivoMapper;
import br.ind.cmil.gestao.web.error.RecordNotFoundException;
import br.ind.cmil.gestao.persistence.dao.AtivoRepository;
import br.ind.cmil.gestao.persistence.dao.CategoryRepository;
import br.ind.cmil.gestao.persistence.dao.LocalizationRepository;
import br.ind.cmil.gestao.persistence.service.AtivoService;
import jakarta.validation.Valid;

import jakarta.validation.constraints.Positive;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrativo
 */
@Service
public class AtivoServiceImp implements AtivoService {

    private final AtivoRepository ativoReposity;
    private final AtivoMapper ativoMapper;
    private final CategoryRepository categoryRepository;
    private final LocalizationRepository localizationRepository;
    
    private  Category category;
    private  Localization localization;
    

    public AtivoServiceImp(AtivoRepository ativoReposity, AtivoMapper ativoMapper, CategoryRepository categoryRepository, LocalizationRepository localizationRepository) {
        this.ativoReposity = ativoReposity;
        this.ativoMapper = ativoMapper;
        this.categoryRepository = categoryRepository;
        this.localizationRepository = localizationRepository;
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public AtivoDTO save(AtivoDTO ativoDTO) {
        this.category = categoryRepository.findByName(ativoDTO.category());
         this.localization = localizationRepository.findByName(ativoDTO.localization());

        //validarAtributos(ativo);
        if (ativoDTO._id() == null) {
            Ativo ativo = ativoMapper.toEntity(ativoDTO);
            System.out.println("\nCategory : " + ativo.getCategory().getName() + "\tLocalization: " + ativo.getLocalization().getName());
            ativo.setCategory(category);
            ativo.setLocalization(localization);
            return ativoMapper.toDTO(ativoReposity.save(ativo));
        }
        return this.update(ativoDTO);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public AtivoDTO update(AtivoDTO ativo) {
         this.category = categoryRepository.findByName(ativo.category());
         this.localization = localizationRepository.findByName(ativo.localization());
        Ativo _ativo = ativoReposity.findById(ativo._id()).get();
        _ativo.setId(ativo._id());
        _ativo.setName(ativo.name());
        _ativo.setSerie(ativo.serie());
        _ativo.setStatus(ativo.status());
        _ativo.setDatePay(ativo.datePay());
        _ativo.setPrice(ativo.price());
        _ativo.setCategory(category);
        _ativo.setLocalization(localization);

        return ativoMapper.toDTO(ativoReposity.save(_ativo));
    }

    @Override
    public void delete(String id) {
        ativoReposity.delete(ativoReposity.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.valueOf(id), "Not Found")));
    }

    @Override
    public AtivoDTO findById(@Positive String id) {
        return ativoReposity.findById(id).map(ativoMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(String.valueOf(id), "Not Found"));
    }

    @Override
    public List<AtivoDTO> getAtivos() {
        List<Ativo> ativos = ativoReposity.findAll(Sort.by("id"));
        return ativos.stream().map(ativoMapper::toDTO).collect(Collectors.toList());
    }

    private void validarAtributos(Ativo ativo) {
        Optional<Ativo> ativoSave = ativoReposity.findById(ativo.getId());
        if (ativoSave.isPresent() && !Objects.equals(ativoSave.get(), ativo)) {
            throw new DataIntegrityViolationException("ativo já cadastro no sistema!");
        }

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Localization getLocalization() {
        return localization;
    }

    public void setLocalization(Localization localization) {
        this.localization = localization;
    }

   
    
}
