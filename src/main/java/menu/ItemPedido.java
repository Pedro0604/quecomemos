package menu;

public class ItemPedido {
    private double precioUnitario;
    private Preciable item;
    private int cantidad;

    public ItemPedido(Preciable item) {
        // Guardamos el precio para que aunque cambie el precio del item, el precio del pedido no cambie
        this.precioUnitario = item.getPrecio();
        this.item = item;
        this.cantidad = 1;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getPrecio() {
        return precioUnitario * cantidad;
    }

    public Preciable getItem() {
        return item;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void addCantidad() {
        this.cantidad++;
    }
}
