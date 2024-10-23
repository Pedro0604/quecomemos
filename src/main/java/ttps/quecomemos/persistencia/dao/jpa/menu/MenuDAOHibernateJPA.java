package ttps.quecomemos.persistencia.dao.jpa.menu;

import jakarta.persistence.EntityManager;
import ttps.quecomemos.modelo.menu.Menu;
import ttps.quecomemos.persistencia.dao.classes.menu.MenuDAO;
import ttps.quecomemos.persistencia.dao.jpa.GenericDAOHibernateJPA;
import ttps.quecomemos.persistencia.emf.EMF;

public class MenuDAOHibernateJPA extends GenericDAOHibernateJPA<Menu> implements MenuDAO {
    public MenuDAOHibernateJPA() {
        super(Menu.class);
    }

    @Override
    public Menu getByName(String name) {
        EntityManager em = EMF.getEMF().createEntityManager();
        Menu menu;
        try {
            menu = (Menu) em.createQuery("SELECT m FROM " + this.getPersistentClass().getSimpleName() + " m WHERE m.nombre = :name")
                    .setParameter("name", name).getSingleResult();
        } catch (Exception e) {
            menu = null;
        }
        finally {
            em.close();
        }
        return menu;
    }
}
