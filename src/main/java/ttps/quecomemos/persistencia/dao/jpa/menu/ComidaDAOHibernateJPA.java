package ttps.quecomemos.persistencia.dao.jpa.menu;

import jakarta.persistence.EntityManager;
import ttps.quecomemos.modelo.menu.Comida;
import ttps.quecomemos.persistencia.dao.classes.menu.ComidaDAO;
import ttps.quecomemos.persistencia.dao.jpa.GenericDAOHibernateJPA;
import ttps.quecomemos.persistencia.emf.EMF;

public class ComidaDAOHibernateJPA extends GenericDAOHibernateJPA<Comida> implements ComidaDAO {
    public ComidaDAOHibernateJPA() {
        super(Comida.class);
    }

    @Override
    public Comida getByName(String name) {
        EntityManager em = EMF.getEMF().createEntityManager();
        Comida comida;
        try {
            comida = (Comida) em.createQuery("SELECT c FROM " + this.getPersistentClass().getSimpleName() + " c WHERE c.nombre = :name")
                    .setParameter("name", name).getSingleResult();
        } catch (Exception e) {
            comida = null;
        } finally {
            em.close();
        }
        return comida;
    }
}
