package ttps.quecomemos.service.usuarios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ttps.quecomemos.modelo.usuario.Cliente;
import ttps.quecomemos.service.usuario.ClienteService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@Transactional
public class ClienteServiceTest {

    @Autowired
    private ClienteService clienteservice;

    @BeforeEach
    public void setUp() {
        clienteservice.deleteAll();
    }

    @Test
    public void testGetByEmailSuccessfully() {
        Cliente cliente = new Cliente(37845902, "clave", "Juan", "Perez", "imagen.png", "juanPerez@gmail.com");
        clienteservice.save(cliente);
        assertNotNull(clienteservice.getByEmail("juanPerez@gmail.com"));
    }

    @Test
    public void testGetByEmailWhenDoesntExist() {
        assertNull(clienteservice.getByEmail("juanPerez@gmail.com"));
    }
}
