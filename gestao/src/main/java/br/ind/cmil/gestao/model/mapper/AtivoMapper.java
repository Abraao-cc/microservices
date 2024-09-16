package br.ind.cmil.gestao.model.mapper;

import br.ind.cmil.gestao.entitys.Ativo;
import br.ind.cmil.gestao.entitys.Category;
import br.ind.cmil.gestao.entitys.Localization;
import br.ind.cmil.gestao.model.AtivoDTO;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrativo
 */
@Component
public class AtivoMapper {

    public AtivoDTO toDTO(Ativo ativo) {
        if (ativo == null) {
            return null;
        }
        long category = (ativo.getCategory().getId() !=null)? ativo.getCategory().getId(): null;
        long localization = (ativo.getLocal().getId() !=null)? ativo.getLocal().getId(): null;
        return new AtivoDTO(ativo.getId(), ativo.getName(), ativo.getStatus(),  ativo.getPrice(),ativo.getDatePay(),category, localization);
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
        ativo.setStatus(dto.status());
        ativo.setDatePay(dto.datePay());
        ativo.setCategory(new Category(dto.category()));
        ativo.setLocal(new Localization(dto.local()));

        return ativo;
    }

}
