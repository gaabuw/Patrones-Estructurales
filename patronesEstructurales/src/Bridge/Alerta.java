package Bridge;

public class Alerta extends Notificacion{
    public Alerta(Envio envionoti){
        super(envionoti);
    }

    @Override
    public void notificar(String mensaje){
        System.out.println("Alerta!!! "+mensaje+envionoti.tipoEnvio());
    }
}
