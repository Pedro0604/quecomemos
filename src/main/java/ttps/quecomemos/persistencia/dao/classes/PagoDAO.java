package ttps.quecomemos.persistencia.dao.classes;
import ttps.quecomemos.modelo.pago.Pago;
import ttps.quecomemos.modelo.pedido.Pedido;
import ttps.quecomemos.persistencia.dao.jpa.PagoDAOHibernateJPA;
import ttps.quecomemos.persistencia.dao.jpa.PedidoDAOHibernateJPA;

import java.util.ArrayList;

public interface PagoDAO extends GenericDAO<Pago> {
    public ArrayList<Pago> getTop5();
    public Pedido getPedido();
}
