package Clases;

public class ContactoEmail extends contacto_class{
    private String tipo;
    public ContactoEmail(){
        this.tipo = "Email";
    }

    public void mandarNotificacion(String variable){
        System.out.println("se mando un email a la direccion"+ variable);
    }
    public String getTipoContacto(){
        return this.tipo;
    };


}
