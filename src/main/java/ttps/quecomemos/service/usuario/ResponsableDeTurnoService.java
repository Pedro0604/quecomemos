package ttps.quecomemos.service.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ttps.quecomemos.modelo.usuario.ResponsableDeTurno;
import ttps.quecomemos.repository.usuario.ResponsableDeTurnoRepository;

@Service
public class ResponsableDeTurnoService extends UsuarioService<ResponsableDeTurno> {
    private final ResponsableDeTurnoRepository responsableDeTurnoRepository;

    @Autowired
    public ResponsableDeTurnoService(ResponsableDeTurnoRepository responsableDeTurnoRepository) {
        super(responsableDeTurnoRepository);
        this.responsableDeTurnoRepository = responsableDeTurnoRepository;
    }

    @Transactional
    public ResponsableDeTurno save(ResponsableDeTurno responsable) {
        if (this.getByDni(responsable.getDni()) != null) {
            throw new IllegalArgumentException("Ya existe un responsable con ese DNI");
        }
        return responsableDeTurnoRepository.save(responsable);
    }

    @Transactional
    public ResponsableDeTurno update(ResponsableDeTurno responsable, Long id) {
        ResponsableDeTurno existingResponsable = (ResponsableDeTurno) findById(id);
        if (responsable.getDni() != existingResponsable.getDni() && this.getByDni(responsable.getDni()) != null) {
            throw new IllegalArgumentException("Ya existe un responsable con ese DNI");
        }
        return responsableDeTurnoRepository.save(responsable);
    }
}