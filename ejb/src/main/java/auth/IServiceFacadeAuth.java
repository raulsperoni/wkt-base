package auth;


import persistencia.entidades.Usuario;

import javax.ejb.Remote;

/**
 * Created by RSperoni on 05/06/2015.
 */
@Remote
public interface IServiceFacadeAuth {
    Usuario authUsuario(String email, String pass) throws Exception;
}
