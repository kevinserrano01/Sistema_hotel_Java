import java.time.LocalDate;
import java.util.List;

public class HabitacionSuite extends HabitacionGeneral<ComodidadPremium> {

    public HabitacionSuite(String tipo, double precio, List<ComodidadPremium> comodidades) {
        super(tipo, precio, comodidades);
    }

    @Override
    public boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin) {
        int reservas = App.getGestor().contarReservas(this, fechaInicio, fechaFin);
        return reservas < 5 && fechaFin.minusDays(3).isAfter(fechaInicio);
    }

    @Override
    public double calcularPrecioTotal(LocalDate fechaInicio, LocalDate fechaFin) {
        double total = precio;
        for (ComodidadPremium comodidad : comodidades) {
            total += comodidad.calcularCosto(fechaInicio, fechaFin);
        }
        if (fechaFin.minusDays(5).isAfter(fechaInicio)) {
            total *= 0.85; // Descuento del 15%
        }
        return total;
    }

    @Override
    public String toString() {
        return "HabitacionSuite{" +
                "tipo='" + tipo + '\'' +
                ", precio=" + precio +
                ", comodidades=" + comodidades +
                '}';
    }
}
