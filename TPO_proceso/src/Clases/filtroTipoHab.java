package Clases;

import java.util.ArrayList;

public class filtroTipoHab extends filtro_class{
    public filtroTipoHab(){

    }
    public ArrayList<habitacion_class> filtrar(ArrayList<habitacion_class> listaHabitacion, String tipoHabitacion) {
        ArrayList<habitacion_class> habitacionesFiltradas = new ArrayList<>();
        for (habitacion_class habitacion : listaHabitacion) {
            if (tipoHabitacion.equals("S") && habitacion instanceof HabitacionSuite && habitacion.getEstadoHabitacion() == true) {
                habitacionesFiltradas.add(habitacion);
            } else if (tipoHabitacion.equals("E") && habitacion instanceof HabitacionEstandar && habitacion.getEstadoHabitacion() == true) {
                habitacionesFiltradas.add(habitacion);
            }
        }
        return habitacionesFiltradas;
    }
}
