package ttps.quecomemos.persistencia.dao.jpa.usuarios;

import jakarta.persistence.EntityManager;
import ttps.quecomemos.modelo.usuario.Usuario;
import ttps.quecomemos.persistencia.dao.classes.UsuarioDAO;
import ttps.quecomemos.persistencia.dao.jpa.GenericDAOHibernateJPA;
import ttps.quecomemos.persistencia.emf.EMF;

public class GenericUserDAOHibernateJPA<T> extends GenericDAOHibernateJPA<T> implements UsuarioDAO<T> {

    public GenericUserDAOHibernateJPA(Class<T> clase) {
        super(clase);
    }

    @Override
    public T getByDni(int dni) {
        EntityManager em = EMF.getEMF().createEntityManager();
        T entity = (T) em.createQuery("SELECT u FROM " + this.persistentClass.getSimpleName() + " u WHERE u.dni =: dni").setParameter("dni", dni).getSingleResult();
        em.close();
        return entity;
    }

}
