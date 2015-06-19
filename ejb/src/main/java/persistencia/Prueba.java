package persistencia;

/**
 * Created by raul on 19/06/15.
 */

import persistencia.entidades.Usuario;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Prueba {

    @PersistenceContext
    EntityManager entityManager;

    public Usuario getUsuario(String email) {
        return entityManager.find(Usuario.class, email);
    }

    public void guardarUsuario(Usuario usuario) {
        entityManager.persist(usuario);
    }
}
