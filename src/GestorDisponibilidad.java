import java.time.LocalDate;
import java.util.List;

public class GestorDisponibilidad {

    private List<HabitacionGeneral<? extends Comodidad>> habitaciones;
    private List<Reserva> reservas;

    // Constructor
    public GestorDisponibilidad(List<HabitacionGeneral<? extends Comodidad>> habitaciones,
            List<Reserva> reservas) {
        this.habitaciones = habitaciones;
        this.reservas = reservas;
    }

    // Getter de habitaciones
    public List<HabitacionGeneral<? extends Comodidad>> getHabitaciones() {
        return habitaciones;
    }

    // Contar reservas en un rango de fechas para una habitación específica
    public int contarReservas(HabitacionGeneral<?> hab, LocalDate fechaInicio, LocalDate fechaFin) {
        int cantReservas = 0;
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().equals(hab) &&
                    (reserva.getFechaInicio().isBefore(fechaFin) && reserva.getFechaFin().isAfter(fechaInicio))) {
                cantReservas++;
            }
        }
        return cantReservas;
    }

    @Override
    public String toString() {
        return "Habitaciones: " + this.habitaciones +
                "Reserveas: " + this.reservas;
    }
}
