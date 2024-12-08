package ttps.quecomemos.service.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ttps.quecomemos.modelo.pedido.Pedido;
import ttps.quecomemos.repository.pedido.PedidoRepository;
import ttps.quecomemos.service.GenericService;

@Service
public class PedidoService extends GenericService<Pedido> {
    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        super(pedidoRepository);
    }
}