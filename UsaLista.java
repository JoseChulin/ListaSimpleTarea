/**
 * Descripción:Clase de ejemplo que demuestra el uso de la lista enlazada simple implementada en ListaSimple.En este ejemplo, se crean instancias de ListaSimple y se realizan varias operaciones, como
 * inserciones, búsquedas, intercambios y manipulaciones de nodos.
 * Clase recuperada y modificada de un ejercicio academico
 * Autores:  Martínez Chulin José Alexander
 * Fecha: 23/11/23
 */ 
public class UsaLista {

    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();

        // Insertar nodos en la lista
        lista.insertaPrimerNodo("H");
        lista.insertaAntesPrimerNodo("O");
        lista.insertaAlFinal("Y");
        lista.insertaEntreNodos("A", "Y");
        lista.insertarDespuesDe("H", "L");

        // Imprimir la referencia del nodo buscado y la lista actual
        System.out.println("Referencia del nodo buscado: " + lista.buscarPorValor("A"));
        lista.imprimir();

        // Intercambiar un nodo específico
        System.out.println("Intercambio de nodos");
        lista.intercambiarNodo("L", "R");
        lista.imprimir();

        // Intercambiar dos nodos específicos
        System.out.println("Intercambio de nodos");
        lista.intercambiarNodos("A", "R");

        // Insertar un nuevo nodo antes de otro nodo específico
        lista.insertarAntesDe("A", "P");
        System.out.println("Referencia del nodo buscado: " + lista.buscarPorValor("A"));

        // Imprimir la lista utilizando el método toString()
        System.out.print(lista);
    }
}
