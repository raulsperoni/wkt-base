package persistencia.daos;

import persistencia.entidades.Usuario;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by raul on 23/06/15.
 */
@Stateless
public class UsuarioDao extends AbstractDao<String, Usuario> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEm() {
        return entityManager;
    }

    @Override
    public Class<Usuario> getDaoClass() {
        return Usuario.class;
    }
}
