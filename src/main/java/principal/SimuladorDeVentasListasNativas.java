package principal;

import java.util.LinkedList;

/**
 *
 * @author STEVEN AF
 */
//Simulador de ventas usando LinkedList nativa de Java.
public class SimuladorDeVentasListasNativas {

    //Método principal para ejecutar el simulador.
    public static void main(String[] args) {
        System.out.println("\n--- Proyecto: Simulador de Ventas (Versión Nativa con LinkedList) ---");

        //Productos disponibles.
        String[] productos = {"Bollo", "Suero", "Queso", "Yuca", "Chicha"};
        double[] precios = {1000, 2500, 25000, 2500, 1500};

        //LinkedList para registro secuencial de ventas.
        LinkedList<String> registroVentas = new LinkedList<>();

        //LinkedList para historial navegable de ventas.
        LinkedList<String> historialVentas = new LinkedList<>();

        //Simular 5 ventas aleatorias.
        for (int i = 1; i <= 5; i++) {
            int idx = (int)(Math.random() * productos.length);
            int cantidad = 1 + (int)(Math.random() * 3);
            double total = precios[idx] * cantidad;
            String venta = "Venta " + i + ": " + productos[idx] + " x" + cantidad + " → $" + total;

            registroVentas.addLast(venta);
            historialVentas.addLast(venta);

            System.out.println("Registrando " + venta);
        }

        System.out.println("\n--- Contenido del registro (LinkedList) ---");
        System.out.println(registroVentas);

        System.out.println("\n--- Contenido del historial (LinkedList) ---");
        System.out.println(historialVentas);

        //Eliminar la primera y última venta.
        System.out.println("\nEliminando primera y última venta del historial...");
        historialVentas.removeFirst();
        historialVentas.removeLast();

        System.out.println("\nHistorial actualizado:");
        System.out.println(historialVentas);
    }
}

