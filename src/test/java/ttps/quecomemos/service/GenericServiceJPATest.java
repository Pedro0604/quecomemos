package ttps.quecomemos.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ttps.quecomemos.modelo.sugerencia.Sugerencia;
import ttps.quecomemos.modelo.sugerencia.TipoSugerencia;
import ttps.quecomemos.modelo.usuario.Cliente;
import ttps.quecomemos.service.sugerencia.SugerenciaService;
import ttps.quecomemos.service.usuario.ClienteService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class GenericServiceJPATest {
    @Autowired
    private SugerenciaService sugerenciaService;
    @Autowired
    private ClienteService clienteService;

    private Sugerencia getSugerencia() {
        Cliente cliente = new Cliente(
                37845902,
                "clave",
                "Juan",
                "Perez",
                "imagen.png",
                "juanPerez@gmail.com"
        );
        clienteService.save(cliente);
        return new Sugerencia("Descripcion", TipoSugerencia.ALIMENTOS, cliente);
    }

    @BeforeEach
    public void setUp() {
        clienteService.deleteAll();
        sugerenciaService.deleteAll();
    }

    @Test
    public void persistEntitySuccessfully() {
        Sugerencia persistedSugerencia = sugerenciaService.save(this.getSugerencia());
        assertNotNull(persistedSugerencia);
        assertEquals(persistedSugerencia, sugerenciaService.findById(persistedSugerencia.getId()));
    }

    @Test
    public void updateEntitySuccessfully() {
        Sugerencia sugerencia = this.getSugerencia();
        sugerencia = sugerenciaService.save(sugerencia);
        sugerencia.setDescripcion("pepe");
        Sugerencia updatedSugerencia = sugerenciaService.update(sugerencia, sugerencia.getId());

        assertNotNull(updatedSugerencia);
        assertEquals("pepe", updatedSugerencia.getDescripcion());
        assertEquals(updatedSugerencia, sugerenciaService.findById(updatedSugerencia.getId()));
    }

    @Test
    public void deleteEntitySuccessfully() {
        Sugerencia sugerencia = this.getSugerencia();
        sugerenciaService.save(sugerencia);
        assertNotNull(sugerenciaService.findById(sugerencia.getId()));
        sugerenciaService.delete(sugerencia);
        assertNull(sugerenciaService.findById(sugerencia.getId()));
    }

    @Test
    public void deleteEntityByIdSuccessfully() {
        Sugerencia sugerencia = this.getSugerencia();
        sugerenciaService.save(sugerencia);
        assertNotNull(sugerenciaService.findById(sugerencia.getId()));
        sugerenciaService.deleteById(sugerencia.getId());
        assertNull(sugerenciaService.findById(sugerencia.getId()));
    }

    @Test
    public void getAllEntities() {
        Sugerencia sugerencia = this.getSugerencia();
        sugerenciaService.save(sugerencia);
        List<Sugerencia> sugerencias = sugerenciaService.findAll();
        assertNotNull(sugerencias);
        assertEquals(1, sugerencias.size());
        Cliente cliente = new Cliente(
                11111111,
                "clave",
                "Juan",
                "Perez",
                "imagen.png",
                "juanPerez2@gmail.com"
        );
        clienteService.save(cliente);
        Sugerencia sugerencia2 = new Sugerencia("Descripcion2", TipoSugerencia.ALIMENTOS, cliente
        );
        sugerenciaService.save(sugerencia2);
        sugerencias = sugerenciaService.findAll();
        assertNotNull(sugerencias);
        assertEquals(2, sugerencias.size());
    }

    @Test
    public void getEntityByIdSuccessfully() {
        Sugerencia sugerencia = this.getSugerencia();
        sugerenciaService.save(sugerencia);
        Sugerencia foundSugerencia = sugerenciaService.findById(sugerencia.getId());
        assertNotNull(foundSugerencia);
        assertEquals(sugerencia.getId(), foundSugerencia.getId());
    }

    @Test
    public void getEntityByIdReturnsNullIfNotFound() {
        assertNull(sugerenciaService.findById(134232L));
    }
}
