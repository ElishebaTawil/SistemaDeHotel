package Controllers;

import java.util.Scanner;

public class controllerUsuario {
    private int idUsuario;
    private String nombreUsuario;

    private controller_Cliente controllerClienete;
    private controller_Reserva controllerReserva;
    private controller_Habitacion controllerHabitacion;
    private controller_Factura controllerFactura;
    private Scanner sc;

    public controllerUsuario(int idUsuario, String nombreUsuario){
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.sc = new Scanner(System.in);
        this.controllerClienete = controller_Cliente.getInstance();
        this.controllerReserva = controller_Reserva.getInstance();
        this.controllerHabitacion = controller_Habitacion.getInstance();
        this.controllerFactura = controller_Factura.getInstance();
    }

    //HABITACION
    public void listarTodasHabitaciones(){
        System.out.println("lista de todas las habitaciones");
        controllerHabitacion.listarHabitaciones();
    }
    public void ObtenerDestalleDeHabitacion(){
        System.out.println("ingrese el id de la habitacion que desea consultar");
        int idHab = Integer.parseInt(sc.next());
        controllerHabitacion.getDetalleHabitacion(idHab);
    }
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
    public void PagarReserva(){
        System.out.println("ingrese el id de la reserva a pagar");
        int idReserva = Integer.parseInt(sc.next());
        controllerReserva.pagarReserva(idReserva);

    }
    public void CancelarPagoReserva(){
        System.out.println("ingrese el id de la reserva a pagar");
        int idReserva = Integer.parseInt(sc.next());
        controllerReserva.CancelarPagoReserva(idReserva);

    }

    //ABM FACTURAS
    public void CrearFactura(){
        System.out.println("ingrese el id de la reserva a facturar");
        int idReserva = Integer.parseInt(sc.next());

        System.out.println("ingrse el id de la factura");
        int idFactura = Integer.parseInt(sc.next());
        System.out.println("Quiere aplicar algun descuento?(S/N)");
        String rta= sc.next();
        double desc = 0;
        if(rta.equals("S")){
            System.out.println("Que porcentaje de descuento quiere aplicar?");
            String descuento = sc.next();
            try {
                desc = Double.parseDouble(descuento);
            } catch (NumberFormatException e) {
                System.out.println("Error: la cadena no se puede convertir a double.");
            }
        }
        controllerFactura.CrearFactura(idFactura,controllerReserva.ObtenerReserva(idReserva).getCliente(),controllerReserva.ObtenerReserva(idReserva),desc);
    }
    public void EliminarFcatura(){
        System.out.println("ingrse el id de la resreva que desea eliminar");
        int idFactura = Integer.parseInt(sc.next());
        controllerFactura.EliminarFactura(idFactura);
    }
    public void ModificarUsuarioFactura(){
        System.out.println("ingrese el id de la factura a modificar");
        int idFactura = Integer.parseInt(sc.next());
        controllerFactura.ModificarFactura(idFactura);
    }
    public void MostrarFactura(){
        System.out.println("ingrese el id de la factura a consultar");
        int idFac = Integer.parseInt(sc.next());
        controllerFactura.imprimirFactura(idFac);
    }


}
