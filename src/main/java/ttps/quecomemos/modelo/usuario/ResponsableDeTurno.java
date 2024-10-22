package ttps.quecomemos.modelo.usuario;

public class ResponsableDeTurno extends Usuario {

    private Turno turno;

    public ResponsableDeTurno(int dni, String clave, String nombre, String apellido, String urlImagen, Turno turno) {
        super(dni, clave, nombre, apellido, urlImagen);
        this.turno = turno;
    }

    public Turno getTurno() {
        return turno;
    }
}
