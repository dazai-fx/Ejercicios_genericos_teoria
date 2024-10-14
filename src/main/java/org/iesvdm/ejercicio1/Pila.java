package org.iesvdm.ejercicio1;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Pila<E> {

    private LinkedList<E> listaEnlazada;

    public Pila() {
        this.listaEnlazada = new LinkedList<>();
    }

    public boolean estaVacia() {
        return listaEnlazada.isEmpty();
    }

    public E extraer(){
        if(estaVacia()){
            throw new NoSuchElementException("La pila esta vacia");
        }
        return listaEnlazada.removeFirst();
    }

    public E primero(){
        if(estaVacia()){
            throw new NoSuchElementException("La pila esta vacia");
        }
        return listaEnlazada.getFirst();
    }

    public void aniadir(E elemento){
        listaEnlazada.addFirst(elemento);
    }

    @Override
    public String toString() {
        return "Pila{" +
                "Elementos=" + listaEnlazada +
                '}';
    }

    public static void main(String[] args) {

        System.out.println("Creo una pila de enteros");

        Pila<Integer> pilaEnteros = new Pila<>();

        if(pilaEnteros.estaVacia()){
            System.out.println("La pila esta vacia");
        }else{
            System.out.println("La pila no esta vacia");
        }

        System.out.println("Añado elementos.");

        pilaEnteros.aniadir(1);
        pilaEnteros.aniadir(2);
        pilaEnteros.aniadir(3);
        pilaEnteros.aniadir(4);

        System.out.println(pilaEnteros);

        System.out.println("Voy a eliminar el primer elemento de la pila que es: "+pilaEnteros.extraer());
        System.out.println(pilaEnteros);

        System.out.println("El primer elemento de la pila es: "+pilaEnteros.primero());

        System.out.println("Pasamos a crear una pila de cadenas");

        Pila<String> pilaStrings = new Pila<>();

        pilaStrings.aniadir("primero");
        pilaStrings.aniadir("segundo");
        pilaStrings.aniadir("tercero");
        pilaStrings.aniadir("cuarto");

        // en este caso debería de indicar que no esta vacía
        if(pilaStrings.estaVacia()){
            System.out.println("La pila esta vacia");
        }else{
            System.out.println("La pila no esta vacia");
        }

        System.out.println(pilaStrings);

        System.out.println("Voy a eliminar el primer elemento de la pila que es: "+pilaStrings.extraer());
        System.out.println(pilaStrings);

        System.out.println("El primer elemento de la pila es: "+pilaStrings.primero());

    }

}
