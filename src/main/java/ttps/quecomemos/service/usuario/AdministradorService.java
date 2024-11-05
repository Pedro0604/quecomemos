package ttps.quecomemos.service.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ttps.quecomemos.modelo.usuario.Administrador;
import ttps.quecomemos.repository.usuario.AdministradorRepository;

@Service
public class AdministradorService extends UsuarioService<Administrador> {
    @Autowired
    public AdministradorService(AdministradorRepository administradorRepository) {
        super(administradorRepository);
    }
}