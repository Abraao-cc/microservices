package br.ind.cmil.gestao.dto.mapper;

import br.ind.cmil.gestao.domain.Ativo;
import br.ind.cmil.gestao.domain.Category;
import br.ind.cmil.gestao.domain.Localization;
import br.ind.cmil.gestao.dto.AtivoDTO;
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
        return new AtivoDTO(ativo.getId(), ativo.getName(),ativo.getSerie(), ativo.getStatus(),  ativo.getPrice(),ativo.getDatePay(),category, localization);
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
        ativo.setCategory(new Category(dto.category()));
        ativo.setLocal(new Localization(dto.local()));

        return ativo;
    }

}
