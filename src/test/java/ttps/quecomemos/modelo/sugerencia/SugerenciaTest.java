package ttps.quecomemos.modelo.sugerencia;

import org.junit.jupiter.api.Test;
import ttps.quecomemos.modelo.usuario.Cliente;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SugerenciaTest {

    @Test
    public void descripcionIsSetCorrectly() {
        Cliente cliente = new Cliente(44444444, "1234", "Pepe", "Gonzalez", "urlImagen", "pepegonzales@gmail.com");
        Sugerencia sugerencia = new Sugerencia("Buena comida", TipoSugerencia.ALIMENTOS, cliente);
        assertEquals("Buena comida", sugerencia.getDescripcion());
    }

    @Test
    public void tipoIsSetCorrectly() {
        Cliente cliente = new Cliente(44444444, "1234", "Pepe", "Gonzalez", "urlImagen", "pepegonzales@gmail.com");
        Sugerencia sugerencia = new Sugerencia("Buena comida", TipoSugerencia.ALIMENTOS, cliente);
        assertEquals(TipoSugerencia.ALIMENTOS, sugerencia.getTipo());
    }

    @Test
    public void fechaIsSetToCurrentTime() {
        Cliente cliente = new Cliente(44444444, "1234", "Pepe", "Gonzalez", "urlImagen", "pepegonzales@gmail.com");
        Sugerencia sugerencia = new Sugerencia("Buena comida", TipoSugerencia.ALIMENTOS, cliente);
        assertNotNull(sugerencia.getFecha());
    }

    @Test
    public void clienteIsSetCorrectly() {
        Cliente cliente = new Cliente(44444444, "1234", "Pepe", "Gonzalez", "urlImagen", "pepegonzales@gmail.com");
        Sugerencia sugerencia = new Sugerencia("Buena comida", TipoSugerencia.ALIMENTOS, cliente);
        assertEquals(cliente, sugerencia.getCliente());
    }
}