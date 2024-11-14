package ttps.quecomemos.service.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ttps.quecomemos.modelo.usuario.ResponsableDeTurno;
import ttps.quecomemos.repository.usuario.ResponsableDeTurnoRepository;

@Service
public class ResponsableDeTurnoService extends UsuarioService<ResponsableDeTurno> {
    @Autowired
    public ResponsableDeTurnoService(ResponsableDeTurnoRepository responsableDeTurnoRepository) {
        super(responsableDeTurnoRepository);
    }

    @Transactional(readOnly = true)
    public boolean isResponsableExist(ResponsableDeTurno responsable) {
        return getByDni(responsable.getDni()) != null;
    }
}