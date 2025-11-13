package principal;

import modelos.SinglyLinkedList;

/**
 *
 * @author STEVEN AF
 */
public class PruebaListaSimple {
    public static void main(String[] args) {
        System.out.println("--- Prueba de SinglyLinkedList ---");

        SinglyLinkedList<String> lista = new SinglyLinkedList<>();

        lista.addLast("Venta1");
        lista.addFirst("Venta0");
        lista.addLast("Venta2");

        System.out.println("Contenido actual: " + lista);
        System.out.println("Tamaño: " + lista.size());
        System.out.println("Elemento en posición 1: " + lista.get(1));

        lista.removeFirst();
        System.out.println("Después de removeFirst(): " + lista);

        lista.removeLast();
        System.out.println("Después de removeLast(): " + lista);
    }
}

