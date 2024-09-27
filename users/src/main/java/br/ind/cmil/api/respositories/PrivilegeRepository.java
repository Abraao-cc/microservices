package br.ind.cmil.api.respositories;

import br.ind.cmil.api.persistence.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrativo
 */
@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, String> {

    Privilege findByName(String name);

    @Override
    void delete(Privilege privilege);
}
