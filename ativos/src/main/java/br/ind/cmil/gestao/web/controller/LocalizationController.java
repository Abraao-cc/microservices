
package br.ind.cmil.gestao.web.controller;

import br.ind.cmil.gestao.persistence.model.Localization;
import br.ind.cmil.gestao.persistence.service.LocalizationService;
import br.ind.cmil.gestao.web.dto.LocalizationDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.List;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrativo
 */

@RestController
@RequestMapping("localizations")
public class LocalizationController {
     private final LocalizationService localizationService;

    public LocalizationController(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    @GetMapping
    public List<Localization> list() {
        return localizationService.getLocalizations();
    }

 
    @GetMapping("/{id}")
    public LocalizationDTO findById(@PathVariable  @Positive String id) {
        return localizationService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public LocalizationDTO create(@RequestBody @Valid  LocalizationDTO Localization) {
        return localizationService.save(Localization);
    }

    @PutMapping("/edit")
    public LocalizationDTO update(@RequestBody @Valid LocalizationDTO Localization) {
        return localizationService.save(Localization);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive String id) {
        localizationService.delete(id);
    }
}
