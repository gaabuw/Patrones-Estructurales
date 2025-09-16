package Decorator;

public abstract class SuscripcionDecorador implements Suscripcion{
    protected Suscripcion plan;

    public SuscripcionDecorador(Suscripcion plan){
        this.plan = plan;
    }

    @Override
    public String descripcion(){
        return plan.descripcion();
    }

    @Override
    public double costo(){
        return plan.costo();
    }
}
