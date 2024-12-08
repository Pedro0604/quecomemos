package ttps.quecomemos.modelo.usuario;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {

    @Test
    public void emailIsSetCorrectly() {
        Cliente cliente = new Cliente(12345678, "password", "John", "Doe", "urlImagen", "john.doe@example.com");
        assertEquals("john.doe@example.com", cliente.getEmail());
    }

    @Test
    public void dniIsSetCorrectly() {
        Cliente cliente = new Cliente(12345678, "password", "John", "Doe", "urlImagen", "john.doe@example.com");
        assertEquals(12345678, cliente.getDni());
    }

    @Test
    public void claveIsSetCorrectly() {
        Cliente cliente = new Cliente(12345678, "password", "John", "Doe", "urlImagen", "john.doe@example.com");
        assertEquals("password", cliente.getClave());
    }

    @Test
    public void nombreIsSetCorrectly() {
        Cliente cliente = new Cliente(12345678, "password", "John", "Doe", "urlImagen", "john.doe@example.com");
        assertEquals("John", cliente.getNombre());
    }

    @Test
    public void apellidoIsSetCorrectly() {
        Cliente cliente = new Cliente(12345678, "password", "John", "Doe", "urlImagen", "john.doe@example.com");
        assertEquals("Doe", cliente.getApellido());
    }

    @Test
    public void urlImagenIsSetCorrectly() {
        Cliente cliente = new Cliente(12345678, "password", "John", "Doe", "urlImagen", "john.doe@example.com");
        assertEquals("urlImagen", cliente.getUrlImagen());
    }
}