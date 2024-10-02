package menu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemPedidoTest {

    @Test
    public void precioUnitarioIsSetCorrectly() {
        Preciable item = new Comida("Pizza", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 10.0);
        ItemPedido itemPedido = new ItemPedido(item);
        assertEquals(10.0, itemPedido.getPrecioUnitario());
    }

    @Test
    public void precioIsCalculatedCorrectly() {
        Preciable item = new Comida("Pizza", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 10.0);
        ItemPedido itemPedido = new ItemPedido(item);
        assertEquals(10.0, itemPedido.getPrecio());
        itemPedido.addCantidad();
        assertEquals(20.0, itemPedido.getPrecio());
        itemPedido.addCantidad();
        assertEquals(30.0, itemPedido.getPrecio());
    }

    @Test
    public void cantidadIsOneInitially() {
        Preciable item = new Comida("Pizza", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 10.0);
        ItemPedido itemPedido = new ItemPedido(item);
        assertEquals(1, itemPedido.getCantidad());
    }

    @Test
    public void addCantidadIncreasesCantidad() {
        Preciable item = new Comida("Pizza", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 10.0);
        ItemPedido itemPedido = new ItemPedido(item);
        assertEquals(1, itemPedido.getCantidad());
        itemPedido.addCantidad();
        assertEquals(2, itemPedido.getCantidad());
    }

    @Test
    public void getItemReturnsCorrectItem() {
        Preciable item = new Comida("Pizza", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 10.0);
        ItemPedido itemPedido = new ItemPedido(item);
        assertEquals(item, itemPedido.getItem());
    }
}