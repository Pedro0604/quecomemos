package usuarios;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdministradorTest {

    @Test
    public void dniIsSetCorrectly() {
        Administrador admin = new Administrador(12345678, "password");
        assertEquals(12345678, admin.getDni());
    }

    @Test
    public void claveIsSetCorrectly() {
        Administrador admin = new Administrador(12345678, "password");
        assertEquals("password", admin.getClave());
    }
}