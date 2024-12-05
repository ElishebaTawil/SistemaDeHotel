package Controllers;
import Clases.*;
import Interfaces.ExtraInterface;
import Interfaces.FiltroInterface;

import java.util.ArrayList;

public class controller_Habitacion {
    public ArrayList<habitacion_class> listaHabitacion;
    private static controller_Habitacion instancia;

    private controller_Habitacion(){
        this.listaHabitacion = new ArrayList<habitacion_class>();
    }
    public static controller_Habitacion getInstance() {
        if (instancia == null) {
            synchronized (controller_Habitacion.class) {
                if (instancia == null) {
                    instancia = new controller_Habitacion();
                }
            }
        }
        return instancia;
    }

    public void CrearHabitacion(String tipo,int idHabitacion, int cantPersonas, double precio){
        if(tipo.equals("S")){
            habitacion_class Habitacion = new HabitacionSuite(idHabitacion, cantPersonas,precio);
            listaHabitacion.add(Habitacion);

        }else{
            habitacion_class Habitacion = new HabitacionEstandar(idHabitacion, cantPersonas,precio);
            listaHabitacion.add(Habitacion);

        }


    }
    public void EliminarHabitacion(int idHabitacion){
        for(int i = 0; i< listaHabitacion.size(); i++){
            if(listaHabitacion.get(i).getIdHabitacion() == idHabitacion){
                listaHabitacion.remove(i);

            }
        }
    }
    public void ModificarEstadoHabitacion(int idHabitacion){
        for(int i = 0; i< listaHabitacion.size(); i++){
            if(listaHabitacion.get(i).getIdHabitacion() == idHabitacion){
                listaHabitacion.get(i).setEstadoHabitacion();

            }
        }
    }
    public void ModificarPrecioHabitacion(int idHabitacion, double nuevoPrecio){
        for(int i = 0; i< listaHabitacion.size(); i++){
            if(listaHabitacion.get(i).getIdHabitacion() == idHabitacion){
                listaHabitacion.get(i).setPrecioHabitacion(nuevoPrecio);

            }
        }
    }
    public void ModificarExtrasHabitacion(int idHabitacion, ArrayList<ExtraInterface>listaExtras){
        getHabitacion(idHabitacion).setListaExtras(listaExtras);
    }

//    booleanos
    public boolean ExisteHab(int idHab) {
        for (int i = 0; i < listaHabitacion.size(); i++) {
            if (listaHabitacion.get(i).getIdHabitacion() == idHab) {
                return true;
            }
        }
        return false;
    }
    public boolean IsHabDisponible ( int idHab){
        for (int i = 0; i < listaHabitacion.size(); i++) {
            if (ExisteHab(idHab)) {
                if (listaHabitacion.get(i).getEstadoHabitacion() == true) {
                    return true;
                }
            }
        }
        return false;
    }
    public habitacion_class getHabitacion(int idHab){
        for (int i = 0; i < listaHabitacion.size(); i++) {
            if(listaHabitacion.get(i).getIdHabitacion() == idHab  ){
                return listaHabitacion.get(i);
            }
        }
     return null;
    }
    public void filtrarhabTipo(String tipoHab){
        ArrayList<habitacion_class> listaFiltrada= new ArrayList<habitacion_class>();
        filtro_class tipoFiltro = new filtroTipoHab();
        listaFiltrada = tipoFiltro.filtrar(listaHabitacion,tipoHab);
        for(int i = 0; i< listaFiltrada.size();i++){
                System.out.println("ID HABITACION: "+ listaFiltrada.get(i).getIdHabitacion());


        }

    }
    public void filtrarcantPersonas(String cantPersonas){
        ArrayList<habitacion_class> listaFiltrada= new ArrayList<habitacion_class>();
        filtro_class tipoFiltro = new filtroCantPersonas();
        listaFiltrada = tipoFiltro.filtrar(listaHabitacion,cantPersonas);
        for(int i = 0; i< listaFiltrada.size();i++){
                System.out.println("ID HABITACION: "+ listaFiltrada.get(i).getIdHabitacion()+" CAPACIDAD DE PERSONAS: "+ listaFiltrada.get(i).getCantPersonas());

        }

    }
    public void filtrarExtras(String extra){
        ArrayList<habitacion_class> listaFiltrada= new ArrayList<>();
        filtro_class tipoFiltro = new filtroExtras();
        listaFiltrada = tipoFiltro.filtrar(listaHabitacion,extra);
        for(int i = 0; i< listaFiltrada.size();i++){
                System.out.println("ID HABITACION: "+ listaFiltrada.get(i).getIdHabitacion());


        }

    }
    public void HabitacionesDisponibles(){
        for(int i = 0; i<listaHabitacion.size();i++){
            if(listaHabitacion.get(i).getEstadoHabitacion()==true){
                System.out.println("ID HABITACION: "+listaHabitacion.get(i).getIdHabitacion());
            }
        }
    }
    public void HabitacionesNoDisponibles(){
        for(int i = 0; i<listaHabitacion.size();i++){
            if(listaHabitacion.get(i).getEstadoHabitacion() == false){
                System.out.println("ID HABITACION: "+listaHabitacion.get(i).getIdHabitacion());
            }
        }
    }
    public void listarHabitaciones(){
        for(int i = 0; i<listaHabitacion.size();i++){
            System.out.println("ID HABITACION: "+ listaHabitacion.get(i).getIdHabitacion());
        }

    }
    public void getDetalleHabitacion(int idHab){
        for(int i = 0; i<listaHabitacion.size();i++){
            if(listaHabitacion.get(i).getIdHabitacion() == idHab){
                System.out.println("ID HABITACION: "+ listaHabitacion.get(i).getIdHabitacion());
                System.out.println("CAPACIDAD PERSONAS: "+ listaHabitacion.get(i).getCantPersonas());
                System.out.println("PRECIO: "+ listaHabitacion.get(i).getPrecioHabitacion());
                System.out.println("ESTADO: "+ listaHabitacion.get(i).getEstadoHabitacion());
                System.out.println("EXTRAS: ");
                if(!listaHabitacion.get(i).getListaExtras().isEmpty()){
                    for(int j =0; j<listaHabitacion.get(i).getListaExtras().size();j++){
                        System.out.println(listaHabitacion.get(i).getListaExtras().get(j).getTipoExtra());

                    }
                }


            }

        }

    }
    //HARDCODEAR HABITACIONES

    public void inicializar(){
        habitacion_class h1 = new HabitacionSuite(1,4,200);
        habitacion_class h2 = new HabitacionEstandar(2,2,600);
        habitacion_class h3 = new HabitacionSuite(3,10,1000);
        habitacion_class h4 = new HabitacionEstandar(4,1,987);
        habitacion_class h5 = new HabitacionSuite(5,6,1450);
        habitacion_class h6 = new HabitacionEstandar(6,3,659);
        listaHabitacion.add(h1);
        listaHabitacion.add(h2);
        listaHabitacion.add(h3);
        listaHabitacion.add(h4);
        listaHabitacion.add(h5);
        listaHabitacion.add(h6);
        h3.setEstadoHabitacion();


    }

}
