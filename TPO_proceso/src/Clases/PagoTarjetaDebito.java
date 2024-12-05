package Clases;

public class PagoTarjetaDebito extends PagoTarjeta {
    public PagoTarjetaDebito(String numeroTarjeta) {
        super(numeroTarjeta);
    }

    @Override
    public void realizarPago(double monto) {
        System.out.println("Pago de " + monto + " realizado con tarjeta de débito: " + numeroTarjeta);
    }
}
