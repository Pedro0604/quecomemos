package ttps.quecomemos.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ttps.quecomemos.modelo.menu.MenuDiario;
import ttps.quecomemos.repository.menu.MenuDiarioRepository;
import ttps.quecomemos.service.GenericService;

@Service
public class MenuDiarioService extends GenericService<MenuDiario> {
    @Autowired
    public MenuDiarioService(MenuDiarioRepository menuDiarioRepository) {
        super(menuDiarioRepository);
    }
}