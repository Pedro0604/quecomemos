package menu;

import usuarios.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

 class Pedido {
    private List<ItemPedido> items;
    private Cliente cliente;
    private LocalDate fecha;

    public Pedido(Cliente cliente) {
        this.items = new ArrayList<>();
        this.cliente = cliente;
        fecha= LocalDate.now();
        }

    public LocalDate getFecha() {
		return fecha;
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

    
    public double getPrecio() {
        return items.stream().mapToDouble(ItemPedido::getPrecio).sum();
    }
}
