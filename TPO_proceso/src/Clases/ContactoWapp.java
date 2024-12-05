package Clases;

public class ContactoWapp extends contacto_class{
    private String tipo;

    public ContactoWapp(){
        this.tipo = "WhatsApp";
    }

    public void mandarNotificacion(String variable){
        System.out.println("se mando un whatsapp al nro"+ variable);
    }
    public String getTipoContacto(){
        return this.tipo;
    };
}
