package ttps.quecomemos.persistencia.dao.jpa;

import ttps.quecomemos.modelo.pedido.ItemPedido;
import ttps.quecomemos.persistencia.dao.classes.ItemPedidoDAO;

public class ItemPedidoDAOHibernateJPA extends GenericDAOHibernateJPA<ItemPedido> implements ItemPedidoDAO {
    public ItemPedidoDAOHibernateJPA() {
        super(ItemPedido.class);
    }
}
