package br.ind.cmil.gestao.respositories;

import br.ind.cmil.gestao.domain.user.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrativo
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("select u from User u where  u.email  =:email")
    Optional<User> findByEmail(String email);

}
