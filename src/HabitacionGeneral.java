import java.time.LocalDate;
import java.util.List;

public abstract class HabitacionGeneral<T extends Comodidad> implements Habitacion<T> {

    protected String tipo;
    protected double precio;
    protected List<T> comodidades;

    public HabitacionGeneral(String tipo, double precio, List<T> comodidades) {
        this.tipo = tipo;
        this.precio = precio;
        this.comodidades = comodidades;
    }

    // Getters
    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public List<T> getComodidades() {
        return comodidades;
    }

    // Setters
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setComodidades(List<T> comodidades) {
        this.comodidades = comodidades;
    }

    // Método abstracto para verificar disponibilidad
    @Override
    public abstract boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin);

    // Método abstracto para calcular el precio total
    @Override
    public abstract double calcularPrecioTotal(LocalDate fechaInicio, LocalDate fechaFin);

    @Override
    public String toString() {
        return "Habitacion{" +
                "tipo='" + tipo + '\'' +
                ", precio=" + precio +
                ", comodidades=" + comodidades +
                '}';
    }
}
