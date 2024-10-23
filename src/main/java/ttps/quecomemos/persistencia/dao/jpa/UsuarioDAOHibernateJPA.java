package ttps.quecomemos.persistencia.dao.jpa;

import ttps.quecomemos.persistencia.emf.EMF;
import ttps.quecomemos.modelo.usuario.Usuario;
import ttps.quecomemos.persistencia.dao.classes.UsuarioDAO;
import jakarta.persistence.EntityManager;


public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO {
    public UsuarioDAOHibernateJPA() {
        super(Usuario.class);
    }

    @Override
    public Usuario getByDni(int dni) {
       EntityManager em = EMF.getEMF().createEntityManager();
       Usuario usuario = (Usuario) em.createQuery("SELECT u FROM " + this.persistentClass.getSimpleName() + " u WHERE u.dni =: dni").setParameter("dni", dni).getSingleResult();
       em.close();
       return usuario;
    }
}
