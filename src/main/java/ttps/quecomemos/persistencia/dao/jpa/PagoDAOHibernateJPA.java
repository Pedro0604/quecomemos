package ttps.quecomemos.persistencia.dao.jpa;

import jakarta.persistence.EntityManager;
import ttps.quecomemos.modelo.pago.Pago;
import ttps.quecomemos.modelo.pedido.Pedido;
import ttps.quecomemos.persistencia.emf.EMF;

import java.util.ArrayList;

public class PagoDAOHibernateJPA extends GenericDAOHibernateJPA<Pago> implements PagoDAO {
    public PagoDAOHibernateJPA() {
        super(Pago.class);
    }

    public ArrayList<Pago> getTop5() {
        EntityManager em = EMF.getEMF().createEntityManager();
        ArrayList<Pago> pagos = (ArrayList<Pago>) em.createQuery("SELECT p FROM " + this.persistentClass.getSimpleName() + " p ORDER BY p.monto DESC").setMaxResults(5).getResultList();
        em.close();
        return pagos;
    }

    public Pedido getPedido(){
        EntityManager em = EMF.getEMF().createEntityManager();
        Pedido pedido = (Pedido) em.createQuery("SELECT p FROM Pedido p WHERE p.id = :id")
                .setParameter("id", id)
                .getSingleResult();
        em.close();
        return pedido;
    }

}
