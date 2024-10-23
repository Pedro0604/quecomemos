package ttps.quecomemos.modelo.menu;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Preciable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public abstract double getPrecio();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
