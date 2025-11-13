package principal;

import modelos.SinglyLinkedList;
import modelos.DoublyLinkedList;

/**
 *
 * @author STEVEN AF
 */
//Simulador de ventas usando listas enlazadas.
public class SimuladorDeVentasListas {
    //Simulador de ventas usando listas enlazadas.
    //Método principal para ejecutar el simulador.
    public static void main(String[] args) {
        System.out.println("\n--- Proyecto: Simulador de Ventas (con Listas) ---");

        //Productos disponibles.
        String[] productos = {"Bollo", "Suero", "Queso", "Yuca", "Chicha"};
        double[] precios = {1000, 2500, 25000, 2500, 1500};

        //Lista simplemente enlazada para registro secuencial de ventas.
        SinglyLinkedList<String> registroVentas = new SinglyLinkedList<>();

        //Lista doblemente enlazada para historial navegable de ventas.
        DoublyLinkedList<String> historialVentas = new DoublyLinkedList<>();

        //Simular 5 ventas aleatorias.
        for (int i = 1; i <= 5; i++) {
            int idx = (int)(Math.random() * productos.length);
            int cantidad = 1 + (int)(Math.random() * 3);
            double total = precios[idx] * cantidad;
            String venta = "Venta " + i + ": " + productos[idx] + " x" + cantidad + " → $" + total;

            registroVentas.addLast(venta);  //Registro secuencial.
            historialVentas.addLast(venta); //Historial navegable.

            System.out.println("Registrando " + venta);
        }

        System.out.println("\n--- Contenido del registro (SinglyLinkedList) ---");
        System.out.println(registroVentas);

        System.out.println("\n--- Contenido del historial (DoublyLinkedList) ---");
        System.out.println(historialVentas);

        //Eliminar la primera y última venta para demostrar métodos.
        System.out.println("\nEliminando primera y última venta del historial...");
        historialVentas.removeFirst();
        historialVentas.removeLast();

        System.out.println("\nHistorial actualizado:");
        System.out.println(historialVentas);
    }
}

