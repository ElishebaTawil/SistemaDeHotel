package Interfaces;
import Clases.reserva_class;

public interface EstadoInterface {
    void manejarEstado(reserva_class reserva);
    String getEstado();
}
