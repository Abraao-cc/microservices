package br.ind.cmil.gestao.web.mapper;

import br.ind.cmil.gestao.persistence.model.Ativo;
import br.ind.cmil.gestao.persistence.model.Category;
import br.ind.cmil.gestao.persistence.model.Localization;
import br.ind.cmil.gestao.web.dto.AtivoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrativo
 */
@Component
public class AtivoMapper {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private LocalizationMapper localizationMapper;

    public AtivoDTO toDTO(Ativo ativo) {
        if (ativo == null) {
            return null;
        }

        Category category = (ativo.getCategory().getId() != null) ? ativo.getCategory() : null;
        Localization localization = (ativo.getLocal().getId() != null) ? ativo.getLocal() : null;
        return new AtivoDTO(ativo.getId(), ativo.getName(), ativo.getSerie(), ativo.getStatus(), ativo.getPrice(), ativo.getDatePay(), this.categoryMapper.toDTO(category), this.localizationMapper.toDTO(localization));
    }

    public Ativo toEntity(AtivoDTO dto) {

        if (dto == null) {
            return null;
        }

        Ativo ativo = new Ativo();
        if (dto.id() != null) {
            ativo.setId(dto.id());
        }
        ativo.setName(dto.name());
        ativo.setSerie(dto.serie());
        ativo.setStatus(dto.status());
        ativo.setDatePay(dto.datePay());
        ativo.setPrice(dto.price());
        ativo.setCategory(new Category(dto.category().id()));
        ativo.setLocal(new Localization(dto.localization().id()));

        return ativo;
    }

}
