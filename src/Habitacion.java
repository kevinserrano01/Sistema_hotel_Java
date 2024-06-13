import java.time.LocalDate;
import java.util.List;

public interface Habitacion<T extends Comodidad> {

    // Obtener el tipo de habitación
    String getTipo();

    // Obtener el precio base de la habitación
    double getPrecio();

    // Obtener la lista de comodidades de la habitación
    List<T> getComodidades();

    // Verificar si la habitación está disponible en un rango de fechas
    boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin);

    // Calcular el precio total según las fechas
    double calcularPrecioTotal(LocalDate fechaInicio, LocalDate fechaFin);
}
