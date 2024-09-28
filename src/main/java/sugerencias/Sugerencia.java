package sugerencias;

import usuarios.Usuario;

import java.time.LocalTime;

public class Sugerencia {
    private String descripcion;
    private TipoSugerencia tipo;
    private LocalTime fecha;
    private Usuario usuario;

    public Sugerencia(String descripcion, TipoSugerencia tipo, Usuario usuario) {
        super();
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fecha = LocalTime.now();
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }
}
