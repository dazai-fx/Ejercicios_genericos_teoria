package org.iesvdm.ejercicio3;

import java.util.Random;

public class MatrizGenerica<E>{

    private E[][] matriz;
    private int filas;
    private int columnas;

    public MatrizGenerica(int filas, int columnas){
        this.filas = filas;
        this.columnas = columnas;
        matriz = (E[][]) new Object[filas][columnas]; // Usamos un casting para crear un arreglo genérico
    }

    public void set(int fila, int columna, E valor){

        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites de la matriz.");
        }

        matriz[fila][columna] = valor;

    }

    public E get(int fila, int columna){
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites de la matriz.");
        }
        return matriz[fila][columna];
    }

    public int columnas(){
        return columnas;
    }

    public int filas(){
        return filas;
    }

    @Override
    public String toString() {
        String result = "MatrizGenerica{matriz=[\n";

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                result += matriz[i][j] + ",";
            }
            if (i != filas - 1) {
                result += "\n";
            }else{
                result += "]";
            }
        }
        result+="}";
        return result;

    }

    public static void main(String[] args) {

        MatrizGenerica<Integer> miMatriz = new MatrizGenerica<>(4,4);
        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                miMatriz.set(i,j, random.nextInt(100));
            }
        }

        System.out.println(miMatriz);

        System.out.println(miMatriz.get(0,2));

        System.out.println("El número de columnas es: "+miMatriz.columnas());

        System.out.println("El número de filas es: "+miMatriz.filas());



    }

}
