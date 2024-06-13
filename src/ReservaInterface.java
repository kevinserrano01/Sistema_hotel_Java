import java.time.LocalDate;

public interface ReservaInterface {

    // Obtener el cliente de la reserva
    ClienteInterface getCliente();

    // Obtener la habitación de la reserva
    Habitacion<?> getHabitacion();

    // Obtener la fecha de inicio de la reserva
    LocalDate getFechaInicio();

    // Obtener la fecha de fin de la reserva
    LocalDate getFechaFin();

    // Calcular el costo total de la reserva
    double calcularCosto();

    // Cancelar la reserva
    void cancelarReserva();

    // Modificar las fechas de la reserva
    void modificarFechas(LocalDate fechaInicio, LocalDate fechaFin);
}
