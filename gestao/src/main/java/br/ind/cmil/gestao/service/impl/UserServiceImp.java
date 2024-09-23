package br.ind.cmil.gestao.service.impl;

import br.ind.cmil.gestao.domain.user.User;
import br.ind.cmil.gestao.dto.RegisterUserDTO;
import br.ind.cmil.gestao.dto.ResponseDTO;
import br.ind.cmil.gestao.dto.mapper.UserMapper;
import br.ind.cmil.gestao.infra.security.TokenServiceImp;
import br.ind.cmil.gestao.respositories.UserRepository;
import br.ind.cmil.gestao.service.UserService;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrativo
 */
@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final TokenServiceImp tokenService;
    //private final PasswordEncoder passwordEncoder;

    public UserServiceImp(UserRepository userRepository, UserMapper userMapper, TokenServiceImp tokenService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.tokenService = tokenService;
    }

   

    

    @Override
    public ResponseDTO save(RegisterUserDTO dto) {
        Optional<User> user = userRepository.findByEmail(dto.email());
        if (user.isEmpty()) {
            User newUser = userMapper.toEntity(dto);
            //newUser.setName(dto.name());
            //newUser.setEmail(dto.email());
            //newUser.setPassword(passwordEncoder.encode(dto.password()));
            this.userRepository.save(newUser);
            String token = this.tokenService.generateToken(newUser);
            return new ResponseDTO(newUser.getEmail(), token);
        }
        return null;
    }

    @Override
    public void editPassword(User user, String password1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void activate(String code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseDTO findByEmail(String login) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean checkCode(String verificationCode) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
