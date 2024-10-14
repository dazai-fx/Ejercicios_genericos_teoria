package org.iesvdm.ejercicio6;

import java.util.ArrayList;
import java.util.List;

public class ListaOrdenada<E extends Comparable<E>> {

    private List<E> elementos;

    public ListaOrdenada() {
        elementos = new ArrayList();
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    public int size() {
        return elementos.size();
    }

    public int indexOf(E o) {
        return elementos.indexOf(o);
    }

    public void add(E nuevo) {
        if (elementos.isEmpty()){
            elementos.add(nuevo);
        }else{
            // busca la posición correcta donde debe insertarse el nuevo elemento `nuevo`
            // en la lista para mantener el orden. Recorre los elementos actuales de la lista y compara
            // cada uno de ellos con el nuevo elemento `nuevo`(pasado como parametro) usando compareTo().
            // El ciclo continúa mientras:
            // 1. el contador i sea menor que el tamaño de la lista (todavía hay elementos por comparar).
            // 2. El valor del elemento de la lista sea menor que el valor de nuevo (compareTo(elemento) < 0)
            // Una vez que se encuentra un elemento que es mayor o igual a nuevo, el ciclo se detiene,
            // y i contendrá la posición donde debe insertarse nuevo.
            int i = 0;
            while (i < elementos.size() && elementos.get(i).compareTo(nuevo) < 0) {
                i++;
            }

            elementos.add(i, nuevo);

        }
    }

    public E get(int index) {
        return elementos.get(index);
    }

    public boolean remove(E o) {
        return elementos.remove(o);
    }

    public String toString() {
        return "ListaOrdenada: " + elementos.toString();
    }

    public static void main(String[] args) {
        ListaOrdenada<Integer> lista = new ListaOrdenada<>();
        lista.add(8);
        lista.add(5);
        lista.add(3);
        lista.add(24);

        System.out.println(lista);
        System.out.println("El elemento del indice 2 es: "+lista.get(2));
        System.out.println("El tamaño de la lista es: "+lista.size());
        if (lista.isEmpty()){
            System.out.println("Lista vacia");
        }else{
            System.out.println("La lista tiene elementos.");
        }

        if(lista.remove(3)){
            System.out.println("Se va a eliminar el elemento: 3");
        }

        System.out.println(lista);

    }

}
