package ttps.quecomemos.modelo.pedido;

import jakarta.persistence.*;
import ttps.quecomemos.modelo.menu.Preciable;

@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @Column(nullable = false)
    private double precioUnitario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Preciable item;

    @Column(nullable = false)
    private int cantidad;

    public ItemPedido() {
        this.cantidad = 1;
    }

    public ItemPedido(Preciable item) {
        // Guardamos el precio para que aunque cambie el precio del item, el precio del pedido no cambie
        this.precioUnitario = item.getPrecio();
        this.item = item;
        this.cantidad = 1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Preciable getItem() {
        return item;
    }

    public void setItem(Preciable item) {
        this.item = item;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void addCantidad() {
        this.cantidad++;
    }

    public double getPrecio() {
        return precioUnitario * cantidad;
    }
}
