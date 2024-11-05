package ttps.quecomemos.repository.usuario;

import org.springframework.stereotype.Repository;
import ttps.quecomemos.modelo.usuario.Cliente;

@Repository
public interface ClienteRepository extends UsuarioRepository<Cliente> {
    Cliente findByEmail(String email);
}