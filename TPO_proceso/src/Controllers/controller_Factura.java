package Controllers;
import Clases.*;

import java.util.ArrayList;

public class controller_Factura {
    ArrayList<factura_class> listaFacturas;
    private static controller_Factura instancia;
    private controller_Cliente controllerCliente;
    private controller_Reserva controllerReserva;
    private AreaContable areaContable = new AreaContable();

    private controller_Factura(){

        this.listaFacturas = new ArrayList<factura_class>();
        this.controllerCliente = controller_Cliente.getInstance();
        this.controllerReserva = controller_Reserva.getInstance();

    }
    public static controller_Factura getInstance() {
        if (instancia == null) {
            synchronized (controller_Factura.class) {
                if (instancia == null) {
                    instancia = new controller_Factura();
                }
            }
        }
        return instancia;
    }

    public void CrearFactura(int idFactura, cliente_class Cliente, reserva_class Reserva, double descuento){
        factura_class Factura = new factura_class(idFactura,Cliente,Reserva,descuento);
        listaFacturas.add(Factura);
        Cliente.mandarNotificacion();
        areaContable.NotificarArea(Factura);
    }
    public void imprimirFactura(int idFactura){
        if(getFactura(idFactura) != null){
            factura_class fac = getFactura(idFactura);
            System.out.println("ID FACTURA: "+fac.getIdFactura());
            System.out.println("NOMBRE Y APELLIDO CLIENTE: "+fac.getCliente().getNombreCliente()+" "+fac.getCliente().getApellidoCliente());
            System.out.println("DNI CLIENTE: "+ fac.getCliente().getDNI());
            System.out.println("HABITACION RESREVADA: "+ fac.getReserva().getHabitacion().getIdHabitacion());
            System.out.println("DESCUENTO: "+fac.getDescuento());
            System.out.println("TOTAL: "+fac.getTotal());

        }else{
            System.out.println("no existe la factura a consultar");
        }

    }
    public void listarFacturas(){
        if(listaFacturas.isEmpty()){
            System.out.println("no hay facturas guardadas");
        }else{
            for(int i =0; i<listaFacturas.size();i++){
                System.out.println("ID FACTURA: "+listaFacturas.get(i).getIdFactura());
            }
        }



    }
    public void EliminarFactura(int idFactura){
        for(int i=0; i<listaFacturas.size();i++){
            if(listaFacturas.get(i).getIdFactura() == idFactura){
                areaContable.NotificarArea(listaFacturas.get(i));
                listaFacturas.remove(i);
                System.out.println("se elimino conrrectamente la factura");
            }
        }


    }
    //LOGICA DE NEGOCIO SOLO PODER MODIFICAR LOS DATOS DEL CLIENTE
    public void ModificarFactura(int idFactura){
        System.out.println("solo puede modificar los datos del cliente en la factura");
        if(getFactura(idFactura) != null){
            controllerCliente.ModificarCliente(getFactura(idFactura).getCliente().getIdCliente());
            getFactura(idFactura).setCliente(getFactura(idFactura).getCliente());
        }else{
            System.out.println("no existe la factura");
        }

    }
    //SOLO PARA GERENTE
    public void ModificarPrecioFactura(int idFactura,double precioNuevo){
        if(getFactura(idFactura) != null){
            getFactura(idFactura).setTotal(precioNuevo);
        }

    }
    private factura_class getFactura(int idFactura){
        for(int i = 0; i<listaFacturas.size();i++){
            if(listaFacturas.get(i).getIdFactura() == idFactura){
                return listaFacturas.get(i);
            }
        }
        return null;
    }
    public void Inizializar(){
        factura_class F1 = new factura_class(123, controllerCliente.getCliente(11),controllerReserva.ObtenerReserva(33),0.10);
        listaFacturas.add(F1);
    }
}
