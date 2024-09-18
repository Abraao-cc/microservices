
package br.ind.cmil.gestao.infra.security;

import br.ind.cmil.gestao.domain.user.User;

/**
 *
 * @author Administrativo
 */
public interface TokenService {
    String generateToken(User user);
    String validateToken(String token);
}
