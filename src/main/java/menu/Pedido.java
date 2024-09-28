package menu;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements Preciable {
    private List<ItemPedido> items;

    public Pedido() {
        this.items = new ArrayList<>();
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

    @Override
    public double getPrecio() {
        return items.stream().mapToDouble(ItemPedido::getPrecio).sum();
    }
}
