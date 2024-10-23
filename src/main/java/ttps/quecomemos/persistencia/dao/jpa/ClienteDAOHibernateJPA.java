package ttps.quecomemos.persistencia.dao.jpa;

import jakarta.persistence.EntityManager;
import ttps.quecomemos.modelo.usuario.Cliente;
import ttps.quecomemos.persistencia.dao.classes.ClienteDAO;
import ttps.quecomemos.persistencia.emf.EMF;

public class ClienteDAOHibernateJPA extends GenericDAOHibernateJPA<Cliente> implements ClienteDAO {
    public ClienteDAOHibernateJPA() {
        super(Cliente.class);
    }

    @Override
    public Cliente getByEmail(String email) {
        EntityManager em = EMF.getEMF().createEntityManager();
        Cliente entity = (Cliente) em.createQuery("SELECT c FROM " + this.persistentClass.getSimpleName() + " c WHERE c.email =: email")
                .setParameter("email", email).getSingleResult();
        em.close();
        return entity;
    }
}
