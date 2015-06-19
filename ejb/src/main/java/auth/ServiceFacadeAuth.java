package auth;


import persistencia.Prueba;
import persistencia.entidades.Usuario;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ServiceFacadeAuth implements IServiceFacadeAuth {

    public static String ADMIN = "ADMINISTRADOR";
    public static String OP = "OPERADOR";
    public static String AUDITORIA = "AUDITORIA";


    @EJB
    Prueba prueba;

    public ServiceFacadeAuth() {

    }


    @Override
    public Usuario authUsuario(String email, String pass) throws Exception {
        Usuario u = prueba.getUsuario(email);
        if (u != null) return u;
        else throw new Exception("NO NO");
    }

}
