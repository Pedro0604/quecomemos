package ttps.quecomemos.modelo.sugerencia;

import ttps.quecomemos.modelo.usuario.Cliente;

import java.time.LocalTime;

public class Sugerencia {
    private String descripcion;
    private TipoSugerencia tipo;
    private LocalTime fecha;
    private Cliente cliente;

    public Sugerencia(String descripcion, TipoSugerencia tipo, Cliente cliente) {
        super();
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fecha = LocalTime.now();
        this.cliente = cliente;
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
}
