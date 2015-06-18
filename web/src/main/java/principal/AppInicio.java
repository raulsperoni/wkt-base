package principal;

import org.apache.wicket.Page;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.core.request.handler.PageProvider;
import org.apache.wicket.core.request.handler.RenderPageRequestHandler;
import org.apache.wicket.markup.html.IPackageResourceGuard;
import org.apache.wicket.markup.html.SecurePackageResourceGuard;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.cycle.AbstractRequestCycleListener;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.settings.IExceptionSettings;
import org.wicketstuff.javaee.injection.JavaEEComponentInjector;
import org.wicketstuff.javaee.naming.global.GlobalJndiNamingStrategy;

public class AppInicio extends AuthenticatedWebApplication {

    private static final String APP_NAME = "orgnk-ear";
    private static final String EJB_MODULE_NAME = "orgnk-ejb";

    @Override
    public Class<? extends Page> getHomePage() {
        return SignInPage.class;
    }

    @Override
    protected Class<? extends WebPage> getSignInPageClass() {
        return SignInPage.class;
    }

    @Override
    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
        return AuthSession.class;
    }

    @Override
    protected void init() {
        super.init();
        getComponentInstantiationListeners().add(
                new JavaEEComponentInjector(this, new GlobalJndiNamingStrategy(
                        APP_NAME, EJB_MODULE_NAME)));


        mountPage("/inicio", Inicio.class);
        mountPage("/login", SignInPage.class);


        IPackageResourceGuard packageResourceGuard = this.getResourceSettings().getPackageResourceGuard();
        if (packageResourceGuard instanceof SecurePackageResourceGuard) {
            SecurePackageResourceGuard guard = (SecurePackageResourceGuard) packageResourceGuard;
            guard.addPattern("+css/*");
        }

        mountPage("/error", ErrorPage.class);
        /**
         * Manejo de Errores inesperados.
         */
        getApplicationSettings().setInternalErrorPage(ErrorPage.class);
        getExceptionSettings().setUnexpectedExceptionDisplay(IExceptionSettings.SHOW_INTERNAL_ERROR_PAGE);
        getRequestCycleListeners().add(new AbstractRequestCycleListener() {
            @Override
            public IRequestHandler onException(RequestCycle cycle, Exception ex) {
                return new RenderPageRequestHandler(new PageProvider(new ErrorPage(ex)));
            }
        });

    }

}
