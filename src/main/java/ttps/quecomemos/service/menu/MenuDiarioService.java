package ttps.quecomemos.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ttps.quecomemos.dto.MenuDiarioRequest;
import ttps.quecomemos.modelo.menu.Menu;
import ttps.quecomemos.modelo.menu.MenuDiario;
import ttps.quecomemos.repository.menu.MenuDiarioRepository;
import ttps.quecomemos.service.GenericService;

// Las validaciones sobre los datos de los menús las realiza la clase
@Service
public class MenuDiarioService extends GenericService<MenuDiario> {
    private final MenuService menuService;

    @Autowired
    public MenuDiarioService(MenuDiarioRepository menuDiarioRepository, MenuService menuService) {
        super(menuDiarioRepository);
        this.menuService = menuService;
    }

    private MenuDiario createMenuDiarioFromRequest(MenuDiarioRequest menuDiarioRequest) {
        MenuDiario menuDiario = new MenuDiario(menuDiarioRequest);

        Menu menuVegetariano = menuService.findById(menuDiarioRequest.getMenuVegetarianoId());
        Menu menuNoVegetariano = menuService.findById(menuDiarioRequest.getMenuNoVegetarianoId());
        menuDiario.setMenuNoVegetariano(menuNoVegetariano);
        menuDiario.setMenuVegetariano(menuVegetariano);

        return menuDiario;
    }

    @Transactional
    @Override
    public MenuDiario save(MenuDiario menuDiario) {
        return this.repository.save(menuDiario);
    }

    @Transactional
    public MenuDiario saveMenuDiarioRequest(MenuDiarioRequest menuDiarioRequest) {
        return this.repository.save(this.createMenuDiarioFromRequest(menuDiarioRequest));
    }

    @Transactional
    @Override
    public MenuDiario update(MenuDiario menuDiario, Long id) {
        findById(id); // Si el menú que se intenta actualizar no existe lanza una excepción
        menuDiario.setId(id);
        return this.repository.save(menuDiario);
    }

    @Transactional
    public MenuDiario updateMenuDiarioRequest(MenuDiarioRequest menuDiarioRequest, Long id) {
        findById(id); // Si el menú que se intenta actualizar no existe lanza una excepción
        MenuDiario menuDiario = this.createMenuDiarioFromRequest(menuDiarioRequest);
        menuDiario.setId(id);
        return this.repository.save(menuDiario);
    }
}