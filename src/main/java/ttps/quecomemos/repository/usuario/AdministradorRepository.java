package ttps.quecomemos.repository.usuario;

import org.springframework.stereotype.Repository;
import ttps.quecomemos.modelo.usuario.Administrador;

@Repository
public interface AdministradorRepository extends UsuarioRepository<Administrador> {
}