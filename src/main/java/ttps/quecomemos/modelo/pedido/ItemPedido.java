package ttps.quecomemos.modelo.pedido;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ttps.quecomemos.modelo.menu.Preciable;

@Data
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
        this.precioUnitario = item.getPrecio();
        this.item = item;
        this.cantidad = 1;
    }

    public void addCantidad() {
        this.cantidad++;
    }

    public double getPrecio() {
        return precioUnitario * cantidad;
    }
}
