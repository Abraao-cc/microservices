package br.ind.cmil.gestao.web.controller;

import br.ind.cmil.gestao.persistence.model.Localization;
import br.ind.cmil.gestao.persistence.service.LocalizationService;
import br.ind.cmil.gestao.web.dto.LocalizationDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrativo
 */
@RestController
@RequestMapping
public class LocalizationController {

    private final LocalizationService localizationService;

    public LocalizationController(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    @GetMapping("localizations")
    public ResponseEntity<List<Localization>> list() {

        return new ResponseEntity<>(localizationService.getLocalizations(), HttpStatus.OK);
    }

    @GetMapping("/localization/{id}")
    public LocalizationDTO findById(@PathVariable @Positive String id) {
        return localizationService.findById(id);

    }

    @PostMapping("/localization/add")
    public ResponseEntity<?> create(@RequestBody @Valid LocalizationDTO Localization) {
        try {

            return new ResponseEntity<>(localizationService.save(Localization), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping("/localization/edit")
    public ResponseEntity<?> update(@RequestBody @Valid LocalizationDTO Localization) {

        try {

            return new ResponseEntity<>(localizationService.save(Localization), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping("/localization/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") final String id) {
        this.localizationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
