package Clases;

import Interfaces.FiltroInterface;

import java.util.ArrayList;

public class filtroCantPersonas extends filtro_class {

    public filtroCantPersonas(){

    }
    public ArrayList<habitacion_class> filtrar(ArrayList<habitacion_class> listaHabitacion, String cantPersonas) {
        int cantidad = Integer.parseInt(cantPersonas);
        ArrayList<habitacion_class> habitacionesFiltradas = new ArrayList<>();
        for (habitacion_class habitacion : listaHabitacion) {
            if (habitacion.getCantPersonas() >= cantidad && habitacion.getEstadoHabitacion() == true) {
                habitacionesFiltradas.add(habitacion);
            }
        }
        return habitacionesFiltradas;
    }
}
