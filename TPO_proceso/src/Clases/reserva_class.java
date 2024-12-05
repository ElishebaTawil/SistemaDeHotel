package Clases;

import Interfaces.EstadoInterface;
import Interfaces.ExtraInterface;
import Interfaces.PagoInterface;

import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;



public class reserva_class {
    private int idReserva;
    private habitacion_class Habitacion;
    private Date fechaReserva;
    private Date checkIn;
    private Date checkOut;
    private cliente_class Cliente;
    private PagoInterface metodoPago;
    private EstadoInterface estado;
    public ArrayList<ExtraInterface> listaExtras = new ArrayList<>();
    public double totalResreva;

    public reserva_class(int idReserva,habitacion_class idHabitacion,Date fechaReserva,Date checkIn, Date checkOut, cliente_class clienteRegistrado, PagoInterface metodoPago, ArrayList<ExtraInterface> listaExtras) {
        this.idReserva = idReserva;
        this.Habitacion = idHabitacion;
        this.fechaReserva = fechaReserva;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.Cliente = clienteRegistrado;
        this.metodoPago = metodoPago;
        this.estado = new EstadoPendiente();
        this.listaExtras = listaExtras;

    }

    // Getters y Setters
    public int getIdReserva(){
        return idReserva;
    }
    public void setIdReserva(int idReserva){
        this.idReserva = idReserva;
    }
    public habitacion_class getHabitacion() {
        return Habitacion;
    }

    public void setHabitacion(habitacion_class habitacion) {
        this.Habitacion = habitacion;
    }
    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public cliente_class getCliente() {
        return Cliente;
    }

    public void setCliente(cliente_class cliente) {
        this.Cliente = cliente;
    }

    public PagoInterface getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(PagoInterface metodoPago) {
        this.metodoPago = metodoPago;
    }
    public String getEstado(){
        return this.estado.getEstado();
    }
    public void setEstado(EstadoInterface estado){
        this.estado = estado;

    }
    public void setListaExtras(ArrayList<ExtraInterface> listaExtras){
        this.listaExtras = listaExtras;
    }
    public ArrayList<ExtraInterface> getListaExtras(){
        return listaExtras;

    }

    //otros metodos
    public void realizarPago() {

        metodoPago.realizarPago(ObtenerMontoTotal());
        setEstado(this.estado = new EstadoPagada());

        //TODO MANDAR VIA CONTACTO
        ;
    }
    //CALCULAR TOTAL A PAGAR
    public double ObtenerMontoTotal(){
        long dias = ObtenerProximidadFecha();
        double precioHab= Habitacion.getPrecioHabitacion() + getPrecioExtras();

        if(dias >= 15){
            precioHab = precioHab - (precioHab*0.15);
        }else if(dias >=60){
            precioHab = precioHab + (precioHab*0.20);
        }
        this.totalResreva = precioHab;
        return precioHab;
    }
    public void setMontoTotal(double nuevoPrecio){
        this.totalResreva = nuevoPrecio;
    }
    public void cancelarReserva(){
        this.estado = new EstadoCancelada();
    }
    private double getPrecioExtras(){
        double total=0;
        for(int i=0;i<listaExtras.size();i++){
            total = total + listaExtras.get(i).getPrecioAdicional();
        }
        return total;
    }

    // Método para calcular la diferencia en días
    private long ObtenerProximidadFecha() {
        if (fechaReserva != null && checkIn != null) {
            LocalDate fechaReservaLocal = convertirADateLocal(fechaReserva);
            LocalDate checkInLocal = convertirADateLocal(checkIn);
            return ChronoUnit.DAYS.between(fechaReservaLocal, checkInLocal);
        } else {
            throw new IllegalStateException("Las fechas no pueden ser nulas");
        }
    }

    // Método auxiliar para convertir Date a LocalDate
    private LocalDate convertirADateLocal(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }


}
