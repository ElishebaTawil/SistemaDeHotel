package Clases;

public class ContactoSMS extends contacto_class{
    private String tipo;
    public ContactoSMS(){
        this.tipo = "SMS";
    }

    public void mandarNotificacion(String variable){
        System.out.println("se mando un SMS al nro"+ variable);
    }
    public String getTipoContacto(){
        return this.tipo;
    };
}
