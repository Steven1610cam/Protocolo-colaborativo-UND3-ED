package principal;

import modelos.DoublyLinkedList;

/**
 *
 * @author STEVEN AF
 */
public class PruebaListaDoble {
    public static void main(String[] args) {
        System.out.println("--- Prueba de DoublyLinkedList ---");

        DoublyLinkedList<String> lista = new DoublyLinkedList<>();

        lista.addLast("Venta A");
        lista.addLast("Venta B");
        lista.addFirst("Venta Inicio");

        System.out.println("Contenido actual: " + lista);
        System.out.println("Tamaño: " + lista.size());
        System.out.println("Elemento en posición 1: " + lista.get(1));

        lista.removeFirst();
        System.out.println("Después de removeFirst(): " + lista);

        lista.removeLast();
        System.out.println("Después de removeLast(): " + lista);
    }
}

