package Flyweight;

import java.util.HashMap;
import java.util.Map;

//Flyweight Factory
public class FabricaDeArboles {
    private Map<String, Arbol> arboles = new HashMap<>();

    public Arbol obtenerArbol(String tipo, String textura, String color){

        String key = tipo + "-" + textura + "-" + color;
        Arbol arbol = arboles.get(key);
        if (arbol == null) {
            arbol = new ArbolConcreto(tipo, textura, color);
            arboles.put(key, arbol);
        }
        return arbol;
    }

    public int getArboles() {
        return arboles.size();
    }
}
