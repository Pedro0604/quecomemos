package ttps.quecomemos.service.sugerencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ttps.quecomemos.modelo.sugerencia.Sugerencia;
import ttps.quecomemos.repository.sugerencia.SugerenciaRepository;
import ttps.quecomemos.service.GenericService;

@Service
public class SugerenciaService extends GenericService<Sugerencia> {
    @Autowired
    public SugerenciaService(SugerenciaRepository sugerenciaRepository) {
        super(sugerenciaRepository);
    }
}