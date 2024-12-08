package ttps.quecomemos.service.pago;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ttps.quecomemos.modelo.pago.Pago;
import ttps.quecomemos.repository.pago.PagoRepository;
import ttps.quecomemos.service.GenericService;

@Service
public class PagoService extends GenericService<Pago> {
    @Autowired
    public PagoService(PagoRepository pagoRepository) {
        super(pagoRepository);
    }
}