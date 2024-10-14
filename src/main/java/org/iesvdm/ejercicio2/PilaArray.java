package org.iesvdm.ejercicio2;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class PilaArray<E>{

    private E[] elementos;
    private int tope;

    public PilaArray(){
        this.elementos = (E[]) new Object[1];
        this.tope=0;
    }

    public PilaArray(int tamanio){
        this.elementos = (E[]) new Object[tamanio];
        this.tope=0;
    }

    public boolean estaVacia(){
        return this.tope == 0;
    }

    public E extraer(){
        if (estaVacia()){
            throw new NoSuchElementException("La pila está vacia");
        }
        return elementos[--tope];
    }

    public E primero(){
        if (estaVacia()){
            throw new NoSuchElementException("La pila está vacia");
        }
        return elementos[tope-1];
    }

    private void redimensionar() {
        elementos = Arrays.copyOf(elementos, elementos.length+1); // Copia los elementos al nuevo array con una longitud mayor al tope en 1
    }

    public void aniadir (E elemento){
        if(tope==elementos.length){
            redimensionar();
        }
        elementos[tope++] = elemento;
    }

    @Override
    public String toString() {

        String resultado = "PilaArray{Elementos=[";

        for (int i = 0; i < tope; i++) {
            resultado += elementos[i];
            if(i < tope-1){
                resultado += (", ");
            }
        }

        resultado += "]}";

        return resultado;

    }

    public static void main(String[] args) {

        PilaArray<Integer> pila = new PilaArray<>(5); // tamaño inicial de 5 que luego aumento

        System.out.println("Creo una pila de enteros:");

        if (pila.estaVacia()){
            System.out.println("Esta vacía ");
        }else{
            System.out.println("No se encuentra vacía");
        }

        System.out.println("Añado elementos");

        pila.aniadir(10);
        pila.aniadir(20);
        pila.aniadir(30);
        pila.aniadir(40);
        pila.aniadir(50);
        pila.aniadir(60);

        System.out.println(pila);

        System.out.println("Elimino el último elemento: "+pila.extraer());

        System.out.println(pila);

        System.out.println("El primer elemento de la pila es: "+pila.primero());


    }

}
