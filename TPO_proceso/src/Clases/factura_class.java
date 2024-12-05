package Clases;

public class factura_class {
    private int idFactura;
    private cliente_class cliente;
    private reserva_class reserva;
    private double descuento;
    private double total;

    public factura_class(int idFactura, cliente_class cliente, reserva_class reserva, double descuento){
        this.idFactura = idFactura;
        this.cliente = cliente;
        this.reserva = reserva;
        this.descuento = descuento;
        this.total = reserva.ObtenerMontoTotal() - (reserva.ObtenerMontoTotal()*descuento);
    }
    // Getters y Setters
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public cliente_class getCliente() {
        return cliente;
    }

    public void setCliente(cliente_class cliente) {
        this.cliente = cliente;
    }


    public reserva_class getReserva() {
        return reserva;
    }

    public void setReserva(reserva_class reserva) {
        this.reserva = reserva;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
