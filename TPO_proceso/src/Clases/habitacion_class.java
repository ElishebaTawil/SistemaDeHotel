package Clases;

import Interfaces.ExtraInterface;

import java.util.ArrayList;

public class habitacion_class {
    private int idHabitacion;
    private int cantPersonas;
    private boolean estadoHabitacion;
    public double precioHabitacion;
    public ArrayList<ExtraInterface> listaExtras;


    //se instancia
    public habitacion_class(int idHabitacion, int cantPersonas, double precioHabitacion) {
        this.idHabitacion = idHabitacion;
        this.cantPersonas = cantPersonas;
        this.estadoHabitacion = true;
        this.precioHabitacion = precioHabitacion;
        this.listaExtras = new ArrayList<>();
    }

    // Getters y Setters
    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public boolean getEstadoHabitacion() {
        return estadoHabitacion;
    }

    public void setEstadoHabitacion() {
        this.estadoHabitacion = !estadoHabitacion;
    }

    public double getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(double precio) {
        this.precioHabitacion = precio;
    }

    public void setListaExtras(ArrayList<ExtraInterface> listaExtras) {
        this.listaExtras = listaExtras;
    }

    public ArrayList<ExtraInterface> getListaExtras() {
        return listaExtras;

    }


}