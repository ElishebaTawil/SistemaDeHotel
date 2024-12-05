package Clases;

public class PagoTarjetaCredito extends PagoTarjeta {
    public PagoTarjetaCredito(String numeroTarjeta) {
        super(numeroTarjeta);
    }

    @Override
    public void realizarPago(double monto) {
        System.out.println("Pago de " + monto + " realizado con tarjeta de crédito: " + numeroTarjeta);
    }
}
