package ttps.quecomemos.service.usuarios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ttps.quecomemos.modelo.usuario.Administrador;
import ttps.quecomemos.service.usuario.AdministradorService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest
@Transactional
public class UsuarioServiceTest {

    @Autowired
    private AdministradorService administradorService;

    @BeforeEach
    public void setUp() {
        administradorService.deleteAll();
    }

    @Test
    public void testGetByDniSuccessfully() {
        Administrador administrador = new Administrador(40224974, "clave", "Juan", "Perez", "imagen.png");
        administradorService.save(administrador);
        assertNotNull(administradorService.getByDni(40224974));
    }

    @Test
    public void testGetByDniWhenDoesntExist() {
        assertNull(administradorService.getByDni(40224974));
    }
}
