package br.ind.cmil.gestao.model.mapper;

import br.ind.cmil.gestao.entitys.Localization;
import br.ind.cmil.gestao.model.LocalizationDTO;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrativo
 */
@Component
public class LocalizationMapper {

    public LocalizationDTO toDTO(Localization localization) {
        if (localization == null) {
            return null;
        }

        return new LocalizationDTO(localization.getId(), localization.getName());
    }

    public Localization toEntity(LocalizationDTO categoryDTO) {

        if (categoryDTO == null) {
            return null;
        }

        Localization localization = new Localization();
        if (categoryDTO.id() != null) {
            localization.setId(categoryDTO.id());
        }
        localization.setName(categoryDTO.name());

        return localization;
    }

}
