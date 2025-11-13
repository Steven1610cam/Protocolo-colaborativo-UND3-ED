package principal;

import java.util.LinkedList;
import modelos.SinglyLinkedList;
import modelos.DoublyLinkedList;

/**
 *
 * @author STEVEN AF
 */
//Clase para comparar rendimiento entre listas manuales y nativas.
public class ComparacionListas {
    public static void main(String[] args) {

        int[] tamanios = {1000, 10000, 50000}; //Cantidades de prueba.

        for (int n : tamanios) {
            System.out.println("\n=== Comparación con n = " + n + " ===");

            //Prueba con SinglyLinkedList.
            long inicioSingly = System.currentTimeMillis();
            SinglyLinkedList<Integer> listaSimple = new SinglyLinkedList<>();
            for (int i = 0; i < n; i++) listaSimple.addLast(i);
            while (!listaSimple.isEmpty()) listaSimple.removeFirst();
            long finSingly = System.currentTimeMillis();
            System.out.println("SinglyLinkedList manual: " + (finSingly - inicioSingly) + " ms");

            //Prueba con DoublyLinkedList.
            long inicioDoubly = System.currentTimeMillis();
            DoublyLinkedList<Integer> listaDoble = new DoublyLinkedList<>();
            for (int i = 0; i < n; i++) listaDoble.addLast(i);
            while (!listaDoble.isEmpty()) listaDoble.removeFirst();
            long finDoubly = System.currentTimeMillis();
            System.out.println("DoublyLinkedList manual: " + (finDoubly - inicioDoubly) + " ms");

            //Prueba con LinkedList nativa.
            long inicioNativa = System.currentTimeMillis();
            LinkedList<Integer> listaNativa = new LinkedList<>();
            for (int i = 0; i < n; i++) listaNativa.addLast(i);
            while (!listaNativa.isEmpty()) listaNativa.removeFirst();
            long finNativa = System.currentTimeMillis();
            System.out.println("LinkedList nativa: " + (finNativa - inicioNativa) + " ms");
        }
    }
}