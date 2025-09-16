package Flyweight;

import java.sql.SQLOutput;

public class ArbolConcreto implements Arbol{
    private final String tipo;
    private final String textura;
    private final String color;

    public ArbolConcreto(String tipo, String textura, String color){
        this.tipo = tipo;
        this.textura = textura;
        this.color = color;
        System.out.println("Creando Árbol de tipo: "+tipo);
    }

    @Override
    public void colocar(int x, int y) {
        System.out.println("Colocando Árbol "+tipo+" en la posición ("+x+","+y+")");
    }
}
