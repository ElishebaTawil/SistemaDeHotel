package Clases;

import Interfaces.ExtraInterface;

public class ExtraMiniBar implements ExtraInterface {
    public String getTipoExtra(){
        return "MiniBar";
    }
    public double getPrecioAdicional(){return 650.00;}
}
