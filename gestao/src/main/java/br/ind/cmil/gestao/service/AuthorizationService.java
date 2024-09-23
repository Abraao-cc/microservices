package br.ind.cmil.gestao.service;

import br.ind.cmil.gestao.dto.LoginRequestDTO;
import br.ind.cmil.gestao.dto.ResponseDTO;

/**
 *
 * @author Administrativo
 */
public interface AuthorizationService {

    ResponseDTO findByLogin(LoginRequestDTO body);

}
