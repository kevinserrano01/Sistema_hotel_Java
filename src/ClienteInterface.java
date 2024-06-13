public interface ClienteInterface {
    // Obtener el nombre del cliente
    String getNombre();

    // Obtener los puntos del cliente
    Integer getPuntos();

    // Acumular puntos en la cuenta del cliente
    void acumularPuntos(ReservaInterface reserva);
}
