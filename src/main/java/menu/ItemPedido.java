package menu;

public class ItemPedido {
    private double precio;
    private Preciable item;
    private int cantidad;

    public ItemPedido(Preciable item) {
        // Guardamos el precio para que aunque cambie el precio del item, el precio del pedido no cambie
        this.precio = item.getPrecio();
        this.item = item;
        this.cantidad = 0;
    }

    public double getPrecioUnitario() {
        return precio;
    }

    public double getPrecio() {
        return precio * cantidad;
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
