package usuarios;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResponsableDeTurnoTest {

    @Test
    public void turnoIsSetCorrectly() {
        ResponsableDeTurno responsable = new ResponsableDeTurno(12345678, "password", "John", "Doe", "urlImagen", Turno.TARDE);
        assertEquals(Turno.TARDE, responsable.getTurno());
    }

    @Test
    public void dniIsSetCorrectly() {
        ResponsableDeTurno responsable = new ResponsableDeTurno(12345678, "password", "John", "Doe", "urlImagen", Turno.TARDE);
        assertEquals(12345678, responsable.getDni());
    }

    @Test
    public void claveIsSetCorrectly() {
        ResponsableDeTurno responsable = new ResponsableDeTurno(12345678, "password", "John", "Doe", "urlImagen", Turno.TARDE);
        assertEquals("password", responsable.getClave());
    }

    @Test
    public void nombreIsSetCorrectly() {
        ResponsableDeTurno responsable = new ResponsableDeTurno(12345678, "password", "John", "Doe", "urlImagen", Turno.TARDE);
        assertEquals("John", responsable.getNombre());
    }

    @Test
    public void apellidoIsSetCorrectly() {
        ResponsableDeTurno responsable = new ResponsableDeTurno(12345678, "password", "John", "Doe", "urlImagen", Turno.TARDE);
        assertEquals("Doe", responsable.getApellido());
    }

    @Test
    public void urlImagenIsSetCorrectly() {
        ResponsableDeTurno responsable = new ResponsableDeTurno(12345678, "password", "John", "Doe", "urlImagen", Turno.TARDE);
        assertEquals("urlImagen", responsable.getUrlImagen());
    }
}