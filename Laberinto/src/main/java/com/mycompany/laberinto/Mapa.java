package com.mycompany.laberinto;

import static com.mycompany.laberinto.Matriz.Matriz;
import java.util.Scanner;

public class Mapa {
    public static void Mapas(){
        
        Scanner scanner = new Scanner(System.in);
   
        int opcion;
        String NombreMapa = "Predeterminado";
        
        System.out.println("Elija Un mapa: ");
        System.out.println("1 " + NombreMapa);
        opcion = scanner.nextInt();
        
        if(opcion == 1){
            Matriz(opcion);
        }
    }
}
