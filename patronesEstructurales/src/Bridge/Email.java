package Bridge;

public class Email implements Envio{

    @Override
    public String tipoEnvio(){
        return " -Vía Email";
    }
}
