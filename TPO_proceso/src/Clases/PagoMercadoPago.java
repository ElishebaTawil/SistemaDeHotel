package Clases;

import Interfaces.PagoInterface;

public class PagoMercadoPago implements PagoInterface {
    @Override
    public void realizarPago(double monto) {
        System.out.println("Pago de " + monto + " realizado con Mercado Pago.");
    }
}
