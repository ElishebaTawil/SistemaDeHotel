package Main;
import Controllers.*;
public class Main {
    public static void main(String[] args) {

         controllerGerente CG1 = new controllerGerente(001,"Juan");
         CG1.inicializar();
//         CG1.CrearHabitacion();     //F
//         CG1.listarTodasHabitaciones();     //F
//         CG1.ModificarHabitacion();        //F
//        CG1.ObtenerDestalleDeHabitacion();  //F
//        CG1.listarTodasHabitaciones();      //F
//         CG1.EliminarHabitacion();            //F
//        CG1.listarTodasHabitaciones();           //

//
//        CG1.listarHabitacionesDisponibles();        //F
//        System.out.println("-----------no disponibles: -----------");
//        CG1.listarHabitacionesNoDisponibles();         //F
//

        CG1.listarReservas();  //F
        CG1.CrearReserva();   //F
        CG1.listarReservas();   //F
        CG1.ModificarResrva();   //F
        CG1.listarReservas();//F
        CG1.CancelarReserva();   //F
        CG1.listarReservas();   //F

//        CG1.CrearFactura();  //F
//        CG1.ListarFacturas();  //F
//        CG1.MostrarFactura();   //F
//        CG1.ModificarTotalFactura();  //F
//        CG1.ModificarUsuarioFactura();  //F
//        CG1.EliminarFcatura();   //F
//        CG1.ListarFacturas();   //F


        CG1.listarClientes();   //F
        CG1.CargarCliente();
        CG1.EliminarCliente();   //F
        CG1.listarClientes();    //F
        CG1.listarReservas();

        controllerUsuario CU1 = new controllerUsuario(2,"user");
//        CU1.filtrarHabPersonas();  //F
//        CU1.filtrarHabTipo();      //F
//        CU1.filtrarPorExtra();         //F

//        CU1.CrearReserva();   //F
//        CU1.ModificarResrva();
//        CU1.CancelarReserva();
//        CU1.CancelarPagoReserva();
//        CU1.listarTodasHabitaciones();  //F
//        CU1.ObtenerDestalleDeHabitacion(); //F
//
//        CU1.CargarCliente();  //F


    }
}