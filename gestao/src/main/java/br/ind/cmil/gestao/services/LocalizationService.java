package br.ind.cmil.gestao.services;

import br.ind.cmil.gestao.entitys.Localization;
import br.ind.cmil.gestao.model.LocalizationDTO;
import java.util.List;

/**
 *
 * @author Administrativo
 */
public interface LocalizationService {

    LocalizationDTO save(LocalizationDTO localizationDTO);

    void delete(Long id);

    Localization findId(Long id);

    List<Localization> getLocalizations();
}
