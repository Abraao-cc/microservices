package br.ind.cmil.gestao.web.controller;

import br.ind.cmil.gestao.web.dto.AtivoDTO;
import br.ind.cmil.gestao.persistence.service.AtivoService;
import jakarta.validation.Valid;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrativo
 */
@RestController
@RequestMapping("/ativo")
public class AtivoController {

    private final AtivoService ativoService;

    public AtivoController(AtivoService ativoService) {
        this.ativoService = ativoService;
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<AtivoDTO>> getAtivos() {
        List<AtivoDTO> ativos = ativoService.getAtivos();
        if (ativos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ativos, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<AtivoDTO> create(@RequestBody @Valid AtivoDTO ativoDTO) {

        try {

            return new ResponseEntity<>(ativoService.save(ativoDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @PutMapping("/edit")
    public ResponseEntity<AtivoDTO> update(@Valid @RequestBody AtivoDTO ativoDTO) {

        AtivoDTO ativoSave = ativoService.save(ativoDTO);

        if (!ativoSave._id().isEmpty()) {

            return new ResponseEntity<>(ativoSave, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") final String id) {
        this.ativoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtivoDTO> getArticleById(@RequestParam("id") String id) {

        return new ResponseEntity<>(ativoService.findById(id), HttpStatus.OK);
    }

}
