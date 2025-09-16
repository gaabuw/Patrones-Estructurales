package Bridge;

public class Recordatorio extends Notificacion{
    public Recordatorio(Envio envionoti) {
        super(envionoti);
    }

    @Override
    public void notificar(String mensaje){
        System.out.println("Recordatorio: "+mensaje+envionoti.tipoEnvio() );
    }
}
