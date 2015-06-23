package general;

import persistencia.daos.UsuarioDao;
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
    private UsuarioDao usuarioDao;

    public InicioBean() {

    }

    @PostConstruct
    public void init() {

        if (usuarioDao.find("raul@mgcoders.uy") == null) {
            Usuario u = new Usuario();
            u.setEmail("raul@mgcoders.uy");
            u.setPassword("hash");
            usuarioDao.create(u);
        }

    }
}
