package Decorator;

public class DescargasOffline extends SuscripcionDecorador{
    public DescargasOffline(Suscripcion plan){
        super(plan);
    }

    @Override
    public String descripcion(){
        return plan.descripcion() + " + Descargas Offline";
    }

    @Override
    public double costo(){
        return plan.costo() + 700 ;
    }
}
