package menu;

public class Comida implements PreciableNombrable {
    private String nombre, urlImagen;
    private TipoComida tipoComida;
    private boolean esVegetariana;
    private double precio;

    public Comida(String nombre, String descripcion, TipoComida tipoComida, boolean esVegetariana, double precio) {
        this.nombre = nombre;
        this.urlImagen = descripcion;
        this.tipoComida = tipoComida;
        this.esVegetariana = esVegetariana;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public TipoComida getTipoComida() {
        return tipoComida;
    }

    public boolean esVegetariana(){
        return esVegetariana;
    }

    @Override
    public double getPrecio() {
        return precio;
    }
}
