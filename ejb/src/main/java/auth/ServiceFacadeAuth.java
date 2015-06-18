package auth;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ServiceFacadeAuth implements IServiceFacadeAuth {

    public static String ADMIN = "ADMINISTRADOR";
    public static String OP = "OPERADOR";
    public static String AUDITORIA = "AUDITORIA";


    public ServiceFacadeAuth() {

    }



	/*@Override
    public Usuario authUsuario(String nomRed, String pass) throws Exception {

	} */

}
