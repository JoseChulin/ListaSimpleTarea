/**
 * Descripción:Clase que implementa una lista enlazada simple. Permite la manipulación de nodos en una lista enlazada, incluyendo inserciones, eliminaciones,
 * búsquedas y operaciones de intercambio. Esta clase proporciona métodos para realizar diversas operaciones comunes en listas enlazadas.
 * Clase recuperada y modificada de un ejercicio academico
 * Autores: Martínez Chulin José Alexander
 * Fecha: 23/11/23
 */ 

public class ListaSimple {
    Node top;

    // Métodos para los casos de inserción de nodos

    // Inserta un nuevo nodo como el primer nodo de la lista
    public boolean insertaPrimerNodo(String dato) {
        if (top == null) { // La lista está vacía
            top = new Node();
            top.name = dato;
            top.next = null;
            return true;
        } else {
            return false;
        }
    }

    // Inserta un nuevo nodo antes del primer nodo existente
    public void insertaAntesPrimerNodo(String nombre) {
        Node temp;
        temp = new Node();
        temp.name = nombre;
        temp.next = this.top;
        this.top = temp;
        temp = null;
    }

    // Inserta un nuevo nodo al final de la lista
    public void insertaAlFinal(String nombre) {
        Node temp = new Node();
        temp.name = nombre;
        temp.next = null;
        Node temp2 = this.top;

        while (temp2.next != null)
            temp2 = temp2.next;

        temp2.next = temp;
        temp = null;
        temp2 = null;
    }

    // Inserta un nuevo nodo con un valor específico entre dos nodos existentes
    public boolean insertaEntreNodos(String nombre, String buscado) {
        Node temp = new Node();
        temp.name = nombre;
        Node temp2 = this.top;

        while ((temp2 != null) && temp2.name.equals(buscado) == false) {
            temp2 = temp2.next;
        }

        if (temp2 != null) { // Nodo buscado se encontró
            temp.next = temp2.next;
            temp2.next = temp;
            temp = null;
            temp2 = null;
            return true;
        } else
            return false;
    }

    // Imprime los valores de los nodos en la lista
    public void imprimir() {
        for (Node temp = this.top; temp != null; temp = temp.next) {
            System.out.print("[ " + temp.name + " ] -> ");
        }

        System.out.print("[X]\n");
    }

    // Devuelve una representación en cadena de la lista
    public String toString() {
        String cadAux = "";
        for (Node temp = this.top; temp != null; temp = temp.next) {
            cadAux += "[ " + temp.name + " ] -> ";
        }

        cadAux += "[X]\n";

        return cadAux;
    }

    // Métodos de borrado

    // Borra el primer nodo de la lista
    public void borrarPrimerNodo() {
        this.top = this.top.next;
    }

    // Borra cualquier nodo que no sea el primero
    public boolean borrarCualquierNodo(String buscado) {
        Node temp = this.top;

        while ((temp != null) && temp.name.equals(buscado) == false) {
            temp = temp.next;
        }

        if (temp != null) { // Nodo buscado se encontró
            temp.next = temp.next.next;
            temp = null;
            return true;
        } else
            return false;
    }

    // Busca un nodo por el valor de su campo clave y devuelve una referencia
    public Node buscarPorValor(String valorBuscado) {
        Node temp = this.top;

        while (temp != null && !temp.name.equals(valorBuscado)) {
            temp = temp.next;
        }

        return temp; // Devuelve null si no se encuentra el nodo
    }

    // Inserta un nuevo nodo después de un nodo con un valor específico
    public void insertarDespuesDe(String valorBuscado, String nuevoValor) {
        Node temp = buscarPorValor(valorBuscado);
        if (temp != null) { // Si se encuentra el nodo
            Node nuevoNodo = new Node();
            nuevoNodo.name = nuevoValor;
            nuevoNodo.next = temp.next;
            temp.next = nuevoNodo;
        }
    }

    // Cambia el identificador de un nodo por uno nuevo
    public boolean intercambiarNodo(String valorBuscado, String nuevoValor) {
        Node temp = this.top;

        while (temp != null && !temp.name.equals(valorBuscado)) {
            temp = temp.next;
        }

        if (temp != null) { // Si se encuentra el nodo
            temp.name = nuevoValor;
            return true;
        } else {
            return false; // No se encontró el nodo
        }
    }

    // Cambia el identificador de un nodo con otro nodo ya creado
    public void intercambiarNodos(String valorNodo1, String valorNodo2) {
        // Buscar los nodos que se van a intercambiar
        Node nodo1 = null;
        Node nodo2 = null;
        Node temp = this.top;

        while (temp != null) {
            if (temp.name.equals(valorNodo1)) {
                nodo1 = temp;
            } else if (temp.name.equals(valorNodo2)) {
                nodo2 = temp;
            }

            temp = temp.next;
        }

        // Verificar que ambos nodos fueron encontrados
        if (nodo1 != null && nodo2 != null) {
            // Intercambiar los nodos
            String tempValue = nodo1.name;
            nodo1.name = nodo2.name;
            nodo2.name = tempValue;
        }
    }

    // Inserta un nuevo nodo antes de un nodo con un valor específico
    public void insertarAntesDe(String valorNodoExistente, String nuevoValor) {
        Node nuevoNodo = new Node();
        nuevoNodo.name = nuevoValor;
        // Manejar el caso especial cuando el nodo a insertar es el primero
        if (top != null && top.name.equals(valorNodoExistente)) {
            nuevoNodo.next = top;
            top = nuevoNodo;
        } else {
            Node temp = top;
            // Buscar el nodo antes del cual se debe insertar el nuevo nodo
            while (temp != null && temp.next != null && !temp.next.name.equals(valorNodoExistente)) {
                temp = temp.next;
            }

            // Insertar el nuevo nodo antes del nodo existente
            if (temp != null && temp.next != null) {
                nuevoNodo.next = temp.next;
                temp.next = nuevoNodo;
                nuevoNodo = null;
            }
        }
    }
}