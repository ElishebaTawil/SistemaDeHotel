package Controllers;
import Clases.*;
import Interfaces.ExtraInterface;
import Interfaces.PagoInterface;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class controller_Reserva {
    public ArrayList<reserva_class> listaReservas;
    private static controller_Reserva instancia;
    private Scanner sc;
    private controller_Cliente controllerClienete;
    private controller_Habitacion controllerHabitacion;
    private AreaMarketing areaMarketing = new AreaMarketing();

    public controller_Reserva(){
        this.listaReservas = new ArrayList<reserva_class>();
        this.sc = new Scanner(System.in);
        this.controllerClienete = controller_Cliente.getInstance();
        this.controllerHabitacion = controller_Habitacion.getInstance();
    }
    public static controller_Reserva getInstance() {
        if (instancia == null) {
            synchronized (controller_Reserva.class) {
                if (instancia == null) {
                    instancia = new controller_Reserva();
                }
            }
        }
        return instancia;
    }
    //AMB RESERVA
    public void CrearReserva(){
        cliente_class Cliente;
        habitacion_class Habitacion;
        Date fechaReserva = null;
        Date checkIn = null;
        Date checkOut = null;

        while (true) {
            System.out.println("Ingrese el ID del cliente (0 si no se registró):");
            int idCliente = Integer.parseInt(sc.next());


            if (idCliente == 0 || controllerClienete.ExisteCliente(idCliente)==false) {
                 controllerClienete.CrearCliente();
//                break; // Salir del bucle si se crea un nuevo cliente
            } else if (controllerClienete.ExisteCliente(idCliente)==true) {
                Cliente = controllerClienete.getCliente(idCliente);
                break; // Salir del bucle si se obtiene un cliente existente
            } else {
                System.out.println("ID de cliente no válido. Por favor, intente nuevamente.");
            }
        }
        System.out.println("ingrese el id de la reserva");
        int idReserva = Integer.parseInt(sc.next());

        System.out.println("quiere habitacion suite o estandar?(S, E) ");
        String tipoHab = sc.next();
        controllerHabitacion.filtrarhabTipo(tipoHab);
        System.out.println("para cuantas personas esta buscando habitacion");
        String cantPersonas = sc.next();
        controllerHabitacion.filtrarcantPersonas(cantPersonas);


//
        while (true) {
            System.out.print("Ingrese el ID de la habitación a reservar: ");
            int id = Integer.parseInt(sc.next());

            if (controllerHabitacion.ExisteHab(id) && controllerHabitacion.getHabitacion(id).getEstadoHabitacion() == true) {
                System.out.print("Habitación disponible. Ingrese el ID de la habitación nuevamente para confirmar: ");
                int idHab = Integer.parseInt(sc.next());
                 Habitacion = controllerHabitacion.getHabitacion(idHab);
                 Habitacion.setEstadoHabitacion();
                // Puedes agregar más lógica aquí si lo deseas, como salir del bucle si la operación se completa
                System.out.println("Habitación " + idHab + " seleccionada correctamente.");
                break; // Sal del bucle si la habitación es válida y se confirma correctamente
            } else {
                System.out.println("Esa habitación no está disponible, ingrésela nuevamente.");
            }
        }
        ArrayList<ExtraInterface> listaExtras = ObtenerExtras();


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Ingrese la fecha de reserva (dd/MM/yyyy): ");
        fechaReserva = pasarFormatoFecha(sc.next());

        System.out.print("Ingrese la fecha de checkIn (dd/MM/yyyy): ");
        checkIn = pasarFormatoFecha(sc.next());

        System.out.print("Ingrese la fecha de checkOut (dd/MM/yyyy): ");
        checkOut = pasarFormatoFecha(sc.next());

        System.out.println("ingrse el medio de pago preferente");
        System.out.println("E: efectivo, MP: mercado pago, TC: tarjeta credito, TD: tarjeta debito");
        String medioPago = sc.next();


        PagoInterface pago = getTipoPago(medioPago);
        reserva_class Resreva = new reserva_class(idReserva,Habitacion,fechaReserva,checkIn,checkOut,Cliente,pago, listaExtras);
        listaReservas.add(Resreva);
        Habitacion.setListaExtras(listaExtras);
        System.out.println("el total de la reserva es: "+ Resreva.ObtenerMontoTotal() );
        Habitacion.setEstadoHabitacion();
        Cliente.mandarNotificacion();
        areaMarketing.NotificarArea(Resreva);

    }
    public ArrayList<ExtraInterface> ObtenerExtras(){
        ArrayList<ExtraInterface> listaExtras = new ArrayList<>();
        System.out.println("desea añadir algun extra a la habitacion(S,N)");
        String rta= sc.next();
        if(rta.equals("S")){
            System.out.println("añadir Internet?(S,N)");
            String rtaI = sc.next();
            if(rtaI.equals("S")){
                ExtraInterface Internet = new ExtraInternet();
                listaExtras.add(Internet);
            }
            System.out.println("añadir Despertador?(S,N)");
            String rtaD = sc.next();
            if(rtaD.equals("S")){
                ExtraInterface Despertador = new ExtraDespertador();
                listaExtras.add(Despertador);
            }
            System.out.println("añadir Mini Bar?(S,N)");
            String rtaMB = sc.next();
            if(rtaMB.equals("S")){
                ExtraInterface MiniBar = new ExtraMiniBar();
                listaExtras.add(MiniBar);
            }
            System.out.println("añadir TV?(S,N)");
            String rtaTV = sc.next();
            if(rtaTV.equals("S")){
                ExtraInterface TV = new ExtraTV();
                listaExtras.add(TV);
            }

        }
        return listaExtras;
    }



    public void CancelarReserva(int idReserva){
        for(int i = 0; i<listaReservas.size();i++){
            if(listaReservas.get(i).getIdReserva() == idReserva){
                areaMarketing.NotificarArea(listaReservas.get(i));
                listaReservas.remove(i);
                System.out.println("se cancelo su reserva exitosamente");

            }
        }

    }
    //TODO
//    public void CancelarReservaAutomatico(int idReserva){
//        for(int i = 0; i<listaReservas.size();i++){
//            if(listaReservas.get(i).getIdReserva() == idReserva){
//                listaReservas.remove(i);
//                System.out.println("se cancelo su reserva exitosamente");
//            }
//        }
//
//    }
    public void ModificarReserva(){
        System.out.println("ingrese el id de la reserva a modificar");
        int idReserva = Integer.parseInt(sc.next());
//        ObtenerReserva(idReserva)
        System.out.println("que desea modificar de la reserva?");
        System.out.println("H: habitacion");
        System.out.println("FI: fecha check-in");
        System.out.println("FF: fecha check-out");
        System.out.println("MP: medio de pago");
        String var = sc.next();
        if(var.equals("H")){
            System.out.println("ingrese el id de la nueva habitacion");
            int idHab = Integer.parseInt(sc.next());
            ObtenerReserva(idReserva).setHabitacion(controllerHabitacion.getHabitacion(idHab));
        }else if(var.equals("FI")){
            System.out.println("ingrese la nueva fecha de check-in(dd/mm/aa)");
            Date fechaNueva = pasarFormatoFecha(sc.next());
            ObtenerReserva(idReserva).setCheckIn(fechaNueva);
        }else if(var.equals("FF")){
            System.out.println("ingrese la nueva fecha de check-out(dd/mm/aa)");
            Date fechaNueva = pasarFormatoFecha(sc.next());
            ObtenerReserva(idReserva).setCheckOut(fechaNueva);

        }else if(var.equals("MP")){
            System.out.println("ingrse su metodo de pago preferente");
            PagoInterface pagoNuevo = getTipoPago(sc.next());
        }
        areaMarketing.NotificarArea(ObtenerReserva(idReserva));

    }
    //SOLO PARA USUARIO
    public void CancelarPagoReserva(int idReserva){
        ObtenerReserva(idReserva).cancelarReserva();   //pone el estado del pago en estado cancelado
        ObtenerReserva(idReserva).getCliente().mandarNotificacion();


    }
    public void pagarReserva(int idReserva){
        ObtenerReserva(idReserva).realizarPago();
        ObtenerReserva(idReserva).getCliente().mandarNotificacion();

    }
    //    SOLO PARA GERENTE
    public void ModificarPrecioReserva(int idReserva, double nuevoPrceio){
        ObtenerReserva(idReserva).setMontoTotal(nuevoPrceio);

    }
    public void ListarReservas(){
        for(int i=0;i<listaReservas.size();i++){
            System.out.println("ID RESERVA: "+listaReservas.get(i).getIdReserva()
            + "HABITACION RESERVA: "+ listaReservas.get(i).getHabitacion().getIdHabitacion()+
                    "CLIENTE: "+listaReservas.get(i).getCliente().getNombreCliente());
        }
    }
    public reserva_class ObtenerReserva(int idReserva){
        for(int i = 0; i<listaReservas.size();i++){
            if(listaReservas.get(i).getIdReserva() == idReserva){
                return listaReservas.get(i);
            }
        }
        return null;
    }
    private PagoInterface getTipoPago(String medioPago){
        PagoInterface pago;
        if(medioPago.equals("E")){
            pago = new PagoEfectivo();
        }else if(medioPago.equals("MP")){
            pago = new PagoMercadoPago();
        }else if(medioPago.equals("TC")){
            System.out.println("ingrese el nro de la tarjeta(16 digitos)");
            String nroTarjeta = sc.next();
            pago = new PagoTarjetaCredito(nroTarjeta);

        }else{
            System.out.println("ingrese el nro de la tarjeta(16 digitos)");
            String nroTarjeta = sc.next();
            pago = new PagoTarjetaDebito(nroTarjeta);
        }
        return pago;

    }
    private Date pasarFormatoFecha(String fecha){
        Date fecha1 = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try{
            fecha1 = dateFormat.parse(fecha);
        }catch (ParseException e) {
            System.out.println("Error al parsear la fecha: " + e.getMessage());

        }
        return fecha1;

    }
    public void Inizializar(){
        PagoInterface MP = new PagoMercadoPago();
        ArrayList<ExtraInterface> listaExtras = new ArrayList<>();
        ExtraInterface TV = new ExtraTV();
        ExtraInterface MiniBar = new ExtraMiniBar();
        listaExtras.add(TV);
        listaExtras.add(MiniBar);
        reserva_class R1 = new reserva_class(33,controllerHabitacion.getHabitacion(1),pasarFormatoFecha("11/12/2003"),pasarFormatoFecha("28/12/2003"),pasarFormatoFecha("20/12/2003"),controllerClienete.getCliente(11),MP,listaExtras);
        reserva_class R2 = new reserva_class(34,controllerHabitacion.getHabitacion(2),pasarFormatoFecha("10/11/2003"),pasarFormatoFecha("23/11/2003"),pasarFormatoFecha("30/11/2003"),controllerClienete.getCliente(12),MP,listaExtras);
        controllerHabitacion.getHabitacion(1).setListaExtras(listaExtras);
        controllerHabitacion.getHabitacion(1).setEstadoHabitacion();
        controllerHabitacion.getHabitacion(2).setListaExtras(listaExtras);
        controllerHabitacion.getHabitacion(2).setEstadoHabitacion();
        listaReservas.add(R1);
        listaReservas.add(R2);
    }





}
