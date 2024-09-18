package br.ind.cmil.gestao.service;

import br.ind.cmil.gestao.domain.Localization;
import br.ind.cmil.gestao.dto.LocalizationDTO;
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
