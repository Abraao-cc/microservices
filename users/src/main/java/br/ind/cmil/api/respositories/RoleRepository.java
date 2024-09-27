package br.ind.cmil.api.respositories;

import br.ind.cmil.api.persistence.model.Role;
import br.ind.cmil.api.domain.user.TypeProfile;
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
public interface RoleRepository extends JpaRepository<Role, String> {

    Role findByName(String name);

    @Override
    void delete(Role role);

    @Query("select p from Role p where  p.type =:type")
    Optional<Role> findByType(TypeProfile type);

    @Query("select p from Role p where  p.type IN :type")
    Set<Role> findByProfiles(Set<String> type);

    @Query(value = "SELECT obj FROM Role obj ",
            countQuery = "SELECT COUNT(obj) FROM Role obj ")
    List<Role> searchAll();

}
