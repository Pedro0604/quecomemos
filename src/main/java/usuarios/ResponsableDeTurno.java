package usuarios;

public class ResponsableDeTurno extends NoAdmin {

    private Turno turno;

    public ResponsableDeTurno(int dni, String clave, String nombre, String apellido, String urlImagen) {
        super(dni, clave, nombre, apellido, urlImagen);
    }

    public Turno getTurno() {
        return turno;
    }
}
