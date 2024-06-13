import java.time.LocalDate;
import java.util.List;

public class HabitacionSimple extends HabitacionGeneral<ComodidadBasica> {

    public HabitacionSimple(String tipo, double precio, List<ComodidadBasica> comodidades) {
        super(tipo, precio, comodidades);
    }

    @Override
    public boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin) {
        int cantReservas = App.getGestor().contarReservas(this, fechaInicio, fechaFin);
        return cantReservas < 10;
    }

    @Override
    public double calcularPrecioTotal(LocalDate fechaInicio, LocalDate fechaFin) {
        double total = precio;
        for (ComodidadBasica comodidad : comodidades) {
            total += comodidad.calcularCosto(fechaInicio, fechaFin);
        }
        return total;
    }

    @Override
    public String toString() {
        return "HabitacionSimple{" +
                "tipo='" + tipo + '\'' +
                ", precio=" + precio +
                ", comodidades=" + comodidades +
                '}';
    }
}
