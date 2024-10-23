package ttps.quecomemos.persistencia.dao.jpa.usuarios;

import jakarta.persistence.EntityManager;
import ttps.quecomemos.modelo.usuario.Cliente;
import ttps.quecomemos.persistencia.dao.classes.ClienteDAO;
import ttps.quecomemos.persistencia.emf.EMF;

public class ClienteDAOHibernateJPA extends GenericUserDAOHibernateJPA<Cliente> implements ClienteDAO {
    public ClienteDAOHibernateJPA() {
        super(Cliente.class);
    }

    @Override
    public Cliente getByEmail(String email) {
        EntityManager em = EMF.getEMF().createEntityManager();
        Cliente entity;
        try {
            entity = (Cliente) em.createQuery("SELECT c FROM " + this.getPersistentClass().getSimpleName() + " c WHERE c.email = :email")
                    .setParameter("email", email).getSingleResult();
        }
        catch (Exception e) {
            entity = null;
        }
        finally {
        em.close();
        }
        return entity;
    }
}
