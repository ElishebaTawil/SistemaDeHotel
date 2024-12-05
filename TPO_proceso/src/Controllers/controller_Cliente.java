package Controllers;
import Clases.*;

import java.util.ArrayList;
import java.util.Scanner;

public class controller_Cliente {
    public ArrayList<cliente_class> listaClientes;
    private static controller_Cliente instancia;
    private Scanner sc;


    public controller_Cliente(){
        this.listaClientes = new ArrayList<cliente_class>();
        this.sc = new Scanner(System.in);
    }
    public static controller_Cliente getInstance() {
        if (instancia == null) {
            synchronized (controller_Cliente.class) {
                if (instancia == null) {
                    instancia = new controller_Cliente();
                }
            }
        }
        return instancia;
    }
    public void CrearCliente(){
        System.out.println("ingrese el id del cliente");
        int idCliente = Integer.parseInt(sc.next());
        System.out.println("ingrese el nombre del cliente");
        String nombreCliente = sc.next();
        System.out.println("ingrese el apellido del cliente");
        String apellidoCliente = sc.next();
        System.out.println("ingrese el DNI del usuario");
        int DNI = Integer.parseInt(sc.next());
        System.out.println("ingrese el nro de telefono del cliente");
        int telefono = Integer.parseInt(sc.next());
        System.out.println("ingrese el emial del cliente");
        String email = sc.next();
        System.out.println("ingrese el metodo de preferencia de contacto");
        System.out.println("W: Whatsapp, S: SMS, E: email");
        String prefContacto = sc.next();
        contacto_class contacto;
        if(prefContacto.equals("W")){
             contacto = new ContactoWapp();
        }else if(prefContacto.equals("S")){
             contacto = new ContactoSMS();
        }else{
             contacto = new ContactoEmail();
        }
        cliente_class cliente = new cliente_class(idCliente,nombreCliente,apellidoCliente,DNI,telefono,email,contacto);
        listaClientes.add(cliente);
    }
    public void ModificarCliente(int idCliente) {

        cliente_class cliente = getCliente(idCliente);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("¿Qué atributo desea cambiar?");
        System.out.println("1. Nombre");
        System.out.println("2. Apellido");
        System.out.println("3. DNI");
        System.out.println("4. Teléfono");
        System.out.println("5. Email");
        System.out.println("6. Preferencia de Contacto");
        int opcion = Integer.parseInt(sc.next());

        switch (opcion) {
            case 1:
                System.out.println("Ingrese el nuevo nombre:");
                String nuevoNombre = sc.next();
                cliente.setNombreCliente(nuevoNombre);
                break;
            case 2:
                System.out.println("Ingrese el nuevo apellido:");
                String nuevoApellido = sc.next();
                cliente.setApellidoCliente(nuevoApellido);
                break;
            case 3:
                System.out.println("Ingrese el nuevo DNI:");
                int nuevoDNI = Integer.parseInt(sc.next());
                cliente.setDNI(nuevoDNI);
                break;
            case 4:
                System.out.println("Ingrese el nuevo teléfono:");
                int nuevoTelefono = Integer.parseInt(sc.next());
                cliente.setTelefono(nuevoTelefono);
                break;
            case 5:
                System.out.println("Ingrese el nuevo email:");
                String nuevoEmail = sc.next();
                cliente.setEmail(nuevoEmail);
                break;
            case 6:
                System.out.println("Ingrese el nuevo método de preferencia de contacto");
                System.out.println("W: Whatsapp, S: SMS, E: email");
                String nuevoPrefContacto = sc.next();
                contacto_class nuevoContacto;
                if (nuevoPrefContacto.equals("W")) {
                    nuevoContacto = new ContactoWapp();
                } else if (nuevoPrefContacto.equals("S")) {
                    nuevoContacto = new ContactoSMS();
                } else {
                    nuevoContacto = new ContactoEmail();
                }
                cliente.setContacto(nuevoContacto);
                break;
            default:
                System.out.println("Opción no válida.");
        }

        System.out.println("Cliente modificado exitosamente.");
    }
    public void eliminarCliente(int idCliente){
        for(int i = 0; i< listaClientes.size(); i++){
            if(listaClientes.get(i).getIdCliente() == idCliente){
                listaClientes.remove(i);
            }
        }
    }
    public void listarTodosClientes(){
        for(int i = 0; i< listaClientes.size(); i++){
            System.out.println("id cliente: "+listaClientes.get(i).getIdCliente()+" NOMBRE: "+listaClientes.get(i).getNombreCliente()+" APELLIDO: "+ listaClientes.get(i).getApellidoCliente());
        }
        if(listaClientes.isEmpty()){
            System.out.println("no hay clientes cargados");
        }
    }
    public boolean ExisteCliente(int idCliente){
        for(int i = 0; i< listaClientes.size(); i++){
            if(listaClientes.get(i).getIdCliente() == idCliente){
                return true;
            }
        }
        return false;

    }
    public cliente_class getCliente(int idCliente){
        for(int i = 0; i< listaClientes.size(); i++){
            if(listaClientes.get(i).getIdCliente() == idCliente){
                return listaClientes.get(i);
            }

        }
      return null;
    }
//    public void NotificarCliente(controller_Cliente )
        public void Inizializar(){
        contacto_class whats = new ContactoWapp();
        contacto_class SMS = new ContactoSMS();
        cliente_class C1 = new cliente_class(11,"elisheba","tawil",45479188,1234453453,"@gmail.com",whats);
        cliente_class C2 = new cliente_class(12,"eli","taW",45478188,1234453453,"@gmail.com",SMS);
        listaClientes.add(C1);
        listaClientes.add(C2);


        }


}


