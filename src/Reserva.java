import java.time.LocalDate;

public class Reserva implements ReservaInterface {

    private Cliente cliente;
    private Habitacion<?> habitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean cancelada;

    public Reserva(Cliente cliente, Habitacion<?> habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cancelada = false;
    }

    @Override
    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public Habitacion<?> getHabitacion() {
        return habitacion;
    }

    @Override
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    @Override
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    @Override
    public double calcularCosto() {
        if (cancelada)
            return 0;
        return habitacion.calcularPrecioTotal(fechaInicio, fechaFin);
    }

    @Override
    public void cancelarReserva() {
        this.cancelada = true;
    }

    @Override
    public void modificarFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "cliente=" + cliente +
                ", habitacion=" + habitacion +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", cancelada=" + cancelada +
                '}';
    }
}
