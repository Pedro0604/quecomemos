package ttps.quecomemos.modelo.sugerencia;

import ttps.quecomemos.modelo.usuario.Cliente;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
public class Sugerencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática de IDs
    private Long id;

    @Column(nullable = false, length = 255) // Limita la longitud de la descripción
    private String descripcion;

    @Enumerated(EnumType.STRING) // Si TipoSugerencia es un enum, se almacena como String
    @Column(nullable = false)
    private TipoSugerencia tipo;

    @Column(nullable = false)
    private LocalTime fecha;

    @ManyToOne(fetch = FetchType.LAZY) // Relación Muchos-a-Uno con Cliente
    @JoinColumn(name = "cliente_id", nullable = false) // Nombre de la columna FK en la tabla
    private Cliente cliente;

    public Sugerencia() {
    }

    public Sugerencia(String descripcion, TipoSugerencia tipo, Cliente cliente) {
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fecha = LocalTime.now();
        this.cliente = cliente;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public TipoSugerencia getTipo() {
        return tipo;
    }

    public LocalTime getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipo(TipoSugerencia tipo) {
        this.tipo = tipo;
    }

    public void setFecha(LocalTime fecha) {
        this.fecha = fecha;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
