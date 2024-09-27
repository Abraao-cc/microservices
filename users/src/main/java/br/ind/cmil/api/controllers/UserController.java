
package br.ind.cmil.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrativo
 */
@RestController
@RequestMapping("/user")
public class UserController {
   @GetMapping
    public ResponseEntity<String> getUser() { 
        return ResponseEntity.ok("Success!");
    }
}
