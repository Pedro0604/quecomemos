package ttps.quecomemos.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ttps.quecomemos.modelo.menu.Comida;
import ttps.quecomemos.repository.menu.ComidaRepository;
import ttps.quecomemos.service.GenericService;

@Service
public class ComidaService extends GenericService<Comida> {

    private final ComidaRepository comidaRepository;

    @Autowired
    public ComidaService(ComidaRepository comidaRepository) {
        super(comidaRepository);
        this.comidaRepository = comidaRepository;
    }

    @Transactional(readOnly = true)
    public Comida getByName(String nombre) {
        return comidaRepository.findByNombre(nombre);
    }
}