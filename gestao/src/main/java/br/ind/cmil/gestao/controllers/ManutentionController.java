
package br.ind.cmil.gestao.controllers;

import br.ind.cmil.gestao.service.ManutentionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrativo
 */
@RestController
@RequestMapping("manutention")
public class ManutentionController {
    private ManutentionService manutentionService;
}
