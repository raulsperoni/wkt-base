package principal;

import theme.Theme;


@SuppressWarnings("serial")
public class Inicio extends Theme {

    //private Usuario usuario = (Usuario) AuthenticatedWebSession.get().getAttribute("usuario");

    public Inicio() {
        super("Inicio");
        add(new MenuPanel("menupanel", "Inicio"));
    }

    public Inicio(String titulo) {
        super(titulo);
        add(new MenuPanel("menupanel", titulo));
    }

	/*public Usuario getUsuario() {
        return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	} */

}
