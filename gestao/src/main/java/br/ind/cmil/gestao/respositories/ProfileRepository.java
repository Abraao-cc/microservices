package br.ind.cmil.gestao.respositories;

import br.ind.cmil.gestao.domain.user.RoleUser;
import br.ind.cmil.gestao.domain.user.TypeProfile;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrativo
 */
@Repository
public interface ProfileRepository extends JpaRepository<RoleUser, String> {

    @Query("select p from Profile p where  p.type =:type")
    Optional<RoleUser> findByType(TypeProfile type);

    @Query("select p from Profile p where  p.type IN :type")
    Set<RoleUser> findByProfiles(Set<String> type);

    @Query(value = "SELECT obj FROM Profile obj ",
            countQuery = "SELECT COUNT(obj) FROM Profile obj ")
    List<RoleUser> searchAll();

}
