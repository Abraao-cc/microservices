package br.ind.cmil.api.persistence.dao;

import br.ind.cmil.api.persistence.model.User;
import br.ind.cmil.api.persistence.model.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Administrativo
 */
public interface UserLocationRepository extends JpaRepository<UserLocation, String> {

    UserLocation findByCountryAndUser(String country, User user);

}
