package ttps.quecomemos.modelo.menu;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ttps.quecomemos.dto.MenuDiarioRequest;
import ttps.quecomemos.exception.MenuDiarioSinMenusException;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class MenuDiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DayOfWeek dia;

    @ManyToOne()
    @JoinColumn(name = "menu_vegetariano_id", nullable = false)
    private Menu menuVegetariano;

    @ManyToOne()
    @JoinColumn(name = "menu_no_vegetariano_id", nullable = false)
    private Menu menuNoVegetariano;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDate.now(); // Asignar la fecha actual si no está presente
        }
    }

    public MenuDiario(MenuDiarioRequest menuDiarioRequest) {
        this.dia = menuDiarioRequest.getDia();
    }

    public void setMenuVegetariano(Menu menuVegetariano) {
        if (menuVegetariano == null) {
            throw new MenuDiarioSinMenusException();
        }
        if (!menuVegetariano.isVegetariano()) {
            throw new IllegalArgumentException("El menu vegetariano debe ser vegetariano");
        }
        this.menuVegetariano = menuVegetariano;
    }

    public void setMenuNoVegetariano(Menu menuNoVegetariano) {
        if (menuNoVegetariano == null) {
            throw new MenuDiarioSinMenusException();
        }
        if (menuNoVegetariano.isVegetariano()) {
            throw new IllegalArgumentException("El menu no vegetariano no puede ser vegetariano");
        }
        this.menuNoVegetariano = menuNoVegetariano;
    }
}
