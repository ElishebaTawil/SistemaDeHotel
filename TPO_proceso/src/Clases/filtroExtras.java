package Clases;

import Interfaces.ExtraInterface;

import java.util.ArrayList;

public class filtroExtras extends filtro_class{
    public ArrayList<habitacion_class> filtrar(ArrayList<habitacion_class> listaHabitacion, String extra) {
        ArrayList<habitacion_class> habitacionesFiltradas = new ArrayList<>();
        for (habitacion_class habitacion : listaHabitacion) {
            ArrayList<ExtraInterface> listaExtra = habitacion.getListaExtras();
            for(int e = 0; e< listaExtra.size();e++){
                if(listaExtra.get(e).getTipoExtra().equals(extra)){
                    habitacionesFiltradas.add(habitacion);
                }
            }

        }
        return habitacionesFiltradas;
    }
}
