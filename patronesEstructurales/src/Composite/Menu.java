package Composite;

import java.util.ArrayList;
import java.util.List;

public class Menu implements ElementoMenu{
    private String nombre; //Nombre que llevara el menú
    private List<ElementoMenu> elementos = new ArrayList<>();

    public Menu(String nombre){
        this.nombre = nombre;
    }

    //Metodo para armar menús
    public void agregarElemento(ElementoMenu elemento){
        elementos.add(elemento);
    }
    //Este metodo sirve para desarmar los menús
    public void quitarelemento(ElementoMenu elemento){
        elementos.remove(elemento);
    }

    @Override
    public void mostrar(){
        double total = 0;
        System.out.println("Menú --> "+nombre);
        for(ElementoMenu elemento: elementos){
            elemento.mostrar();
            total += elemento.getPrecio();
        }
        System.out.println(">> Precio total: $" + total);
        System.out.println("");
    }

    @Override
    public double getPrecio() {
        double total = 0;
        for (ElementoMenu e : elementos) {
            total += e.getPrecio();
        }
        return total;
    }
}
