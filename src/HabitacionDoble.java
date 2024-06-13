import java.time.LocalDate;
import java.util.List;

public class HabitacionDoble extends HabitacionGeneral<ComodidadBasica> {

    public HabitacionDoble(String tipo, double precio, List<ComodidadBasica> comodidades) {
        super(tipo, precio, comodidades);
    }

    @Override
    public boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin) {
        int reservas = App.getGestor().contarReservas(this, fechaInicio, fechaFin);
        return reservas == 0 && fechaFin.minusDays(2).isAfter(fechaInicio);
    }

    @Override
    public double calcularPrecioTotal(LocalDate fechaInicio, LocalDate fechaFin) {
        double total = precio;
        for (ComodidadBasica comodidad : comodidades) {
            total += comodidad.calcularCosto(fechaInicio, fechaFin);
        }
        if (fechaFin.minusDays(3).isAfter(fechaInicio)) {
            total *= 0.9; // Descuento del 10%
        }
        return total;
    }

    @Override
    public String toString() {
        return "HabitacionDoble{" +
                "tipo='" + tipo + '\'' +
                ", precio=" + precio +
                ", comodidades=" + comodidades +
                '}';
    }
}
