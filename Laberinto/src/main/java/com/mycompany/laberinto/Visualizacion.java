package com.mycompany.laberinto;

import static com.mycompany.laberinto.Matriz.Matriz;
import static com.mycompany.laberinto.MenuPrincipal.MenuPrincipal;
import java.util.Scanner;

public class Visualizacion {

    public static void Visualizacion() {
        Scanner scanner = new Scanner(System.in);

        int opcion;
        int Opcion;
        int Turno = 2;
        String NombreMapa = "Predeterminado";

        System.out.println("\nElija una opcion: \n");
        System.out.println("1. Visualizar mapa");
        System.out.println("2. Regresar al menu");
        Opcion = scanner.nextInt();
        
        if(Opcion == 1){
            System.out.println("\nQue mapa deseas previsualizar: \n");

        System.out.println("1. " + NombreMapa);
        opcion = scanner.nextInt();

        if (opcion == 1) {
            Matriz(Turno);
        }
        Visualizacion();
        }else{
            MenuPrincipal();
        }
    }
}
