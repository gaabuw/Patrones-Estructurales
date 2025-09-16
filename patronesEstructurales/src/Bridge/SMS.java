package Bridge;

public class SMS implements Envio{

    @Override
    public String tipoEnvio(){
        return " -Vía SMS";
    }
}
