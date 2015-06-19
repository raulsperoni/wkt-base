package general;

import persistencia.Prueba;
import persistencia.entidades.Usuario;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Created by raul on 19/06/15.
 */
@Singleton
@Startup
public class InicioBean {

    @EJB
    Prueba prueba;

    public InicioBean() {

    }

    @PostConstruct
    public void init() {

        if (prueba.getUsuario("raul@mgcoders.uy") == null) {
            Usuario u = new Usuario();
            u.setEmail("raul@mgcoders.uy");
            u.setPassword("hash");
            prueba.guardarUsuario(u);
        }

    }
}
