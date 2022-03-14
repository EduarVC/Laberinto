package com.mycompany.laberinto;

import java.util.Scanner;

public class CrearMapa {

    static Scanner scanner = new Scanner(System.in);

    public static String [][] CrearMapa() {
        int tamañoFila;
        int tamañoColumna;

        System.out.println("Ingrese el tamaño del mapa: ");
        System.out.println("Filas: ");
        tamañoFila = scanner.nextInt();
        System.out.println("Columnas: ");
        tamañoColumna = scanner.nextInt();

        String[][] mapa = new String[tamañoFila][tamañoColumna];
        System.out.println("Caracteres admitidos: ");
        System.out.println("Pared: #");
        System.out.println("Oro: G");
        System.out.println("Boot: B");
        System.out.println("Salida: S");
        System.out.println("Espacios vacios: O");

        System.out.println("\nIngrese los valores del mapa:");

        for (int i = 0; i < tamañoFila; i++) {
            for (int j = 0; j < tamañoColumna; j++) {
                System.out.println("\nPosicion " + "Fila: " + (i + 1) + " Columna: " + (j + 1));
                mapa[i][j] = scanner.next();
               for (int x = 0; x < i+1; x++) {
                    for (int y = 0; y < j+1; y++) {
                        
                        System.out.print(mapa[x][y]);
                        
                    }
                    System.out.println();
                }
            }
        }
        
        
        return mapa;
    }
    public static String [][] ImprimirMapa(){
       
        String [] [] mapa;
        
        mapa = CrearMapa();
        
        for(int i = 0; i < mapa.length; i++){
            for (int j = 0; j < mapa[i].length; j++) {
                System.out.print(mapa[i][j]);
            }
            System.out.println("");
        }
        return mapa;
    }
}

