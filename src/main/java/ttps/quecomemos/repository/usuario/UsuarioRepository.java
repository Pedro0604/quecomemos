package ttps.quecomemos.repository.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ttps.quecomemos.modelo.usuario.Usuario;

@Repository
public interface UsuarioRepository<U extends Usuario> extends JpaRepository<U, Long> {
    U findByDni(int dni);
}