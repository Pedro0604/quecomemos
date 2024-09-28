package menu;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements Preciable {
    private double precio;
    private List<ItemPedido> items;

    public Pedido() {
        this.precio = 0;
        this.items = new ArrayList<>();
    }

    public void addItem(PreciableNombrable item) {
        this.items.add(new ItemPedido(item));
        this.precio += item.getPrecio();
    }

    @Override
    public double getPrecio() {
        return precio;
    }
}
