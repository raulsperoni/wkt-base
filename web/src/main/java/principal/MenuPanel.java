package principal;


import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;


@SuppressWarnings("serial")
public class MenuPanel extends Panel {

    //public Usuario usuario = (Usuario) AuthenticatedWebSession.get().getAttribute("usuario");

    public MenuPanel(String id, final String activo) {
        super(id);


        add(new Label("holaid", Model.of("Hola!")));

    }

}
