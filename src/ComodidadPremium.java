import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ComodidadPremium extends Comodidad {

    // Atributos
    private String especialidad;

    // Constructor
    public ComodidadPremium(String nombre, double precio, String especialidad) {
        super(nombre, precio);
        this.especialidad = especialidad;
    }

    // Getters y Setter
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    // Metodos
    // Calcula del costo para incluir un recargo del 25% al costo final.
    @Override
    public double calcularCosto(LocalDate fechaInicio, LocalDate fechaFin) {
        long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        double costo = dias * precio;
        return costo * 1.25; // 25% de recargo final
    }

    @Override
    public String toString() {
        return "ComodidadPremium{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}
