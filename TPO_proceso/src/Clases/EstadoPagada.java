package Clases;

import Interfaces.EstadoInterface;

public class EstadoPagada implements EstadoInterface {
    @Override
    public void manejarEstado(reserva_class reserva) {
        // Lógica específica para cuando la reserva está pagada
        System.out.println("La reserva ha sido pagada.");
    }

    @Override
    public String getEstado() {
        return "Pagada";
    }
}
