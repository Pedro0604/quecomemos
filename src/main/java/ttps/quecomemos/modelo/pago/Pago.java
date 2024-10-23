package ttps.quecomemos.modelo.pago;

import jakarta.persistence.*;
import ttps.quecomemos.modelo.pedido.Pedido;

@Entity
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @Enumerated(EnumType.STRING) //
    @Column(nullable = false)
    private MetodoPago metodo;


    public Pago() {
    }

    public Pago(Pedido pedido, MetodoPago metodo) {
        this.pedido = pedido;
        this.metodo = metodo;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public MetodoPago getMetodo() {
        return metodo;
    }

    public void setMetodo(MetodoPago metodo) {
        this.metodo = metodo;
    }
}
