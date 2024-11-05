package ttps.quecomemos.repository.pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ttps.quecomemos.modelo.pedido.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}