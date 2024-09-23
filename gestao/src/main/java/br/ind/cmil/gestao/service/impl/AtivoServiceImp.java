package br.ind.cmil.gestao.service.impl;

import br.ind.cmil.gestao.domain.Ativo;
import br.ind.cmil.gestao.domain.Category;
import br.ind.cmil.gestao.domain.Localization;
import br.ind.cmil.gestao.dto.AtivoDTO;
import br.ind.cmil.gestao.dto.mapper.AtivoMapper;
import br.ind.cmil.gestao.exception.RecordNotFoundException;
import br.ind.cmil.gestao.respositories.AtivoRepository;
import br.ind.cmil.gestao.service.AtivoService;

import jakarta.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrativo
 */
@Service
public class AtivoServiceImp implements AtivoService {

    @Autowired
    private AtivoRepository ativoReposity;
    @Autowired
    private AtivoMapper ativoMapper;

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public AtivoDTO save(AtivoDTO ativo) {
        if (ativo.id() == null) {          
            Ativo a = ativoMapper.toEntity(ativo);
            return ativoMapper.toDTO(ativoReposity.save(a));
        }
        return this.update(ativo);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    private AtivoDTO update(AtivoDTO dto) {

        Ativo ativo = ativoReposity.findById(dto.id()).get();
        ativo.setId(dto.id());
        ativo.setName(dto.name());
        ativo.setSerie(dto.serie());
        ativo.setStatus(dto.status());
        ativo.setDatePay(dto.datePay());
        ativo.setPrice(dto.price());
        ativo.setCategory(new Category(dto.category()));
        ativo.setLocal(new Localization(dto.local()));

        return ativoMapper.toDTO(ativoReposity.save(ativo));
    }

    @Override
    public void delete(Long id) {
        ativoReposity.delete(ativoReposity.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.valueOf(id),"Not Found")));
    }

    @Override
    public AtivoDTO findById(@Positive Long id) {
        return ativoReposity.findById(id).map(ativoMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(String.valueOf(id),"Not Found"));
    }

    @Override
    public List<AtivoDTO> getAtivos() {
        List<Ativo> ativos = ativoReposity.findAll(Sort.by("id"));
        return ativos.stream().map(ativoMapper::toDTO).collect(Collectors.toList());
    }

   

}
