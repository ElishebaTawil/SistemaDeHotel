package Controllers;

import Clases.AreaContable;
import Clases.AreaMarketing;
import Interfaces.ExtraInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class controllerGerente {
    private int idUsuario;
    private String nombreUsuario;
    private controller_Habitacion controllerHabitacion;
    private controller_Cliente controllerClienete;
    private controller_Reserva controllerReserva;
    private controller_Factura controllerFactura;
    private Scanner sc;
    private AreaMarketing areaMarketing = new AreaMarketing();
    private AreaContable areaContable = new AreaContable();


    public controllerGerente(int idUsuario, String nombreUsuario){
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.sc = new Scanner(System.in);
        this.controllerHabitacion = controller_Habitacion.getInstance();
        this.controllerClienete = controller_Cliente.getInstance();
        this.controllerReserva = controller_Reserva.getInstance();
        this.controllerFactura = controller_Factura.getInstance();
    }
    //ABM HABITACION
    public void CrearHabitacion(){
        System.out.println("ingrese el id de la habitacion");
        int idHab = Integer.parseInt(sc.next());
        System.out.println("ingrese el tipo de habitacion a crear(S: suite, E:estandar)");
        String tipo = sc.next();
        System.out.println("ingrese la capacidad de personas de la habitacion");
        int cantPersonas = Integer.parseInt(sc.next());
        System.out.println("ingrese el precio de la habitacion");
        double precioHab = Double.parseDouble(sc.next());
        controllerHabitacion.CrearHabitacion(tipo,idHab,cantPersonas,precioHab);
    }
    public void EliminarHabitacion(){
        System.out.println("ingrese el id de la habitacion a eliminar");
        int idHab = Integer.parseInt(sc.next());
        controllerHabitacion.EliminarHabitacion(idHab);
    }
    public void ModificarHabitacion(){
        System.out.println("ingrese el id de la habitacion a modificar");
        int idHab = Integer.parseInt(sc.next());
        System.out.println("que aspecto desea modificar de la habitacion");
        System.out.println("E: estado, P:precio, EX: extars");
        String aspecto = sc.next();
        if(aspecto.equals("E")){
            controllerHabitacion.ModificarEstadoHabitacion(idHab);
        }else if(aspecto.equals("P")){
            System.out.println("ingrese el precio nuevo a modificar");
            double precioHab = Double.parseDouble(sc.next());
            controllerHabitacion.ModificarPrecioHabitacion(idHab,precioHab);

        }else{
            ArrayList<ExtraInterface> listaExtras = controllerReserva.ObtenerExtras();
            controllerHabitacion.ModificarExtrasHabitacion(idHab,listaExtras);

        }
    }
    public void listarTodasHabitaciones(){
        System.out.println("lista de todas las habitaciones");
        controllerHabitacion.listarHabitaciones();
    }
    public void listarHabitacionesDisponibles(){
        controllerHabitacion.HabitacionesDisponibles();
    }
    public void listarHabitacionesNoDisponibles(){
        controllerHabitacion.HabitacionesNoDisponibles();
    }
    public void ObtenerDestalleDeHabitacion(){
        System.out.println("ingrese el id de la habitacion que desea consultar");
        int idHab = Integer.parseInt(sc.next());
        controllerHabitacion.getDetalleHabitacion(idHab);
    }
//    FILTRAR HABITACIONES
    public void filtrarHabTipo(){
        System.out.println("filtrar por suite(S) o estandar(E)");
        String tipo = sc.next();
        controllerHabitacion.filtrarhabTipo(tipo);
    }
    public void filtrarHabPersonas(){
        System.out.println("ingrese el nro minimo que busca de capacidad de personas");
        String cantPersonas = sc.next();
        controllerHabitacion.filtrarcantPersonas(cantPersonas);

    }
    public void filtrarPorExtra(){
        System.out.println("ingrese el extra deseado a buscar");
        String extra = sc.next();
        controllerHabitacion.filtrarExtras(extra);
    }

    //CLIENTE
    public void CargarCliente(){
        controllerClienete.CrearCliente();
    }
    public void EliminarCliente(){
        System.out.println("ingrese el id del cliente a eliminar");
        int idCliente = Integer.parseInt(sc.next());
        controllerClienete.eliminarCliente(idCliente);
    }
    public void listarClientes(){
        controllerClienete.listarTodosClientes();
    }

//    ABM EFECTUAR RESERVA
    public void CrearReserva(){
        controllerReserva.CrearReserva();
    }
    public void CancelarReserva(){
        System.out.println("ingrese el id de la resserva a cancelar");
        int idReserva = Integer.parseInt(sc.next());
        controllerReserva.CancelarReserva(idReserva);
    }
    public void ModificarResrva(){
        controllerReserva.ModificarReserva();
    }
    public void ModificarPrecioReserva(){
        System.out.println("ingrse el id de la reserva a modificar");
        int idReserva = Integer.parseInt(sc.next());
        System.out.println("ingrese el nuevo precio de la reserva");
        int NuevoPrecio = Integer.parseInt(sc.next());
        controllerReserva.ModificarPrecioReserva(idReserva,NuevoPrecio);
    }
    public void listarReservas(){
        controllerReserva.ListarReservas();
    }

    //ABM FACTURAS
    public void CrearFactura() {
        System.out.println("ingrese el id de la reserva a facturar");
        int idReserva = Integer.parseInt(sc.next());
        if (controllerReserva.ObtenerReserva(idReserva) == null) {
            System.out.println("la reserva ingresada no existe");
        } else {

            System.out.println("ingrse el id de la factura");
            int idFactura = Integer.parseInt(sc.next());
            System.out.println("Quiere aplicar algun descuento?(S/N)");
            String rta = sc.next();
            double desc = 0;
            if (rta.equals("S")) {
                System.out.println("Que porcentaje de descuento quiere aplicar?");
                String descuento = sc.next();
                try {
                    desc = Double.parseDouble(descuento);
                } catch (NumberFormatException e) {
                    System.out.println("Error: la cadena no se puede convertir a double.");
                }
            }
            controllerFactura.CrearFactura(idFactura, controllerReserva.ObtenerReserva(idReserva).getCliente(), controllerReserva.ObtenerReserva(idReserva), desc);
        }
    }
    public void EliminarFcatura(){
        System.out.println("ingrse el id de la factura que desea eliminar");
        int idFactura = Integer.parseInt(sc.next());
        controllerFactura.EliminarFactura(idFactura);
    }
    public void ModificarUsuarioFactura(){
        System.out.println("ingrese el id de la factura a modificar");
        int idFactura = Integer.parseInt(sc.next());
        controllerFactura.ModificarFactura(idFactura);
    }
    public void ModificarTotalFactura(){
        System.out.println("ingrese el id de la factura a modificar");
        int idFactura = Integer.parseInt(sc.next());
        System.out.println("ingrse el monto nuevo de la  factura a modificar");
        String total = sc.next();
        double totalFinal=0;
        try {
            totalFinal = Double.parseDouble(total);
        } catch (NumberFormatException e) {
            System.out.println("Error: la cadena no se puede convertir a double.");
        }
        controllerFactura.ModificarPrecioFactura(idFactura,totalFinal);
    }
    public void ListarFacturas(){
        controllerFactura.listarFacturas();
    }
    public void MostrarFactura(){
        System.out.println("ingrese el id de la factura a consultar");
        int idFac = Integer.parseInt(sc.next());

        controllerFactura.imprimirFactura(idFac);
    }
    public void inicializar(){
        controllerHabitacion.inicializar();
        controllerClienete.Inizializar();
        controllerReserva.Inizializar();
        controllerFactura.Inizializar();
    }

}
