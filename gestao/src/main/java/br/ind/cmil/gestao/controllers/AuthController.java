package br.ind.cmil.gestao.controllers;

import br.ind.cmil.gestao.domain.user.User;
import br.ind.cmil.gestao.dto.LoginRequestDTO;
import br.ind.cmil.gestao.dto.RegisterRequestDTO;
import br.ind.cmil.gestao.dto.ResponseDTO;
import br.ind.cmil.gestao.infra.security.TokenServiceImp;
import br.ind.cmil.gestao.respositories.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenServiceImp tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {
        User user = userRepository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User Not Found"));
        if (passwordEncoder.matches( body.password(),user.getPassword())) {
            String token = this.tokenService.generateToken(user);

            return ResponseEntity.ok(new ResponseDTO(user.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body) {

        Optional<User> user = userRepository.findByEmail(body.email());
        if (user.isEmpty()) {
            User newUser = new User();
            newUser.setName(body.name());
            newUser.setEmail(body.email());
            newUser.setPassword(passwordEncoder.encode(body.password()));
            this.userRepository.save(newUser);
            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getName(), token));

        }

        return ResponseEntity.badRequest().build();
    }
}
