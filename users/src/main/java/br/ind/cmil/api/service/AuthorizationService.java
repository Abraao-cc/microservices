package br.ind.cmil.api.service;

import br.ind.cmil.api.dto.LoginRequestDTO;
import br.ind.cmil.api.dto.ResponseDTO;

/**
 *
 * @author Administrativo
 */
public interface AuthorizationService {

    ResponseDTO findByLogin(LoginRequestDTO body);

}
