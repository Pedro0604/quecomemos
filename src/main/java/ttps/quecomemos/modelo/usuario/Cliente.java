package ttps.quecomemos.modelo.usuario;

import jakarta.persistence.*;
import ttps.quecomemos.modelo.pedido.Pedido;
import ttps.quecomemos.modelo.sugerencia.Sugerencia;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente extends Usuario {

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "cliente")
    private List<Pedido> pedidos;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "cliente")
    private List<Sugerencia> sugerencias;

    public Cliente(int dni, String clave, String nombre, String apellido, String urlImagen, String email) {
        super(dni, clave, nombre, apellido, urlImagen);
        this.email = email;
        this.pedidos = new ArrayList<>();
        this.sugerencias = new ArrayList<>();
    }

    public Cliente() {
        super();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
