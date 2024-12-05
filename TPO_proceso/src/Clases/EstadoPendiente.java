package Clases;

import Interfaces.EstadoInterface;

public class EstadoPendiente implements EstadoInterface {
    @Override
    public void manejarEstado(reserva_class reserva) {
        // Lógica específica para cuando el pago está pendiente
        System.out.println("El pago está pendiente.");
    }

    @Override
    public String getEstado() {
        return "Pago Pendiente";
    }
}
