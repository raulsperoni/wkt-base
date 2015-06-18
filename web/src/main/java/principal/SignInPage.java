package principal;

import componentes.BootstrapFeedbackPanel;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.util.string.Strings;

public class SignInPage extends Inicio {

    private static final long serialVersionUID = 3656363579569582742L;
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @SuppressWarnings("serial")
    @Override
    protected void onInitialize() {
        super.onInitialize();
        StatelessForm<?> form = new StatelessForm<Object>("form") {

            @Override
            protected void onSubmit() {
                if (Strings.isEmpty(username)) {
                    return;
                }
                if (AuthenticatedWebSession.get().signIn(username, password)) {
                    setResponsePage(Inicio.class);
                } else {
                    error("Usuario o password inválido");
                }
            }
        };
        form.setDefaultModel(new CompoundPropertyModel<SignInPage>(this));
        form.add(new TextField<String>("username").setRequired(true));
        form.add(new PasswordTextField("password").setRequired(true));
        BootstrapFeedbackPanel feedbackPanel = new BootstrapFeedbackPanel("feedback");
        feedbackPanel.setOutputMarkupId(true);
        form.add(feedbackPanel);
        add(form);
    }

}