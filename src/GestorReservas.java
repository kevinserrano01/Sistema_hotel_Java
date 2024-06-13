import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorReservas {

    private List<Reserva> reservas;

    // Constructor que instancia la lista de reservas vacía
    public GestorReservas() {
        this.reservas = new ArrayList<>();
    }

    // getter
    public List<Reserva> getReservas() {
        return reservas;
    }

    // Realizar una reserva
    public void realizarReserva(Cliente cliente, Habitacion<?> habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        // Implementar ReservaImpl según la interfaz Reserva
        Reserva reserva = new Reserva(cliente, habitacion, fechaInicio, fechaFin);
        reservas.add(reserva);
        cliente.acumularPuntos(reserva); // Acumula puntos para el cliente
    }

    // Cancelar una reserva
    public void cancelarReserva(Reserva reserva) {
        reserva.cancelarReserva();
        reservas.remove(reserva);
    }

    // Modificar una reserva
    public void modificarReserva(Reserva reserva, LocalDate fechaInicio, LocalDate fechaFin) {
        reserva.modificarFechas(fechaInicio, fechaFin);
    }

    // Calcular el costo de una reserva
    public double calcCostoReserva(Reserva reserva) {
        return reserva.calcularCosto();
    }
}
