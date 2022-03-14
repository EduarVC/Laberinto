package com.mycompany.laberinto;
import static com.mycompany.laberinto.CrearMapa.CrearMapa;
import static com.mycompany.laberinto.Juego.Juego;
import static com.mycompany.laberinto.Reportes.Reportes;
import static com.mycompany.laberinto.Visualizacion.Visualizacion;
import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        MenuPrincipal();
    }

    public static void MenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("\n   Menú Principal   \n");
        System.out.println("Elija una de las siguientes opciones: \n");
        System.out.println("1. Jugar");
        System.out.println("2. Crear Mapa");
        System.out.println("3. Reportes");
        System.out.println("4. Visualizar Mapa");
        System.out.println("5. Salir");
        opcion = scanner.nextInt();

        if (opcion == 1) {
            Juego();
            MenuPrincipal();
        } else if (opcion == 2) {
            CrearMapa();
            MenuPrincipal();
        } else if (opcion == 3) {
            Reportes();
            MenuPrincipal();
        } else if (opcion == 4) {
            Visualizacion();
            MenuPrincipal();
        } else if (opcion < 1 || opcion > 5) {
            System.out.println("\nOpcion Invalida");
            MenuPrincipal();
        }else if(opcion == 5){
            System.exit(0);
        } 
        else {
            System.out.println("\nFin del Juego");
        }

    }

    


}
