package Decorator;

public class UltraHD extends SuscripcionDecorador{
    public UltraHD(Suscripcion plan){
        super(plan);
    }

    @Override
    public String descripcion(){
        return plan.descripcion() + " + UltraHD" ;
    }

    @Override
    public double costo(){
        return plan.costo() + 1000 ;
    }

}
