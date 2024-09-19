package br.ind.cmil.gestao.service.impl;

import br.ind.cmil.gestao.domain.user.User;
import br.ind.cmil.gestao.dto.LoginRequestDTO;
import br.ind.cmil.gestao.dto.RegisterRequestDTO;
import br.ind.cmil.gestao.dto.mapper.UserMapper;
import br.ind.cmil.gestao.respositories.UserRepository;
import br.ind.cmil.gestao.service.UserService;
import java.time.LocalDateTime;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrativo
 */
@Transactional
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;
    private UserMapper rm;

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void save(RegisterRequestDTO request) {
      //validarAtributos(request);

        //User user = rm.toEntity(request);
        User user = new User();
        if (user.getId() != null) {
            update(user);
        }

        userRepository.save(user);
    }
     public void update(User request) {
        User user = userRepository.findById(request.getId()).get();
        user.setName(request.getName());
        user.setRegistrationDate(user.getRegistrationDate());
        user.setUpdatedAt(LocalDateTime.now());
        user.setEmail(request.getEmail());
        user.setAtivo(request.isAtivo());
        user.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
        user.setChecker(request.getChecker());
       // List<Perfil> perfis = request.getPerfis().stream().map(perfil -> perfil).collect(Collectors.toList());
        // List<Perfil> roles = ps.perfis(request.getPerfis());
        user.setProfiles(request.getProfiles());
        user.setId(request.getId());
        userRepository.save(user);
    }
//.orElseThrow(() -> new RuntimeException("User Not Found"));
    @Override
    public LoginRequestDTO findByEmailOrName(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Set<RegisterRequestDTO> getUsers(Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editPassword(User user, String password1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void atived(String code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean verify(String verificationCode) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
