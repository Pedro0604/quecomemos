package menu;

import usuarios.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements Preciable {
    private List<ItemPedido> items;
    private Cliente cliente;

    public Pedido(Cliente cliente) {
        this.items = new ArrayList<>();
        this.cliente = cliente;
    }

    public void addItem(Preciable item) {
        items.stream()
                .filter(i -> i.getItem().equals(item))
                .findFirst()
                .ifPresentOrElse(ItemPedido::addCantidad,
                        () -> this.items.add(new ItemPedido(item)));
    }

    public List<ItemPedido> getItems() {
        return items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public double getPrecio() {
        return items.stream().mapToDouble(ItemPedido::getPrecio).sum();
    }
}
