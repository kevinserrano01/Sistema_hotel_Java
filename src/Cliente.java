public class Cliente implements ClienteInterface {

    private String nombre;
    private int puntos;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public Integer getPuntos() {
        return puntos;
    }

    @Override
    public void acumularPuntos(ReservaInterface reserva) {
        this.puntos += (int) (reserva.calcularCosto() / 100);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", puntos=" + puntos +
                '}';
    }
}
