package Clases;

import Interfaces.EstadoInterface;

public class EstadoCancelada implements EstadoInterface {
    @Override
    public void manejarEstado(reserva_class reserva) {
        // Lógica específica para cuando la reserva está cancelada
        System.out.println("La reserva ha sido cancelada.");
    }

    @Override
    public String getEstado() {
        return "Cancelada";
    }
}
