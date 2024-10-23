package ttps.quecomemos.modelo.sugerencia;

import ttps.quecomemos.modelo.usuario.Cliente;

import jakarta.persistence.*;
import java.time.LocalTime;

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

    public Sugerencia() {
    }

    public Sugerencia(String descripcion, TipoSugerencia tipo, Cliente cliente) {
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fecha = LocalTime.now();
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoSugerencia getTipo() {
        return tipo;
    }

    public void setTipo(TipoSugerencia tipo) {
        this.tipo = tipo;
    }

    public LocalTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalTime fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
