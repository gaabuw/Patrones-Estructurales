package Proxy;

public class ArchivoReal implements Archivo{
    private String archivo;

    public ArchivoReal(String archivo){
        this.archivo = archivo;
    }

    @Override
    public void abrir(){
        System.out.println("->"+this.archivo);
    }


}
