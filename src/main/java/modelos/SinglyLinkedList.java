package modelos;

/**
 *
 * @author STEVEN AF
 */
public class SinglyLinkedList<T> {

    //Nodo interno de la lista.
    private static class Node<T> {
        T value;       //Valor almacenado.
        Node<T> next;  //Referencia al siguiente nodo.

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node<T> head;  //Primer nodo de la lista.
    private int size;      //Cantidad de elementos.

    //Constructor por defecto.
    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    //Agrega un elemento al inicio de la lista.
    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        node.next = head;
        head = node;
        size++;
    }

    //Agrega un elemento al final de la lista.
    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = node;
        } else {
            Node<T> temp = head;
            while (temp.next != null) { //Recorre hasta el último nodo.
                temp = temp.next;
            }
            temp.next = node;
        }
        size++;
    }

    //Retira y devuelve el primer elemento de la lista.
    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("La lista está vacía.");
        }
        T val = head.value;
        head = head.next;
        size--;
        return val;
    }

    //Retira y devuelve el último elemento de la lista.
    public T removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("La lista está vacía.");
        }
        if (head.next == null) { //Solo hay un elemento.
            T val = head.value;
            head = null;
            size--;
            return val;
        }
        Node<T> prev = null;
        Node<T> curr = head;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        size--;
        return curr.value;
    }

    //Obtiene un elemento según su posición (0..n-1).
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    //Devuelve true si la lista está vacía.
    public boolean isEmpty() {
        return size == 0;
    }

    //Devuelve el tamaño actual de la lista.
    public int size() {
        return size;
    }

    //Elimina todos los elementos de la lista.
    public void clear() {
        head = null;
        size = 0;
    }

    //Devuelve una representación en texto de la lista.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> temp = head;
        while (temp != null) {
            sb.append(temp.value);
            if (temp.next != null) sb.append(" -> ");
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

