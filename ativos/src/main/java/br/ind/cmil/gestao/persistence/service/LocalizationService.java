package br.ind.cmil.gestao.persistence.service;

import br.ind.cmil.gestao.persistence.model.Localization;
import br.ind.cmil.gestao.web.dto.LocalizationDTO;
import java.util.List;

/**
 *
 * @author Administrativo
 */
public interface LocalizationService {

    LocalizationDTO save(LocalizationDTO localizationDTO);

    void delete(String id);

    LocalizationDTO findById(String id);

    List<Localization> getLocalizations();
}
