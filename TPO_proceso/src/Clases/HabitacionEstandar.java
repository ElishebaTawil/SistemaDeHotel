package Clases;

public class HabitacionEstandar extends habitacion_class {
    private double incremento;

    public HabitacionEstandar(int idHabitacion, int cantPersonas, double precioHabitacion){
        super(idHabitacion,cantPersonas,precioHabitacion);
        this.incremento=0.0;
        setPrecioHabitacion();
    }

    public double getPrecioHabitacion(){
        return precioHabitacion;
    }
    public void setPrecioHabitacion(){
        this.precioHabitacion = precioHabitacion +  (precioHabitacion * incremento);
    }

}
