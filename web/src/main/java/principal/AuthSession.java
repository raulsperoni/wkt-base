package principal;

import auth.IServiceFacadeAuth;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;

import javax.ejb.EJB;

@SuppressWarnings("serial")
public class AuthSession extends AuthenticatedWebSession {

    @EJB(name = "ServiceFacadeAuth")
    private IServiceFacadeAuth auth;


    public AuthSession(Request request) {
        super(request);
        Injector.get().inject(this);
    }


    @Override
    public boolean authenticate(String nomRed, String pass) {

        return true;
    }

    @Override
    public Roles getRoles() {

        return null;
    }


}
