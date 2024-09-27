
package br.ind.cmil.gestao.web.controller;

import br.ind.cmil.gestao.persistence.service.ManutentionService;
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
