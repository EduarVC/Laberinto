package com.mycompany.laberinto;

import static com.mycompany.laberinto.ProcesoJuego.ProcesoJuego;

public class Matriz {

    public static void Matriz(int Turno) {

        int posicionXJugador = 0;
        int posicionYJugador = 0;
        int posicionXBoot = 0;
        int posicionYBoot = 0;

        String[][] Matriz = {
            {" #", " #", " #", " #", " #", " #", " #", " #", " S", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #"},
            {" S", " O", " O", " O", " O", " O", " O", " #", " O", " O", " O", " O", " O", " O", " O", " O", " O", " #", " O", " O", " O", " O", " O", " O", " O", " O", " #", " O", " O", " S"},
            {" #", " #", " #", " #", " #", " #", " O", " O", " #", " #", " #", " O", " #", " #", " #", " O", " #", " O", " O", " #", " #", " #", " #", " #", " #", " O", " O", " #", " O", " #"},
            {" #", " O", " O", " G", " O", " #", " O", " #", " G", " G", " #", " O", " #", " G", " #", " O", " #", " G", " #", " O", " #", " O", " O", " O", " #", " #", " O", " O", " O", " #"},
            {" #", " O", " #", " #", " O", " #", " O", " O", " O", " O", " #", " G", " #", " O", " #", " O", " #", " #", " O", " O", " #", " O", " #", " O", " O", " #", " O", " #", " O", " #"},
            {" #", " G", " #", " O", " O", " #", " O", " #", " #", " #", " #", " #", " #", " O", " #", " O", " O", " O", " #", " O", " #", " O", " #", " #", " #", " #", " O", " #", " O", " #"},
            {" #", " O", " #", " #", " O", " O", " O", " O", " O", " O", " #", " O", " #", " O", " O", " O", " O", " O", " O", " O", " O", " O", " #", " O", " O", " O", " O", " #", " #", " #"},
            {" #", " #", " O", " O", " O", " #", " O", " #", " O", " #", " O", " O", " #", " #", " O", " #", " #", " O", " #", " #", " #", " #", " #", " O", " #", " O", " #", " #", " G", " #"},
            {" #", " O", " O", " #", " O", " #", " O", " O", " O", " #", " O", " #", " O", " #", " O", " O", " #", " O", " #", " O", " O", " O", " O", " O", " #", " O", " O", " #", " G", " #"},
            {" #", " O", " #", " #", " O", " #", " #", " #", " O", " #", " O", " #", " O", " #", " #", " O", " #", " O", " #", " #", " #", " O", " #", " #", " #", " #", " G", " #", " O", " #"},
            {" #", " O", " O", " O", " O", " #", " O", " #", " O", " #", " O", " #", " O", " #", " O", " O", " #", " O", " O", " G", " #", " O", " O", " #", " O", " #", " O", " #", " O", " #"},
            {" #", " #", " #", " G", " #", " O", " O", " O", " O", " #", " O", " #", " O", " #", " #", " O", " #", " #", " #", " #", " #", " O", " #", " O", " #", " #", " O", " #", " O", " #"},
            {" #", " J", " O", " #", " O", " O", " #", " #", " #", " O", " O", " #", " O", " #", " O", " O", " O", " O", " O", " O", " O", " O", " O", " O", " O", " #", " O", " #", " O", " #"},
            {" #", " #", " O", " #", " #", " O", " #", " O", " O", " #", " O", " #", " O", " O", " O", " #", " O", " #", " #", " O", " #", " O", " O", " #", " O", " #", " O", " #", " O", " #"},
            {" #", " O", " O", " #", " O", " O", " #", " O", " #", " #", " O", " #", " G", " #", " B", " #", " #", " O", " O", " #", " O", " O", " #", " O", " O", " #", " O", " #", " O", " #"},
            {" #", " #", " O", " #", " #", " O", " O", " O", " G", " #", " O", " #", " #", " #", " O", " #", " O", " O", " O", " O", " O", " #", " O", " O", " #", " #", " O", " #", " O", " #"},
            {" #", " O", " O", " #", " O", " O", " #", " O", " #", " #", " O", " O", " #", " O", " O", " #", " O", " #", " #", " #", " #", " #", " O", " #", " O", " #", " G", " #", " O", " #"},
            {" #", " #", " O", " O", " O", " #", " #", " #", " O", " #", " O", " #", " O", " #", " O", " O", " O", " #", " G", " O", " O", " O", " O", " O", " O", " O", " #", " #", " O", " #"},
            {" #", " G", " #", " O", " #", " O", " O", " O", " O", " #", " O", " O", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " O", " O", " O", " O", " #"},
            {" #", " G", " #", " O", " O", " O", " #", " #", " O", " O", " O", " O", " O", " G", " O", " O", " O", " G", " O", " O", " O", " G", " O", " O", " #", " #", " O", " #", " O", " #"},
            {" #", " O", " #", " #", " #", " #", " #", " O", " O", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " O", " O", " #", " O", " #", " #", " #"},
            {" #", " O", " #", " O", " O", " O", " #", " O", " #", " O", " O", " O", " O", " O", " O", " O", " O", " O", " O", " O", " O", " O", " O", " #", " O", " #", " O", " O", " O", " S"},
            {" #", " O", " O", " O", " #", " O", " #", " O", " O", " #", " O", " #", " #", " #", " #", " #", " #", " O", " #", " #", " #", " O", " O", " O", " O", " #", " O", " #", " #", " #"},
            {" #", " #", " #", " #", " #", " O", " #", " O", " #", " O", " O", " #", " G", " O", " O", " O", " #", " O", " O", " O", " #", " O", " #", " #", " #", " #", " O", " #", " O", " #"},
            {" #", " O", " #", " O", " O", " O", " #", " O", " G", " #", " O", " #", " #", " #", " #", " O", " #", " #", " #", " O", " #", " O", " O", " O", " O", " #", " O", " O", " O", " #"},
            {" #", " O", " #", " #", " #", " O", " #", " #", " #", " #", " O", " #", " O", " O", " O", " O", " #", " G", " #", " O", " #", " #", " #", " O", " #", " G", " #", " #", " O", " #"},
            {" #", " O", " #", " O", " O", " O", " O", " O", " O", " O", " O", " O", " O", " #", " O", " O", " #", " O", " #", " O", " O", " O", " O", " O", " #", " O", " #", " O", " O", " #"},
            {" #", " O", " #", " #", " #", " #", " #", " #", " #", " #", " #", " O", " #", " O", " #", " #", " #", " O", " #", " O", " #", " #", " #", " #", " #", " O", " O", " O", " #", " #"},
            {" #", " O", " O", " O", " O", " O", " G", " #", " O", " O", " O", " O", " #", " O", " O", " O", " O", " O", " O", " O", " O", " O", " O", " O", " O", " O", " #", " O", " G", " #"},
            {" #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " S", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #", " #"}};

        if (Turno == 1) {
            //System.out.println("\nPosición actual Jugador");
            for (int x = 0; x < Matriz.length; x++) {
                for (int y = 0; y < Matriz[x].length; y++) {
                    // System.out.print(Matriz[x][y]);
                    if (" J".equals(Matriz[x][y])) {
                        posicionXJugador = x;
                        posicionYJugador = y;

                    }
                    if (" B".equals(Matriz[x][y])) {
                        posicionXBoot = x;
                        posicionYBoot = y;
                    }
                }
            }
            ProcesoJuego(Matriz, posicionXJugador, posicionYJugador, posicionXBoot, posicionYBoot);
        } // System.out.println(posicionXJugador);
        //System.out.println(posicionYJugador);
        //System.out.println(posicionXBoot);
        //System.out.println(posicionYBoot);
        else if (Turno == 2) {
            for (int x = 0; x < Matriz.length; x++) {
                for (int y = 0; y < Matriz[x].length; y++) {
                    System.out.print(Matriz[x][y]);
                }
                System.out.println();
            }
        } 

    }

    public static void MatrizPequeña(String[][] Matriz, int posicionXJugador, int posicionYJugador) {

        if (posicionXJugador == 1 && posicionYJugador != 0 && posicionYJugador != 1 && posicionYJugador != 28 && posicionYJugador != 29) {
            for (int i = posicionXJugador - 1; i < posicionXJugador + 3; i++) {
                for (int j = posicionYJugador - 2; j < posicionYJugador + 3; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }

        } else if (posicionXJugador == 28 && posicionYJugador != 0 && posicionYJugador != 1 && posicionYJugador != 28 && posicionYJugador != 29) {
            for (int i = posicionXJugador - 2; i < posicionXJugador + 2; i++) {
                for (int j = posicionYJugador - 2; j < posicionYJugador + 3; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }

        } else if (posicionYJugador == 1 && posicionXJugador != 0 && posicionXJugador != 1 && posicionXJugador != 28 && posicionXJugador != 29) {
            for (int i = posicionXJugador - 2; i < posicionXJugador + 3; i++) {
                for (int j = posicionYJugador - 1; j < posicionYJugador + 3; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }

        } else if (posicionYJugador == 28 && posicionXJugador != 0 && posicionXJugador != 1 && posicionXJugador != 28 && posicionXJugador != 29) {
            for (int i = posicionXJugador - 2; i < posicionXJugador + 3; i++) {
                for (int j = posicionYJugador - 2; j < posicionYJugador + 2; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }

        } else if (posicionXJugador == 1 && posicionYJugador == 1) {
            for (int i = posicionXJugador - 1; i < posicionXJugador + 3; i++) {
                for (int j = posicionYJugador - 1; j < posicionYJugador + 3; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }
        } else if (posicionXJugador == 28 && posicionYJugador == 1) {
            for (int i = posicionXJugador - 2; i < posicionXJugador + 2; i++) {
                for (int j = posicionYJugador - 1; j < posicionYJugador + 3; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }
        } else if (posicionYJugador == 28 && posicionXJugador == 1) {
            for (int i = posicionXJugador - 1; i < posicionXJugador + 3; i++) {
                for (int j = posicionYJugador - 2; j < posicionYJugador + 2; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }
        } else if (posicionYJugador == 28 && posicionXJugador == 28) {
            for (int i = posicionXJugador - 2; i < posicionXJugador + 2; i++) {
                for (int j = posicionYJugador - 2; j < posicionYJugador + 2; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }
        } else if (posicionXJugador == 0 && posicionYJugador != 0 && posicionYJugador != 1 && posicionYJugador != 28 && posicionYJugador != 29) {
            for (int i = posicionXJugador; i < posicionXJugador + 3; i++) {
                for (int j = posicionYJugador - 2; j < posicionYJugador + 3; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }

        } else if (posicionXJugador == 29 && posicionYJugador != 0 && posicionYJugador != 1 && posicionYJugador != 28 && posicionYJugador != 29) {
            for (int i = posicionXJugador - 2; i < posicionXJugador + 1; i++) {
                for (int j = posicionYJugador - 2; j < posicionYJugador + 3; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }

        } else if (posicionYJugador == 0 && posicionXJugador != 0 && posicionXJugador != 1 && posicionXJugador != 28 && posicionXJugador != 29) {
            for (int i = posicionXJugador - 2; i < posicionXJugador + 3; i++) {
                for (int j = posicionYJugador; j < posicionYJugador + 3; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }

        } else if (posicionYJugador == 29 && posicionXJugador != 0 && posicionXJugador != 1 && posicionXJugador != 28 && posicionXJugador != 29) {
            for (int i = posicionXJugador - 2; i < posicionXJugador + 3; i++) {
                for (int j = posicionYJugador - 2; j < posicionYJugador + 1; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }

        } else if (posicionXJugador == 0 && posicionYJugador == 0) {
            for (int i = posicionXJugador; i < posicionXJugador + 3; i++) {
                for (int j = posicionYJugador; j < posicionYJugador + 3; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }
        } else if (posicionXJugador == 29 && posicionYJugador == 0) {
            for (int i = posicionXJugador - 2; i < posicionXJugador + 1; i++) {
                for (int j = posicionYJugador; j < posicionYJugador + 3; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }
        } else if (posicionYJugador == 29 && posicionXJugador == 0) {
            for (int i = posicionXJugador; i < posicionXJugador + 3; i++) {
                for (int j = posicionYJugador - 2; j < posicionYJugador + 1; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }
        } else if (posicionYJugador == 29 && posicionXJugador == 29) {
            for (int i = posicionXJugador - 2; i < posicionXJugador + 1; i++) {
                for (int j = posicionYJugador - 2; j < posicionYJugador + 1; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }
        } else if (posicionXJugador == 0 && posicionYJugador == 1) {
            for (int i = posicionXJugador; i < posicionXJugador + 3; i++) {
                for (int j = posicionYJugador - 1; j < posicionYJugador + 3; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }
        } else if (posicionXJugador == 0 && posicionYJugador == 28) {
            for (int i = posicionXJugador; i < posicionXJugador + 3; i++) {
                for (int j = posicionYJugador - 2; j < posicionYJugador + 2; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }
        } else if (posicionXJugador == 29 && posicionYJugador == 1) {
            for (int i = posicionXJugador - 2; i < posicionXJugador + 1; i++) {
                for (int j = posicionYJugador - 1; j < posicionYJugador + 3; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }
        } else if (posicionXJugador == 29 && posicionYJugador == 28) {
            for (int i = posicionXJugador - 2; i < posicionXJugador + 1; i++) {
                for (int j = posicionYJugador - 2; j < posicionYJugador + 2; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }
        } else if (posicionYJugador == 0 && posicionXJugador == 1) {
            for (int i = posicionXJugador - 1; i < posicionXJugador + 3; i++) {
                for (int j = posicionYJugador; j < posicionYJugador + 3; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }
        } else if (posicionYJugador == 0 && posicionXJugador == 28) {
            for (int i = posicionXJugador - 2; i < posicionXJugador + 2; i++) {
                for (int j = posicionYJugador; j < posicionYJugador + 3; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }
        } else if (posicionYJugador == 29 && posicionXJugador == 1) {
            for (int i = posicionXJugador - 1; i < posicionXJugador + 3; i++) {
                for (int j = posicionYJugador - 2; j < posicionYJugador + 1; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }
        } else if (posicionYJugador == 29 && posicionXJugador == 28) {
            for (int i = posicionXJugador - 2; i < posicionXJugador + 2; i++) {
                for (int j = posicionYJugador - 2; j < posicionYJugador + 1; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }
        } else {

            //Muestra la posicion del jugaro si no esta cerca de una orilla
            for (int i = posicionXJugador - 2; i < posicionXJugador + 3; i++) {
                for (int j = posicionYJugador - 2; j < posicionYJugador + 3; j++) {
                    System.out.print(Matriz[i][j]);
                }
                System.out.println("");
            }
        }
    }

  /*  public static int[] OroRequerido(int CantidadSalidas, int posX, int posY) {
       
        int[] CasillasSalida = new int[CantidadSalidas];

        return CasillasSalida;
    }*/

}
