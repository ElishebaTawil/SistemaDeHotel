package Clases;

import Interfaces.PagoInterface;

public abstract class PagoTarjeta implements PagoInterface {
    protected String numeroTarjeta;

    public PagoTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
}
