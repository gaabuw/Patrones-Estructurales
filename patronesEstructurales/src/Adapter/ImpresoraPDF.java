package Adapter;

public class ImpresoraPDF implements Impresion{
    private ImpresoraAdapter impresoraAdapter;

    @Override
    public void imprimir(String docType, String fileName){
        if(docType.equalsIgnoreCase("PDF")){
            System.out.println("Imprimiendo: "+fileName+", con formato PDF");
        } else {
            impresoraAdapter = new ImpresoraAdapter();
            impresoraAdapter.imprimir(docType, fileName);
        }
    }
}
