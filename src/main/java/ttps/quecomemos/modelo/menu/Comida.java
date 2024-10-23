package ttps.quecomemos.modelo.menu;

import jakarta.persistence.*;

@Entity
public class Comida extends Preciable {
    @Column(unique = true, nullable = false)
    private String nombre;

    private String urlImagen;

    @Enumerated(EnumType.STRING)
    private TipoComida tipoComida;

    @Column(nullable = false)
    private boolean vegetariana;

    @Column(nullable = false)
    private double precio;

    public Comida() {
    }

    public Comida(String nombre, String urlImagen, TipoComida tipoComida, boolean vegetariana, double precio) {
        this.nombre = nombre;
        this.urlImagen = urlImagen;
        this.tipoComida = tipoComida;
        this.vegetariana = vegetariana;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public TipoComida getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(TipoComida tipoComida) {
        this.tipoComida = tipoComida;
    }

    public boolean isVegetariana() {
        return vegetariana;
    }

    public void setVegetariana(boolean vegetariana) {
        this.vegetariana = vegetariana;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Comida comida) {
            return comida.getNombre().equals(this.getNombre());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}
