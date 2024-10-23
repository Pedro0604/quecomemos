package ttps.quecomemos.persistencia.dao.classes;

import ttps.quecomemos.modelo.pedido.Pedido;
import ttps.quecomemos.modelo.pedido.ItemPedido;
import ttps.quecomemos.modelo.usuario.Administrador;
import ttps.quecomemos.modelo.usuario.Cliente;
import ttps.quecomemos.modelo.usuario.ResponsableDeTurno;
import ttps.quecomemos.modelo.usuario.Usuario;
import ttps.quecomemos.persistencia.dao.classes.menu.ComidaDAO;
import ttps.quecomemos.persistencia.dao.classes.menu.MenuDAO;
import ttps.quecomemos.persistencia.dao.jpa.*;
import ttps.quecomemos.persistencia.dao.jpa.menu.ComidaDAOHibernateJPA;
import ttps.quecomemos.persistencia.dao.jpa.menu.MenuDAOHibernateJPA;
import ttps.quecomemos.persistencia.dao.jpa.pedido.ItemPedidoDAOHibernateJPA;
import ttps.quecomemos.persistencia.dao.jpa.pedido.PedidoDAOHibernateJPA;

public class FactoryDAO {
    public static GenericDAO<Usuario> getUsuarioDAO() {
        return new UsuarioDAOHibernateJPA();
    }

    public static GenericDAO<Cliente> getClienteDAO() {
        return new ClienteDAOHibernateJPA();
    }

    public static GenericDAO<ResponsableDeTurno> getResponsableDeTurnoDAO() {
        return new ResponsableDeTurnoDAOHibernateJPA();
    }

    public static GenericDAO<Administrador> getAdministradorDAO() {
        return new AdministradorDAOHibernateJPA();
    }

    public static MenuDAO getMenuDAO() {
        return new MenuDAOHibernateJPA();
    }

    public static ComidaDAO getComidaDAO() {
        return new ComidaDAOHibernateJPA();
    }

    public static GenericDAO<Pedido> getPedidoDAO() {
        return new PedidoDAOHibernateJPA();
    }

    public static GenericDAO<ItemPedido> getItemPedidoDAO() {
        return new ItemPedidoDAOHibernateJPA();
    }
}
