package ttps.quecomemos.persistencia.dao.classes;

import ttps.quecomemos.modelo.menu.MenuDiario;
import ttps.quecomemos.modelo.pago.Pago;
import ttps.quecomemos.modelo.pedido.ItemPedido;
import ttps.quecomemos.modelo.pedido.Pedido;
import ttps.quecomemos.modelo.sugerencia.Sugerencia;
import ttps.quecomemos.modelo.usuario.Administrador;
import ttps.quecomemos.modelo.usuario.Cliente;
import ttps.quecomemos.modelo.usuario.ResponsableDeTurno;
import ttps.quecomemos.modelo.usuario.Usuario;
import ttps.quecomemos.persistencia.dao.classes.menu.ComidaDAO;
import ttps.quecomemos.persistencia.dao.classes.menu.MenuDAO;
import ttps.quecomemos.persistencia.dao.jpa.*;
import ttps.quecomemos.persistencia.dao.jpa.menu.ComidaDAOHibernateJPA;
import ttps.quecomemos.persistencia.dao.jpa.menu.MenuDAOHibernateJPA;
import ttps.quecomemos.persistencia.dao.jpa.menu.MenuDiarioDAOHibernateJPA;
import ttps.quecomemos.persistencia.dao.jpa.pago.PagoDAOHibernateJPA;
import ttps.quecomemos.persistencia.dao.jpa.pedido.ItemPedidoDAOHibernateJPA;
import ttps.quecomemos.persistencia.dao.jpa.pedido.PedidoDAOHibernateJPA;
import ttps.quecomemos.persistencia.dao.jpa.sugerencia.SugerenciaDAOHibernateJPA;
import ttps.quecomemos.persistencia.dao.jpa.usuarios.AdministradorDAOHibernateJPA;
import ttps.quecomemos.persistencia.dao.jpa.usuarios.ClienteDAOHibernateJPA;
import ttps.quecomemos.persistencia.dao.jpa.usuarios.ResponsableDeTurnoDAOHibernateJPA;
import ttps.quecomemos.persistencia.dao.jpa.usuarios.UsuarioDAOHibernateJPA;

public class FactoryDAO {
    // Usuario
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

    // Menu
    public static GenericDAO<MenuDiario> getMenuDiarioDAO() {
        return new MenuDiarioDAOHibernateJPA();
    }

    public static MenuDAO getMenuDAO() {
        return new MenuDAOHibernateJPA();
    }

    public static ComidaDAO getComidaDAO() {
        return new ComidaDAOHibernateJPA();
    }

    // Pedido
    public static GenericDAO<Pedido> getPedidoDAO() {
        return new PedidoDAOHibernateJPA();
    }

    public static GenericDAO<ItemPedido> getItemPedidoDAO() {
        return new ItemPedidoDAOHibernateJPA();
    }

    // Pago
    public static GenericDAO<Pago> getPagoDAO() {
        return new PagoDAOHibernateJPA();
    }

    // Sugerencia
    public static GenericDAO<Sugerencia> getSugerenciaDAO() {
        return new SugerenciaDAOHibernateJPA();
    }
}