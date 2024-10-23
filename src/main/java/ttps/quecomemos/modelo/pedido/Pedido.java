package ttps.quecomemos.modelo.pedido;

import jakarta.persistence.*;
import ttps.quecomemos.modelo.menu.Preciable;
import ttps.quecomemos.modelo.usuario.Cliente;
import ttps.quecomemos.modelo.pago.Pago;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemPedido> getItems() {
        return items;
    }

    public void setItems(List<ItemPedido> items) {
        this.items = items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
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
