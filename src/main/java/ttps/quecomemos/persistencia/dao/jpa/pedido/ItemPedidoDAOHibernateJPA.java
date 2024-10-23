package ttps.quecomemos.persistencia.dao.jpa.pedido;

import ttps.quecomemos.modelo.pedido.ItemPedido;
import ttps.quecomemos.persistencia.dao.classes.GenericDAO;
import ttps.quecomemos.persistencia.dao.jpa.GenericDAOHibernateJPA;

public class ItemPedidoDAOHibernateJPA extends GenericDAOHibernateJPA<ItemPedido> implements GenericDAO<ItemPedido> {
    public ItemPedidoDAOHibernateJPA() {
        super(ItemPedido.class);
    }
}
