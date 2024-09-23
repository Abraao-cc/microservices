package br.ind.cmil.gestao.service.impl;

import br.ind.cmil.gestao.domain.user.User;
import br.ind.cmil.gestao.dto.LoginRequestDTO;
import br.ind.cmil.gestao.dto.ResponseDTO;
import br.ind.cmil.gestao.infra.security.TokenServiceImp;
import br.ind.cmil.gestao.respositories.UserRepository;
import br.ind.cmil.gestao.service.AuthorizationService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrativo
 */
@Service
public class AuthorizationServiceImp implements AuthorizationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenServiceImp tokenService;

    public AuthorizationServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenServiceImp tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

 

    @Override
    @Transactional(readOnly = true)
    public ResponseDTO findByLogin(LoginRequestDTO body) {
        User user = userRepository.findByLogin(body.email()).get();
        if (passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return new ResponseDTO(user.getName(), token);
        }
        return null;
    }
}
