package modelos;

/**
 *
 * @author STEVEN AF
 */
public class DoublyLinkedList<T> {

    //Nodo interno con referencias anterior y siguiente.
    private static class Node<T> {
        T value;        //Valor almacenado.
        Node<T> prev;   //Nodo anterior.
        Node<T> next;   //Nodo siguiente.

        Node(T value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private Node<T> head; //Primer nodo de la lista.
    private Node<T> tail; //Último nodo de la lista.
    private int size;     //Cantidad de elementos.

    //Constructor por defecto.
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //Agrega un elemento al inicio.
    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    //Agrega un elemento al final.
    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    //Retira y devuelve el primer elemento.
    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("La lista está vacía.");
        }
        T val = head.value;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null; //Si la lista quedó vacía.
        }
        size--;
        return val;
    }

    //Retira y devuelve el último elemento.
    public T removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("La lista está vacía.");
        }
        T val = tail.value;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null; //Si la lista quedó vacía.
        }
        size--;
        return val;
    }

    //Obtiene un elemento según su índice.
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        }
        Node<T> current;
        //Optimiza la búsqueda (por cabeza o cola).
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current.value;
    }

    //Devuelve true si está vacía.
    public boolean isEmpty() {
        return size == 0;
    }

    //Devuelve el tamaño actual.
    public int size() {
        return size;
    }

    //Elimina todos los elementos.
    public void clear() {
        head = tail = null;
        size = 0;
    }

    //Devuelve una representación en texto de la lista.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> temp = head;
        while (temp != null) {
            sb.append(temp.value);
            if (temp.next != null) sb.append(" <-> ");
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

