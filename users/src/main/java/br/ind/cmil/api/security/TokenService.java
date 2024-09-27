
package br.ind.cmil.api.security;

import br.ind.cmil.api.persistence.model.User;

/**
 *
 * @author Administrativo
 */
public interface TokenService {
    String generateToken(User user);
    String validateToken(String token);
}
