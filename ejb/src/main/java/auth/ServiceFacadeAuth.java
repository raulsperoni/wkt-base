package auth;


import interfaces.IServiceFacadeAuth;
import persistencia.daos.UsuarioDao;
import persistencia.entidades.Usuario;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ServiceFacadeAuth implements IServiceFacadeAuth {

    public static String ADMIN = "ADMINISTRADOR";
    public static String OP = "OPERADOR";
    public static String AUDITORIA = "AUDITORIA";


    @EJB
    private UsuarioDao usuarioDao;

    public ServiceFacadeAuth() {

    }


    @Override
    public Usuario authUsuario(String email, String pass) throws Exception {
        Usuario u = usuarioDao.find(email);
        if (u != null) return u;
        else throw new Exception("NO NO");
    }

}
