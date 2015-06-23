package persistencia.daos;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;

/**
 * Created by raul on 23/06/15.
 */
public abstract class AbstractDao<K, E> {

    public AbstractDao() {
    }

    public abstract EntityManager getEm();

    public abstract Class<E> getDaoClass();

    public E find(K id) {
        return this.getEm().find(this.getDaoClass(), id);
    }

    public E merge(E e) {
        return this.getEm().merge(e);
    }

    public void create(E e) {
        this.getEm().persist(e);
    }

    public void refresh(E e) {
        this.getEm().refresh(e);
    }

    public void remove(E e) {
        this.getEm().remove(e);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public E createAtomic(E e) {
        this.getEm().persist(e);
        this.getEm().refresh(e);
        return e;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public E mergeAtomic(E e) {
        e = this.getEm().merge(e);
        return e;
    }
}