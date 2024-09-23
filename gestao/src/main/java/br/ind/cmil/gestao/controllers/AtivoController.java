package br.ind.cmil.gestao.controllers;

import br.ind.cmil.gestao.dto.AtivoDTO;
import br.ind.cmil.gestao.service.AtivoService;
import br.ind.cmil.gestao.service.CategoryService;
import br.ind.cmil.gestao.service.LocalizationService;
import jakarta.validation.Valid;
import java.util.List;
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
@RequestMapping("ativos")
public class AtivoController {

    private final AtivoService ativoService;
    private final CategoryService categoryService;
    private final LocalizationService localizationService;

    public AtivoController(AtivoService ativoService, CategoryService categoryService, LocalizationService localizationService) {
        this.ativoService = ativoService;
        this.categoryService = categoryService;
        this.localizationService = localizationService;
    }
    
    @GetMapping
    public List<AtivoDTO> getAtivos() {
        return ativoService.getAtivos();
    }

    @PostMapping("/add")
    public void save(@Valid @RequestBody AtivoDTO ativoDTO) {

        this.ativoService.save(ativoDTO);

       
    }

    @PutMapping("/edit")
    public void update(@Valid @RequestBody AtivoDTO ativoDTO) {

        this.ativoService.save(ativoDTO);

       // return "redirect:/ativo/add/";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") final Long id) {
        this.ativoService.delete(id);
        return "redirect:/telefones";
    }

    @GetMapping("/edit/{id}")
    public String findById(@PathVariable("id") Long id) {
        this.ativoService.findById(id);
        return "telefone/telefone";
    }

}
