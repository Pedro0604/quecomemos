package ttps.quecomemos.modelo.usuarios;

import org.junit.jupiter.api.Test;
import ttps.quecomemos.modelo.usuario.Administrador;

import static org.junit.jupiter.api.Assertions.*;

public class AdministradorTest {

    @Test
    public void nombreIsSetCorrectly() {
        Administrador admin = new Administrador(12345678, "password", "John", "Doe", "urlImagen");
        assertEquals("John", admin.getNombre());
    }

    @Test
    public void apellidoIsSetCorrectly() {
        Administrador admin = new Administrador(12345678, "password", "John", "Doe", "urlImagen");
        assertEquals("Doe", admin.getApellido());
    }

    @Test
    public void urlImagenIsSetCorrectly() {
        Administrador admin = new Administrador(12345678, "password", "John", "Doe", "urlImagen");
        assertEquals("urlImagen", admin.getUrlImagen());
    }
}