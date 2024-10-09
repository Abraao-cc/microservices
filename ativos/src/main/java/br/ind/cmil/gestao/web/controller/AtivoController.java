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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrativo
 */
@RestController
@RequestMapping("/ativos")
public class AtivoController {

    private final AtivoService ativoService;

    public AtivoController(AtivoService ativoService) {
        this.ativoService = ativoService;
    }

    @GetMapping
    public ResponseEntity<List<AtivoDTO>> getAtivos() {

        return new ResponseEntity<>(ativoService.getAtivos(), HttpStatus.OK);
    }

    @PostMapping("/ativo/add")
    public ResponseEntity<?> create(@RequestBody @Valid AtivoDTO ativoDTO) {

        try {

            return new ResponseEntity<>(ativoService.save(ativoDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @PutMapping("/ativo/edit")
    public void update(@Valid @RequestBody AtivoDTO ativoDTO) {

        this.ativoService.save(ativoDTO);

        // return "redirect:/ativo/add/";
    }

    @DeleteMapping("/ativo/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") final String id) {
        this.ativoService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/ativo/edit/{id}")
    public String findById(@PathVariable("id") String id) {
        this.ativoService.findById(id);
        return "telefone/telefone";
    }

}
