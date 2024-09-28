package menu;

public class ItemPedido {
    private double precio;
    private String nombre;

    public ItemPedido(PreciableNombrable item) {
        this.precio = item.getPrecio();
        this.nombre = item.getNombre();
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }
}
