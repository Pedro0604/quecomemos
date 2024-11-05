package ttps.quecomemos.modelo.pago;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ttps.quecomemos.modelo.pedido.Pedido;


@Data
@NoArgsConstructor
@Entity
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false, mappedBy="pago")
    private Pedido pedido;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MetodoPago metodo;

    public Pago(Pedido pedido, MetodoPago metodo) {
        this.pedido = pedido;
        this.metodo = metodo;
    }
}
