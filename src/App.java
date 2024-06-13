import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {

    private static GestorDisponibilidad gestorDisp;

    public static void main(String[] args) {
        // Instanciar listas de habitaciones y reservas
        List<HabitacionGeneral<? extends Comodidad>> habitaciones = new ArrayList<>();
        List<Reserva> reservas = new ArrayList<>();

        // Instanciar el gestor de disponibilidad
        gestorDisp = new GestorDisponibilidad(habitaciones, reservas);
        // System.out.println(gestorDisp);

        // Instanciar el gestor de reservas
        GestorReservas gestorReservas = new GestorReservas();

        // Crear instancias de habitaciones
        List<ComodidadBasica> comodidadesBasicas1 = new ArrayList<>();
        List<ComodidadBasica> comodidadesBasicas2 = new ArrayList<>();
        List<ComodidadPremium> comodidadesPremium = new ArrayList<>();

        HabitacionSimple habitacionSimple = new HabitacionSimple("Simple", 100.0, comodidadesBasicas1);
        HabitacionDoble habitacionDoble = new HabitacionDoble("Doble", 200.0, comodidadesBasicas2);
        HabitacionSuite habitacionSuite = new HabitacionSuite("Suite", 300.0, comodidadesPremium);

        habitaciones.add(habitacionSimple);
        habitaciones.add(habitacionDoble);
        habitaciones.add(habitacionSuite);

        // Crear instancias de comodidades
        ComodidadBasica wifi = new ComodidadBasica("WiFi", 10.0);
        ComodidadBasica desayuno = new ComodidadBasica("Desayuno", 20.0);
        ComodidadBasica estacionamiento = new ComodidadBasica("Estacionamiento", 15.0);
        ComodidadPremium jacuzzi = new ComodidadPremium("Jacuzzi", 50.0, "Jacuzzi de lujo");
        ComodidadPremium minibar = new ComodidadPremium("Minibar", 30.0, "Minibar completo");
        ComodidadPremium servicioHabitacion = new ComodidadPremium("Servicio de habitación", 40.0, "Servicio 24 horas");

        // Añadir comodidades a las habitaciones
        comodidadesBasicas1.add(wifi);
        comodidadesBasicas1.add(desayuno);
        comodidadesBasicas2.add(estacionamiento);
        comodidadesPremium.add(jacuzzi);
        comodidadesPremium.add(minibar);
        comodidadesPremium.add(servicioHabitacion);
        // System.out.println(comodidadesPremium);

        // Crear instancias de clientes
        Cliente cliente1 = new Cliente("David_Aguirre");
        Cliente cliente2 = new Cliente("Aldo_Garcia");
        Cliente cliente3 = new Cliente("Kev_code");
        // System.out.println(cliente1);
        // System.out.println(cliente2);

        // Realizar reservas para cada cliente
        realizarReservas(gestorReservas, cliente1, habitacionSimple, habitacionSimple, habitacionDoble);
        realizarReservas(gestorReservas, cliente2, habitacionSimple, habitacionDoble, habitacionDoble);
        realizarReservas(gestorReservas, cliente3, habitacionDoble, habitacionSuite, habitacionSuite);

        // Calcular y mostrar los costos de las habitaciones reservadas y los puntos
        // acumulados
        mostrarCostosYpuntos(gestorReservas, cliente1);
        mostrarCostosYpuntos(gestorReservas, cliente2);
        mostrarCostosYpuntos(gestorReservas, cliente3);
    }

    public static GestorDisponibilidad getGestor() {
        return gestorDisp;
    }

    private static void realizarReservas(GestorReservas gestorReservas, Cliente cliente, Habitacion<?> habitacionSimple,
            Habitacion<?> habitacionDoble, Habitacion<?> habitacionSuite) {
        LocalDate hoy = LocalDate.now();
        gestorReservas.realizarReserva(cliente, habitacionSimple, hoy, hoy.plusDays(1));
        gestorReservas.realizarReserva(cliente, habitacionDoble, hoy, hoy.plusDays(2));
        gestorReservas.realizarReserva(cliente, habitacionSuite, hoy, hoy.plusDays(3));
        gestorReservas.realizarReserva(cliente, habitacionSimple, hoy.plusDays(4), hoy.plusDays(5));
        gestorReservas.realizarReserva(cliente, habitacionDoble, hoy.plusDays(6), hoy.plusDays(7));
    }

    private static void mostrarCostosYpuntos(GestorReservas gestorReservas, Cliente cliente) {
        double costoTotal = 0;
        for (Reserva reserva : gestorReservas.getReservas()) {
            if (reserva.getCliente().equals(cliente)) {
                costoTotal += reserva.calcularCosto();
            }
        }
        System.out.println("Costo total de las reservas de " + cliente.getNombre() + ": $" + costoTotal);
        System.out.println("Puntos acumulados por " + cliente.getNombre() + ": " + cliente.getPuntos());
    }
}
