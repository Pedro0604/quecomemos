package ttps.quecomemos.modelo.pedido;

import org.junit.jupiter.api.Test;
import ttps.quecomemos.modelo.menu.Comida;
import ttps.quecomemos.modelo.menu.Preciable;
import ttps.quecomemos.modelo.menu.TipoComida;
import ttps.quecomemos.modelo.usuario.Cliente;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidoTest {

    @Test
    public void addItemIncreasesItemsSize() {
        Cliente cliente = new Cliente(44444444, "1234", "Pepe", "Gonzalez", "urlImagen", "pepegonzales@gmail.com");
        Pedido pedido = new Pedido(cliente);
        Preciable item = new Comida("Pizza", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 10.0);
        pedido.addItem(item);
        assertEquals(1, pedido.getItems().size());
        assertEquals(1, pedido.getItems().get(0).getCantidad());
    }

    @Test
    public void addItemIncreasesCantidadForExistingItem() {
        Cliente cliente = new Cliente(44444444, "1234", "Pepe", "Gonzalez", "urlImagen", "pepegonzales@gmail.com");
        Pedido pedido = new Pedido(cliente);
        Preciable item = new Comida("Pizza", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 10.0);
        pedido.addItem(item);
        pedido.addItem(item);
        assertEquals(1, pedido.getItems().size());
        assertEquals(2, pedido.getItems().get(0).getCantidad());
    }

    @Test
    public void getItemsReturnsCorrectItems() {
        Cliente cliente = new Cliente(44444444, "1234", "Pepe", "Gonzalez", "urlImagen", "pepegonzales@gmail.com");
        Pedido pedido = new Pedido(cliente);
        Preciable item1 = new Comida("Pizza", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 10.0);
        Preciable item2 = new Comida("Hamburguesa", "urlImagen", TipoComida.PLATO_PRINCIPAL, false, 8.0);
        pedido.addItem(item1);
        pedido.addItem(item2);
        assertEquals(2, pedido.getItems().size());
        assertEquals(item1, pedido.getItems().get(0).getItem());
        assertEquals(item2, pedido.getItems().get(1).getItem());
    }

    @Test
    public void getClienteReturnsCorrectCliente() {
        Cliente cliente = new Cliente(44444444, "1234", "Pepe", "Gonzalez", "urlImagen", "pepegonzales@gmail.com");
        Pedido pedido = new Pedido(cliente);
        assertEquals(cliente, pedido.getCliente());
    }

    @Test
    public void getPrecioReturnsCorrectTotalPrice() {
        Cliente cliente = new Cliente(44444444, "1234", "Pepe", "Gonzalez", "urlImagen", "pepegonzales@gmail.com");
        Pedido pedido = new Pedido(cliente);
        Preciable item1 = new Comida("Pizza", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 10.0);
        Preciable item2 = new Comida("Hamburguesa", "urlImagen", TipoComida.PLATO_PRINCIPAL, false, 8.0);
        pedido.addItem(item1);
        pedido.addItem(item2);
        pedido.addItem(item1);
        assertEquals(28.0, pedido.getPrecio());
    }

    @Test
    public void getFechaReturnsCurrentDate() {
        Cliente cliente = new Cliente(44444444, "1234", "Pepe", "Gonzalez", "urlImagen", "pepegonzales@gmail.com");
        Pedido pedido = new Pedido(cliente);
        assertEquals(LocalDate.now(), pedido.getFecha());
    }
}