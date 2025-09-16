package Decorator;

public class Basico implements Suscripcion{

    @Override
    public String descripcion() {
        return "Plan básico";
    }

    @Override
    public double costo(){
        return 1000.0 ;
    }
}
