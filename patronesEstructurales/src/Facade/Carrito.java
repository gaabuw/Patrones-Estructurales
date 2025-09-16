package Facade;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<String> productos = new ArrayList<>();

    public void agregarProducto(String producto){
        productos.add(producto);
        System.out.println("Producto agregado al carrito: "+ producto);
    }

    public List<String> getProductos() {
        return productos;
    }
}
