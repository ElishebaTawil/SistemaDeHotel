package Clases;

public class cliente_class {
    private int idCliente;
    private String apellidoCliente;
    private String nombreCliente;
    private int DNI;
    private int telefono;
    private String email;
    private contacto_class contacto;

    public cliente_class(int idCliente, String nombreCliente, String apellidoCliente, int DNI, int telefono, String email, contacto_class contacto){
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.DNI = DNI;
        this.telefono = telefono;
        this.email = email;
        this.contacto = contacto;
    }

    // Getters y Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getEmail(){return this.email;}
    public void setEmail(String email){this.email=email;}

    public contacto_class getContacto() {
        return contacto;
    }

    public void setContacto(contacto_class contacto) {
        this.contacto = contacto;
    }
    public void mandarNotificacion(){
        if(contacto.getTipoContacto().equals("Email")){
            contacto.mandarNotificacion(email);
        }else{
            contacto.mandarNotificacion(String.valueOf(telefono));
        }

    }

}
