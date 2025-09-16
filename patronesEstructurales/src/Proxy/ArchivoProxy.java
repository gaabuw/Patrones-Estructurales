package Proxy;

import java.util.List;

public class ArchivoProxy implements Archivo{
    private ArchivoReal archivoreal;
    private String nombre;
    private List<String> permitidos ; //lista con los usuarios permitidos

    public ArchivoProxy(String archivo, String nombre, List<String> lista){
        this.nombre = nombre;
        this.permitidos = lista;

        if(acceso()){
            archivoreal = new ArchivoReal(archivo);
        }
    }

    private boolean acceso(){
        return permitidos.contains(nombre);
    }

    @Override
    public void abrir() {
        if(acceso()){
            System.out.println("Abriendo archivo... PERMISO CONCEDIDO");
            archivoreal.abrir();
        } else{

            System.out.println("Abriendo archivo.... PERMISO DENEGADO!!");
        }
    }
}
