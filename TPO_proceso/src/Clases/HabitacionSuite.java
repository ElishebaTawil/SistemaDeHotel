package Clases;

public class HabitacionSuite extends habitacion_class{
    private double incremento;

    public HabitacionSuite(int idHabitacion, int cantPersonas, double precioHabitacion){
        super(idHabitacion,cantPersonas,precioHabitacion);
        this.incremento=0.30;
        setPrecioHabitacion();
    }

    public double getPrecioHabitacion(){
        return precioHabitacion;
    }
    public void setPrecioHabitacion(){
        this.precioHabitacion = precioHabitacion +  (precioHabitacion * incremento);
    }
}
