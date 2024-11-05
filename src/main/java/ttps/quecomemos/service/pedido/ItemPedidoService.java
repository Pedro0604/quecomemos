package ttps.quecomemos.service.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ttps.quecomemos.modelo.pedido.ItemPedido;
import ttps.quecomemos.repository.pedido.ItemPedidoRepository;
import ttps.quecomemos.service.GenericService;

@Service
public class ItemPedidoService extends GenericService<ItemPedido> {
    @Autowired
    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
        super(itemPedidoRepository);
    }
}