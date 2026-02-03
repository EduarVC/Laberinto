package com.mycompany.laberinto;

//import static com.mycompany.laberinto.Matriz.Matriz;

import static com.mycompany.laberinto.MenuPrincipal.MenuPrincipal;
import static com.mycompany.laberinto.Mapa.Mapas;
import java.util.Scanner;

public class Juego {

    public static void Juego() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("\nElija una opcion: ");
        System.out.println("1. Elegir mapa");
        System.out.println("2. Regresar al menú principal");
        opcion = scanner.nextInt();

        if (opcion == 1) {
            Mapas();
        } else if (opcion == 2) {
            MenuPrincipal();
        } else {
            System.out.println("Opcion invalida");
            Juego();
        }
    }
    //public static void Mapas(){
        
       // Scanner scanner = new Scanner(System.in);
   
        //int opcion;
        //String NombreMapa = "Predeterminado";
        
        //System.out.println("Elija Un mapa: ");
       // System.out.println("1 " + NombreMapa);
       // opcion = scanner.nextInt();
        
        //if(opcion == 1){
          //  Matriz(opcion);
       // }
    //}

}
