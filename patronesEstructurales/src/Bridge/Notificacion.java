package Bridge;

public abstract class Notificacion {
    protected Envio envionoti;

    public Notificacion(Envio envionoti){
        this.envionoti = envionoti ;
    }
    public abstract void notificar(String mensaje);
}
