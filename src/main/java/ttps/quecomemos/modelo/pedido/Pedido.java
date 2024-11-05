package ttps.quecomemos.modelo.pedido;

import jakarta.persistence.*;
import lombok.Data;
import ttps.quecomemos.modelo.menu.Preciable;
import ttps.quecomemos.modelo.pago.Pago;
import ttps.quecomemos.modelo.usuario.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pedido")
    private List<ItemPedido> items;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToOne(optional = false)
    private Pago pago;

    @Column(nullable = false)
    private LocalDate fecha;

    public Pedido() {
        this.items = new ArrayList<>();
        fecha = LocalDate.now();
    }

    public Pedido(Cliente cliente) {
        this.items = new ArrayList<>();
        this.cliente = cliente;
        fecha = LocalDate.now();
    }

    public void addItem(Preciable item) {
        items.stream()
                .filter(i -> i.getItem().equals(item))
                .findFirst()
                .ifPresentOrElse(ItemPedido::addCantidad,
                        () -> this.items.add(new ItemPedido(item)));
    }

    public double getPrecio() {
        return items.stream().mapToDouble(ItemPedido::getPrecio).sum();
    }
}
