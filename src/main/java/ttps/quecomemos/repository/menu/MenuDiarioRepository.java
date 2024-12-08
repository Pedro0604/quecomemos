package ttps.quecomemos.repository.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ttps.quecomemos.modelo.menu.MenuDiario;

@Repository
public interface MenuDiarioRepository extends JpaRepository<MenuDiario, Long> {
}