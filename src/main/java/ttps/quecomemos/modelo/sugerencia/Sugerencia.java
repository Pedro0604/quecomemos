package ttps.quecomemos.modelo.sugerencia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ttps.quecomemos.modelo.usuario.Cliente;

import jakarta.persistence.*;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@Entity
public class Sugerencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoSugerencia tipo;

    @Column(nullable = false)
    private LocalTime fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    public Sugerencia(String descripcion, TipoSugerencia tipo, Cliente cliente) {
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fecha = LocalTime.now();
        this.cliente = cliente;
    }
}
