package Facade;

public class StoreFacade {
    private Carrito carrito;
    private Pago pago;
    private Envio envio;

    public StoreFacade() {
        carrito = new Carrito();
        pago = new Pago();
        envio = new Envio();
    }

    public void comprar(java.util.List<String> productos, String tipoPago, String direccion){
        for(String producto : productos){
            carrito.agregarProducto(producto);
        }
        pago.procesar(tipoPago);
        envio.entrega(direccion);
        System.out.println("Compra realizada con éxito!!!");
    }


}
