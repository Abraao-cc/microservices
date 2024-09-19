package br.ind.cmil.gestao.service;

import br.ind.cmil.gestao.domain.user.User;
import br.ind.cmil.gestao.dto.LoginRequestDTO;
import br.ind.cmil.gestao.dto.RegisterRequestDTO;
import java.util.Set;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Administrativo
 */
public interface UserService {

    void save(RegisterRequestDTO dto);

    LoginRequestDTO findByEmailOrName(String email);

    Set<RegisterRequestDTO> getUsers(Pageable pageable);

    public static boolean isPasswordCorret(String newPassword, String oldPassword) {
        return new BCryptPasswordEncoder().matches(newPassword, oldPassword);
    }

    void editPassword(User user, String password1);

    // void resetPassword(String email) throws MessagingException;
    void atived(String code);

    boolean verify(String verificationCode);

}
