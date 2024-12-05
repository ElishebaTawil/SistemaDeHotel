package Clases;

import Interfaces.PagoInterface;

public class PagoEfectivo implements PagoInterface {
    @Override
    public void realizarPago(double monto) {
        System.out.println("Pago de " + monto + " realizado en efectivo.");
    }
}
