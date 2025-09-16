package Adapter;

public class ImpresoraAdapter implements Impresion{
    private ImpresoraTexto impresoratexto;

    public ImpresoraAdapter(){
        impresoratexto = new ImpresoraTexto();
    }

    @Override
    public void imprimir(String docType, String fileName) {
        if(docType.equalsIgnoreCase("TXT")){
            impresoratexto.imprimirTexto(fileName);
        }  else {
           throw new NoSoportado("Formato no soportado: "+docType);
        }
    }
}
