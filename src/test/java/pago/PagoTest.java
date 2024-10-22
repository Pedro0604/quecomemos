package pago;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ttps.quecomemos.modelo.pago.MetodoPago;
import ttps.quecomemos.modelo.pago.Pago;
import ttps.quecomemos.modelo.pedido.Pedido;
import ttps.quecomemos.modelo.usuario.Cliente;

public class PagoTest {

    @Test
    public void getPedidoReturnsCorrectPedido() {
        Cliente cliente = new Cliente(44444444, "1234", "Pepe", "Gonzalez", "urlImagen", "pepegonzales@gmail.com");
        Pedido pedido = new Pedido(cliente);
        MetodoPago metodo = MetodoPago.DEBITO;
        Pago pago = new Pago(pedido, metodo);
        assertEquals(pedido, pago.getPedido());
    }

    @Test
    public void getMetodoReturnsCorrectMetodo() {
        Cliente cliente = new Cliente(44444444, "1234", "Pepe", "Gonzalez", "urlImagen", "pepegonzales@gmail.com");
        Pedido pedido = new Pedido(cliente);
        MetodoPago metodo = MetodoPago.CREDITO;
        Pago pago = new Pago(pedido, metodo);
        assertEquals(metodo, pago.getMetodo());
    }
}