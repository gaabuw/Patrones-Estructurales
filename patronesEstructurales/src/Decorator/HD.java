package Decorator;

public class HD extends SuscripcionDecorador {

    public HD(Suscripcion plan){
        super(plan);
    }

    @Override
    public String descripcion(){
        return plan.descripcion()+" + HD" ;
    }

    @Override
    public double costo(){
        return plan.costo() + 500 ;
    }
}
