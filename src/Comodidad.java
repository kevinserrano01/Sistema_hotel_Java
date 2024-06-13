import java.time.LocalDate;

public abstract class Comodidad {

    protected String nombre;
    protected double precio;

    public Comodidad(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Metodo abstracto para calcular el costo según las fechas
    public abstract double calcularCosto(LocalDate fechaInicio, LocalDate fechaFin);

    @Override
    public String toString() {
        return "Comodidad{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
