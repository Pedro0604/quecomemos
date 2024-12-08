package ttps.quecomemos.repository.pago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ttps.quecomemos.modelo.pago.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
}