package org.iesvdm.ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class ColeccionGenerica <T> implements ColeccionSimpleGenerica<T> {

    private List<T> elementos;

    public ColeccionGenerica() {
        elementos = new ArrayList<T>();
    }

    @Override
    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    @Override
    public T extraer() {
        if (!estaVacia()) {
            return elementos.remove(0);
        }
        return null;
    }

    @Override
    public T primero() {
        if (!estaVacia()) {
            return elementos.get(0);
        }
        return null;
    }

    @Override
    public void aniadir(T elemento) {
        elementos.add(elemento);
    }

    @Override
    public String toString() {
        return "ColeccionGenerica:" + elementos.toString();
    }

    public static void main(String[] args) {
        ColeccionGenerica<Integer> coleccion = new ColeccionGenerica<Integer>();

        coleccion.aniadir(1);
        coleccion.aniadir(2);
        coleccion.aniadir(3);

        System.out.println(coleccion);

        if (coleccion.estaVacia()) {
            System.out.println("No hay elementos");
        }else{
            System.out.println("El primer elemento " + coleccion.primero());
        }

        System.out.println("Voy a borrar el primer elemento "+coleccion.extraer());

        System.out.println(coleccion);

    }

}
