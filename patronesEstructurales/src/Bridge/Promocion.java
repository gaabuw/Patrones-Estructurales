package Bridge;

public class Promocion extends Notificacion{
    public Promocion(Envio envionoti) {
        super(envionoti);
    }

    @Override
    public void notificar(String mensaje){
        System.out.println("Promoción: "+mensaje+envionoti.tipoEnvio());
    }
}
