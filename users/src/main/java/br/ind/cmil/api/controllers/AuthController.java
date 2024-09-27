package br.ind.cmil.api.controllers;

import br.ind.cmil.api.persistence.model.User;
import br.ind.cmil.api.dto.LoginRequestDTO;
import br.ind.cmil.api.dto.RegisterUserDTO;
import br.ind.cmil.api.dto.ResponseDTO;
import br.ind.cmil.api.security.TokenServiceImp;
import br.ind.cmil.api.respositories.UserRepository;
import br.ind.cmil.api.service.AuthorizationService;
import br.ind.cmil.api.service.UserService;
import jakarta.validation.Valid;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrativo
 */
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthorizationService authorizationService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@Valid @RequestBody LoginRequestDTO body) {
        /**
         * User user = (User) userService.findByLogin(body.email()).get(); if
         * (passwordEncoder.matches(body.password(), user.getPassword())) {
         * String token = this.tokenService.generateToken(user);
         *
         * return ResponseEntity.ok(new ResponseDTO(user.getName(), token)); }
         */

        // return ResponseEntity.badRequest().build();
        ResponseDTO response = authorizationService.findByLogin(body);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@Valid @RequestBody RegisterUserDTO body) {
        ResponseDTO response = userService.save(body);

        return ResponseEntity.ok(response);

        //}
        //return ResponseEntity.badRequest().build();
    }

    @PutMapping("/edit")
    public void update(@RequestBody RegisterUserDTO ativoDTO) {

        //this.userService.save(ativoDTO);
        // return "redirect:/ativo/add/";
    }

}
