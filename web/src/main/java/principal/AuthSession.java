package principal;

import interfaces.IServiceFacadeAuth;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;
import persistencia.entidades.Usuario;

import javax.ejb.EJB;

@SuppressWarnings("serial")
public class AuthSession extends AuthenticatedWebSession {

    @EJB(name = "ServiceFacadeAuth")
    private IServiceFacadeAuth auth;

    private Usuario usuario;


    public AuthSession(Request request) {
        super(request);
        Injector.get().inject(this);
    }


    @Override
    public boolean authenticate(String email, String pass) {

        try {
            usuario = auth.authUsuario(email, pass);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Roles getRoles() {

        return null;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
