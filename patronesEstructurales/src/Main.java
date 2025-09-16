import Adapter.ImpresoraAdapter;
import Adapter.ImpresoraPDF;
import Adapter.NoSoportado;
import Bridge.*;
import Composite.Menu;
import Composite.Plato;
import Decorator.*;
import Facade.Carrito;
import Facade.StoreFacade;
import Flyweight.Arbol;
import Flyweight.ArbolConcreto;
import Flyweight.FabricaDeArboles;
import Proxy.Archivo;
import Proxy.ArchivoProxy;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {

        System.out.println("---------- Prueba del ADAPTER ----------");
        ImpresoraPDF documento = new ImpresoraPDF();
        try {
            documento.imprimir("txt", "Como vender cursos");
            documento.imprimir("pdf", "Sears zemansky");
            documento.imprimir("png", "Imagen");
        } catch (NoSoportado e){
            System.out.println("Error: "+e.getMessage());
        }
        System.out.println("--------------------------------------");

//////////////////////////////////////////////////////////////////////

        System.out.println("---------- Prueba del BRIDGE ----------");
        Notificacion alerta = new Alerta(new SMS());
        Notificacion recordatorio = new Recordatorio(new SMS());
        Notificacion promocion = new Promocion(new SMS());
        //
        Notificacion alerta2 = new Alerta(new Email());
        Notificacion recordatorio2 = new Recordatorio(new Email());
        Notificacion promocion2 = new Promocion(new Email());
        //
        alerta.notificar("Poca bateria");
        alerta2.notificar("Temblor en MENDOZA");
        recordatorio.notificar("Tomar agua");
        recordatorio2.notificar("Dormir temprano");
        promocion.notificar("Descuento en el supermercado");
        promocion2.notificar("Llevas 2 pagas 2");
        System.out.println("--------------------------------------");

//////////////////////////////////////////////////////////////////////

        System.out.println("---------- Prueba del DECORATOR ----------");
        Suscripcion s1 = new Basico();
        Suscripcion s2 = new Basico();

        s1 = new HD(s1);
        s1 = new UltraHD(s1);
        s1 = new DescargasOffline(s1);
        System.out.println(s1.descripcion() + " -> $"+s1.costo());

        s2 = new DescargasOffline(s2);
        System.out.println(s2.descripcion() + " -> $"+s2.costo());
        System.out.println("--------------------------------------");

//////////////////////////////////////////////////////////////////////

        System.out.println("---------- Prueba del FACADE ----------");
        StoreFacade tienda = new StoreFacade();
        java.util.List<String> productos = new java.util.ArrayList<>();
        productos.add("Televisor");
        productos.add("Computadora");
        productos.add("Teclado");

        //Realizamos una compra
        tienda.comprar(productos, "Tarjeta", "Benavente 179");
        System.out.println("--------------------------------------");

//////////////////////////////////////////////////////////////////////

        System.out.println("---------- Prueba del FLYWEIGHT ----------");
        FabricaDeArboles fabrica = new FabricaDeArboles();
        Random rand = new Random();//Esto lo usamos generar números aleatorios


        //Creamos y colocamos los árboles
        int total=1; //Ejemplo
        for(int i=0 ; i< total; i++){

            Arbol arbol1 = fabrica.obtenerArbol("Pino","Verde","TexturaPino");
            Arbol arbol2 = fabrica.obtenerArbol("Sauce","Verde","TexturaSauce");
            Arbol arbol3 = fabrica.obtenerArbol("Magnolia","Rosa","TexturaMagnolia");

            //OJO, tenemos que usar otro metodo para asegurar que no se repitan las posiciones
            int x = rand.nextInt(100000);
            int y = rand.nextInt(100000);
            arbol1.colocar(x,y); //extrinseco: posicion
        }
        //Muestra realmente cuantos Árboles se han creador y colocado
        System.out.println("Los Árboles creados en memoria realmente son: "+fabrica.getArboles());
        System.out.println("La cantidad de Árboles que se han colocado es de : "+total);
        System.out.println("--------------------------------------");

//////////////////////////////////////////////////////////////////////

        System.out.println("---------- Prueba del PROXY ----------");
        List<String> lista = Arrays.asList("Mario", "Jorge");
        Archivo archivo2 = new ArchivoProxy("Notas", "Jorge", lista);
        Archivo archivo1 = new ArchivoProxy("Archivo-Secreto", "Alfredo", lista);

        //Probando el acceso
        archivo1.abrir(); //denegado
        archivo2.abrir(); //Con acceso
        System.out.println("--------------------------------------");

//////////////////////////////////////////////////////////////////////
        
        System.out.println("---------- Prueba del COMPOSITE ----------");
        //Agregamos los Platos individuales
        Plato milanesa = new Plato("Milanesa", 6000);
        Plato lomo = new Plato("Lomo", 7000);
        Plato papas = new Plato("Papas fritas", 2500);
        Plato ensalada = new Plato("Ensalada César", 2000);
        Plato bebida = new Plato("Bebida(Elección)", 1500);
        Plato asado = new Plato("Asado", 10000);
        Plato helado = new Plato("Helado", 2000);
        Plato tiramisu = new Plato("Tiramisú", 2000);
        Plato tarta = new Plato("Tarta", 2000);
        //Creamos los diferentes menús
        Menu menu1 = new Menu("Promoción 1");
        menu1.agregarElemento(milanesa);
        menu1.agregarElemento(papas);
        menu1.agregarElemento(bebida);
        //
        Menu menu2 = new Menu("Promoción 2");
        menu2.agregarElemento(lomo);
        menu2.agregarElemento(bebida);
        menu2.agregarElemento(papas);
        //
        Menu menuEspecial = new Menu("Especial");
        menuEspecial.agregarElemento(asado);
        menuEspecial.agregarElemento(ensalada);
        menuEspecial.agregarElemento(bebida);
        //
        Menu postre1 = new Menu("Frescura helada");
        postre1.agregarElemento(helado);
        Menu postre2 = new Menu("Sueño Italiano");
        postre2.agregarElemento(tiramisu);
        Menu postre3 = new Menu("Receta de la Abuela");
        postre3.agregarElemento(tarta);
        //Probamos todos los menús creados
        menu1.mostrar();
        menu2.mostrar();
        menuEspecial.mostrar();
        postre1.mostrar();
        postre2.mostrar();
        postre3.mostrar();

    }
}