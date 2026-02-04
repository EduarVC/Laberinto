package com.mycompany.laberinto;

import static com.mycompany.laberinto.Matriz.Matriz;
import static com.mycompany.laberinto.MetodosBoot.TeAtraparon;
import static com.mycompany.laberinto.MetodosBoot.MovimientoE;
import static com.mycompany.laberinto.MetodosBoot.MovimientoO;
import static com.mycompany.laberinto.MetodosBoot.MovimientoN;
import static com.mycompany.laberinto.MetodosBoot.MovimientoS;
import java.util.Scanner;

public class ProcesoJuego {

    



    public static void ProcesoJuego(String[][] matriz, int PosicionXJugador, int PosicionYJugador, int PosicionXBoot, int PosicionYBoot) {

        Scanner scanner = new Scanner(System.in);
        String comando;
        boolean VerSalida = false;
        int ConteoError = 0;
        int ConteoMovimientos = 0;
        boolean verAtrapaJugador = false;
        String CasillaActual = " O";
        String casillaActualJugador = " O";
        int turno = 0;
        int conteoMovimientoboot = 0;
        int conteoJVistaBoot = 0;
        int catidadOro = 0;
        int OroObtendo = 0;
        int OroRequerido = 0;

        //int movimientoX;
        //int movimientoY; 
        System.out.println("Comandos Admitidos:");
        System.out.println("ORO_REQUERIDO\nORO\nMOVER<DIRECCION>\nLEVANTAR\nMIRAR\nSALIR\n\nLa direcion puese ser: \nN (Arriba)\nS (Abajo)\nE (Derecha)\nO (Izquierda)\n");

        while (verAtrapaJugador == false) {

            if (turno == 1) {

                if (PosicionXBoot == 1 || PosicionXBoot == 28 || PosicionYBoot == 1 || PosicionYJugador == 28) {
                    // Matriz.MatrizPequeña(matriz, PosicionXBoot, PosicionYBoot);

                    if (" J".equals(matriz[PosicionXBoot - 1][PosicionYBoot - 1]) || " J".equals(matriz[PosicionXBoot][PosicionYBoot - 1]) || " J".equals(matriz[PosicionXBoot + 1][PosicionYBoot - 1])) {
                        if (!" #".equals(matriz[PosicionXBoot][PosicionYBoot - 1]) && !" S".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                            if (" G".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                //System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                TeAtraparon();
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot][PosicionYBoot - 1] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            MovimientoO();
                            PosicionYBoot--;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        } else if (!" #".equals(matriz[PosicionXBoot - 1][PosicionYBoot]) && !" S".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                            if (" G".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                TeAtraparon();
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot - 1][PosicionYBoot] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            MovimientoN();
                            PosicionXBoot--;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        } else if (!" #".equals(matriz[PosicionXBoot][PosicionYBoot + 1]) && !" S".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                            if (" G".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                TeAtraparon();
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot][PosicionYBoot + 1] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            MovimientoE();
                            PosicionYBoot++;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        } else if (!" #".equals(matriz[PosicionXBoot + 1][PosicionYBoot]) && !" S".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                            if (" G".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                TeAtraparon();
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot + 1][PosicionYBoot] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            MovimientoS();
                            PosicionXBoot++;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        }
                    } else if (" J".equals(matriz[PosicionXBoot - 1][PosicionYBoot + 1]) || " J".equals(matriz[PosicionXBoot][PosicionYBoot + 1]) || " J".equals(matriz[PosicionXBoot + 1][PosicionYBoot + 1])) {
                        if (!" #".equals(matriz[PosicionXBoot][PosicionYBoot + 1]) && !" S".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                            if (" G".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                TeAtraparon();
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot][PosicionYBoot + 1] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            MovimientoE();
                            PosicionYBoot++;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        } else if (!" #".equals(matriz[PosicionXBoot - 1][PosicionYBoot]) && !" S".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                            if (" G".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                TeAtraparon();
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot - 1][PosicionYBoot] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            MovimientoN();
                            PosicionXBoot--;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        } else if (!" #".equals(matriz[PosicionXBoot][PosicionYBoot - 1]) && !" S".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                            if (" G".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                TeAtraparon();
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot][PosicionYBoot - 1] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            MovimientoO();
                            PosicionYBoot--;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        } else if (!" #".equals(matriz[PosicionXBoot + 1][PosicionYBoot]) && !" S".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                            if (" G".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                TeAtraparon();
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot + 1][PosicionYBoot] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            MovimientoS();
                            PosicionXBoot++;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        }
                    } else if (" J".equals(matriz[PosicionXBoot - 1][PosicionYBoot - 1]) || " J".equals(matriz[PosicionXBoot - 1][PosicionYBoot]) || " J".equals(matriz[PosicionXBoot - 1][PosicionYBoot + 1])) {
                        if (!" #".equals(matriz[PosicionXBoot - 1][PosicionYBoot]) && !" S".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                            if (" G".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                TeAtraparon();
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot - 1][PosicionYBoot] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            MovimientoN();
                            PosicionXBoot--;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        } else if (!" #".equals(matriz[PosicionXBoot][PosicionYBoot - 1]) && !" S".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                            if (" G".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                TeAtraparon();
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot][PosicionYBoot - 1] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            MovimientoO();
                            PosicionYBoot--;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        } else if (!" #".equals(matriz[PosicionXBoot][PosicionYBoot + 1]) && !" S".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                            if (" G".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                TeAtraparon();
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot][PosicionYBoot + 1] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            MovimientoE();
                            PosicionYBoot++;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        } else if (!" #".equals(matriz[PosicionXBoot + 1][PosicionYBoot]) && !" S".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                            if (" G".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                TeAtraparon();
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot + 1][PosicionYBoot] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            MovimientoS();
                            PosicionXBoot++;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        }

                    } else if (" J".equals(matriz[PosicionXBoot + 1][PosicionYBoot - 1]) || " J".equals(matriz[PosicionXBoot + 1][PosicionYBoot]) || " J".equals(matriz[PosicionXBoot + 1][PosicionYBoot + 1])) {
                        if (!" #".equals(matriz[PosicionXBoot + 1][PosicionYBoot]) && !" S".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                            if (" G".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                TeAtraparon();
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot + 1][PosicionYBoot] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            MovimientoS();
                            PosicionXBoot++;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        } else if (!" #".equals(matriz[PosicionXBoot][PosicionYBoot - 1]) && !" S".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                            if (" G".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                TeAtraparon();                                                            //Hata aca llegue hoy
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot][PosicionYBoot - 1] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            System.out.println("\nEl Boot se a movido una casilla hacia el Oeste");
                            PosicionYBoot--;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        } else if (!" #".equals(matriz[PosicionXBoot][PosicionYBoot + 1]) && !" S".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                            if (" G".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot][PosicionYBoot + 1] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            System.out.println("\nEl Boot se a movido una casilla hacia el Este");
                            PosicionYBoot++;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        } else if (!" #".equals(matriz[PosicionXBoot - 1][PosicionYBoot]) && !" S".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                            if (" G".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot - 1][PosicionYBoot] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            System.out.println("\nEl Boot se a movido una casilla hacia el Norte");
                            PosicionXBoot--;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        }

                    } else {
                        if (!" #".equals(matriz[PosicionXBoot - 1][PosicionYBoot]) && !" S".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                            if (" G".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot - 1][PosicionYBoot] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            System.out.println("\nEl Boot se a movido una casilla hacia el Norte");
                            PosicionXBoot--;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        } else if (!" #".equals(matriz[PosicionXBoot][PosicionYBoot + 1]) && !" S".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                            if (" G".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot][PosicionYBoot + 1] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            System.out.println("\nEl Boot se a movido una casilla hacia el Este");
                            PosicionYBoot++;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        } else if (!" #".equals(matriz[PosicionXBoot][PosicionYBoot - 1]) && !" S".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                            if (" G".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot][PosicionYBoot - 1] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            System.out.println("\nEl Boot se a movido una casilla hacia el Oeste");
                            PosicionYBoot--;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        } else if (!" #".equals(matriz[PosicionXBoot + 1][PosicionYBoot]) && !" S".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                            if (" G".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot + 1][PosicionYBoot] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            System.out.println("\nEl Boot se a movido una casilla hacia el Sur");
                            PosicionXBoot++;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        }
                    }
                } else {
                    //Matriz.MatrizPequeña(matriz, PosicionXBoot, PosicionYBoot);

                    if (" J".equals(matriz[PosicionXBoot - 2][PosicionYBoot - 2]) || " J".equals(matriz[PosicionXBoot - 1][PosicionYBoot - 2]) || " J".equals(matriz[PosicionXBoot][PosicionYBoot - 2]) || " J".equals(matriz[PosicionXBoot + 1][PosicionYBoot - 2]) || " J".equals(matriz[PosicionXBoot + 2][PosicionYBoot - 2]) || " J".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                        if (!" #".equals(matriz[PosicionXBoot][PosicionYBoot - 1]) && !" S".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                            if (" G".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot][PosicionYBoot - 1] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            System.out.println("\nEl Boot se a movido una casilla hacia el Oeste");
                            PosicionYBoot--;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        } else if (!" #".equals(matriz[PosicionXBoot - 1][PosicionYBoot]) && !" S".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                            if (" G".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot - 1][PosicionYBoot] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            System.out.println("\nEl Boot se a movido una casilla hacia el Norte");
                            PosicionXBoot--;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        } else if (!" #".equals(matriz[PosicionXBoot][PosicionYBoot + 1]) && !" S".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                            if (" G".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot][PosicionYBoot + 1] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            System.out.println("\nEl Boot se a movido una casilla hacia el Este");
                            PosicionYBoot++;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        } else if (!" #".equals(matriz[PosicionXBoot + 1][PosicionYBoot]) && !" S".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                            if (" G".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot + 1][PosicionYBoot] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            System.out.println("\nEl Boot se a movido una casilla hacia el Sur");
                            PosicionXBoot++;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        } else if (" J".equals(matriz[PosicionXBoot - 2][PosicionYBoot + 2]) || " J".equals(matriz[PosicionXBoot - 1][PosicionYBoot + 2]) || " J".equals(matriz[PosicionXBoot][PosicionYBoot + 2]) || " J".equals(matriz[PosicionXBoot + 1][PosicionYBoot + 2]) || " J".equals(matriz[PosicionXBoot + 2][PosicionYBoot + 2]) || " J".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                            if (!" #".equals(matriz[PosicionXBoot][PosicionYBoot + 1]) && !" S".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                if (" G".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                    CasillaActual = " G";
                                } else if (" O".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                    CasillaActual = " O";
                                } else if (" J".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                    System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                    verAtrapaJugador = true;
                                }
                                matriz[PosicionXBoot][PosicionYBoot + 1] = " B";
                                matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                                System.out.println("\nEl Boot se a movido una casilla hacia el Este");
                                PosicionYBoot++;
                                conteoMovimientoboot = conteoMovimientoboot + 1;
                            } else if (!" #".equals(matriz[PosicionXBoot - 1][PosicionYBoot]) && !" S".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                if (" G".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                    CasillaActual = " G";
                                } else if (" O".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                    CasillaActual = " O";
                                } else if (" J".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                    System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                    verAtrapaJugador = true;
                                }
                                matriz[PosicionXBoot - 1][PosicionYBoot] = " B";
                                matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                                System.out.println("\nEl Boot se a movido una casilla hacia el Norte");
                                PosicionXBoot--;
                                conteoMovimientoboot = conteoMovimientoboot + 1;
                            } else if (!" #".equals(matriz[PosicionXBoot][PosicionYBoot - 1]) && !" S".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                if (" G".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                    CasillaActual = " G";
                                } else if (" O".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                    CasillaActual = " O";
                                } else if (" J".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                    System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                    verAtrapaJugador = true;
                                }
                                matriz[PosicionXBoot][PosicionYBoot - 1] = " B";
                                matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                                System.out.println("\nEl Boot se a movido una casilla hacia el Oeste");
                                PosicionYBoot--;
                                conteoMovimientoboot = conteoMovimientoboot + 1;
                            } else if (!" #".equals(matriz[PosicionXBoot + 1][PosicionYBoot]) && !" S".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                if (" G".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                    CasillaActual = " G";
                                } else if (" O".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                    CasillaActual = " O";
                                } else if (" J".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                    System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                    verAtrapaJugador = true;
                                }
                                matriz[PosicionXBoot + 1][PosicionYBoot] = " B";
                                matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                                System.out.println("\nEl Boot se a movido una casilla hacia el Sur");
                                PosicionXBoot++;
                                conteoMovimientoboot = conteoMovimientoboot + 1;
                            }
                        } else if (" J".equals(matriz[PosicionXBoot - 2][PosicionYBoot - 1]) || " J".equals(matriz[PosicionXBoot - 2][PosicionYBoot]) || " J".equals(matriz[PosicionXBoot - 2][PosicionYBoot + 1]) || " J".equals(matriz[PosicionXBoot - 1][PosicionYBoot - 1]) || " J".equals(matriz[PosicionXBoot - 1][PosicionYBoot]) || " J".equals(matriz[PosicionXBoot - 1][PosicionYBoot + 1])) {
                            if (!" #".equals(matriz[PosicionXBoot - 1][PosicionYBoot]) && !" S".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                if (" G".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                    CasillaActual = " G";
                                } else if (" O".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                    CasillaActual = " O";
                                } else if (" J".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                    System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                    verAtrapaJugador = true;
                                }
                                matriz[PosicionXBoot - 1][PosicionYBoot] = " B";
                                matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                                System.out.println("\nEl Boot se a movido una casilla hacia el Norte");
                                PosicionXBoot--;
                                conteoMovimientoboot = conteoMovimientoboot + 1;
                            } else if (!" #".equals(matriz[PosicionXBoot][PosicionYBoot - 1]) && !" S".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                if (" G".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                    CasillaActual = " G";
                                } else if (" O".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                    CasillaActual = " O";
                                } else if (" J".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                    System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                    verAtrapaJugador = true;
                                }
                                matriz[PosicionXBoot][PosicionYBoot - 1] = " B";
                                matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                                System.out.println("\nEl Boot se a movido una casilla hacia el Oeste");
                                PosicionYBoot--;
                                conteoMovimientoboot = conteoMovimientoboot + 1;
                            } else if (!" #".equals(matriz[PosicionXBoot][PosicionYBoot + 1]) && !" S".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                if (" G".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                    CasillaActual = " G";
                                } else if (" O".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                    CasillaActual = " O";
                                } else if (" J".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                    System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                    verAtrapaJugador = true;
                                }
                                matriz[PosicionXBoot][PosicionYBoot + 1] = " B";
                                matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                                System.out.println("\nEl Boot se a movido una casilla hacia el Este");
                                PosicionYBoot++;
                                conteoMovimientoboot = conteoMovimientoboot + 1;
                            } else if (!" #".equals(matriz[PosicionXBoot + 1][PosicionYBoot]) && !" S".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                if (" G".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                    CasillaActual = " G";
                                } else if (" O".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                    CasillaActual = " O";
                                } else if (" J".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                    System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                    verAtrapaJugador = true;
                                }
                                matriz[PosicionXBoot + 1][PosicionYBoot] = " B";
                                matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                                System.out.println("\nEl Boot se a movido una casilla hacia el Sur");
                                PosicionXBoot++;
                                conteoMovimientoboot = conteoMovimientoboot + 1;
                            }
                        } else if (" J".equals(matriz[PosicionXBoot + 2][PosicionYBoot - 1]) || " J".equals(matriz[PosicionXBoot + 2][PosicionYBoot]) || " J".equals(matriz[PosicionXBoot + 2][PosicionYBoot + 1]) || " J".equals(matriz[PosicionXBoot + 1][PosicionYBoot - 1]) || " J".equals(matriz[PosicionXBoot + 1][PosicionYBoot]) || " J".equals(matriz[PosicionXBoot + 1][PosicionYBoot + 1])) {
                            if (!" #".equals(matriz[PosicionXBoot + 1][PosicionYBoot]) && !" S".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                if (" G".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                    CasillaActual = " G";
                                } else if (" O".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                    CasillaActual = " O";
                                } else if (" J".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                    System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                    verAtrapaJugador = true;
                                }
                                matriz[PosicionXBoot + 1][PosicionYBoot] = " B";
                                matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                                System.out.println("\nEl Boot se a movido una casilla hacia el Sur");
                                PosicionXBoot++;
                                conteoMovimientoboot = conteoMovimientoboot + 1;
                            } else if (!" #".equals(matriz[PosicionXBoot][PosicionYBoot - 1]) && !" S".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                if (" G".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                    CasillaActual = " G";
                                } else if (" O".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                    CasillaActual = " O";
                                } else if (" J".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                    System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                    verAtrapaJugador = true;
                                }
                                matriz[PosicionXBoot][PosicionYBoot - 1] = " B";
                                matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                                System.out.println("\nEl Boot se a movido una casilla hacia el Oeste");
                                PosicionYBoot--;
                                conteoMovimientoboot = conteoMovimientoboot + 1;
                            } else if (!" #".equals(matriz[PosicionXBoot][PosicionYBoot + 1]) && !" S".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                if (" G".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                    CasillaActual = " G";
                                } else if (" O".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                    CasillaActual = " O";
                                } else if (" J".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                    System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                    verAtrapaJugador = true;
                                }
                                matriz[PosicionXBoot][PosicionYBoot + 1] = " B";
                                matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                                System.out.println("\nEl Boot se a movido una casilla hacia el Este");
                                PosicionYBoot++;
                                conteoMovimientoboot = conteoMovimientoboot + 1;
                            } else if (!" #".equals(matriz[PosicionXBoot - 1][PosicionYBoot]) && !" S".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                if (" G".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                    CasillaActual = " G";
                                } else if (" O".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                    CasillaActual = " O";
                                } else if (" J".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                    System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                    verAtrapaJugador = true;
                                }
                                matriz[PosicionXBoot - 1][PosicionYBoot] = " B";
                                matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                                System.out.println("\nEl Boot se a movido una casilla hacia el Norte");
                                PosicionXBoot--;
                                conteoMovimientoboot = conteoMovimientoboot + 1;
                            }
                        }
                    } else {
                        if (!" #".equals(matriz[PosicionXBoot - 1][PosicionYBoot]) && !" S".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                            if (" G".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot - 1][PosicionYBoot])) {
                                System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot - 1][PosicionYBoot] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            System.out.println("\nEl Boot se a movido una casilla hacia el Norte");
                            PosicionXBoot--;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        } else if (!" #".equals(matriz[PosicionXBoot][PosicionYBoot + 1]) && !" S".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                            if (" G".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                                System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot][PosicionYBoot + 1] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            System.out.println("\nEl Boot se a movido una casilla hacia el Este");
                            PosicionYBoot++;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        } else if (!" #".equals(matriz[PosicionXBoot][PosicionYBoot - 1]) && !" S".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                            if (" G".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                                System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot][PosicionYBoot - 1] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            System.out.println("\nEl Boot se a movido una casilla hacia el Oeste");
                            PosicionYBoot--;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        } else if (!" #".equals(matriz[PosicionXBoot + 1][PosicionYBoot]) && !" S".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                            if (" G".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                CasillaActual = " G";
                            } else if (" O".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                CasillaActual = " O";
                            } else if (" J".equals(matriz[PosicionXBoot + 1][PosicionYBoot])) {
                                System.out.println("\nEl Boot te alcanzo, has perdido el juego");
                                verAtrapaJugador = true;
                            }
                            matriz[PosicionXBoot + 1][PosicionYBoot] = " B";
                            matriz[PosicionXBoot][PosicionYBoot] = CasillaActual;
                            System.out.println("\nEl Boot se a movido una casilla hacia el Sur");
                            PosicionXBoot++;
                            conteoMovimientoboot = conteoMovimientoboot + 1;
                        }
                    }
                }
                if (verAtrapaJugador == true) {
                    turno = 2;
                } else {
                    turno = 0;
                }
            }
            if (turno == 0) {
                System.out.println("\nIngrese un comando: ");
                comando = scanner.next();

                if ("ORO_REQUERIDO".equals(comando) || "oro_requerido".equals(comando)) {
                    if (casillaActualJugador == " S") {
                        System.out.println("\nCantidad de monedas de oro que requieres para salir\n");
                        if (PosicionXJugador == 1 && PosicionYJugador == 0) {
                            System.out.println("Salida: 15 monedas de Oro");
                        } else if (PosicionXJugador == 0 && PosicionYJugador == 8) {
                            System.out.println("Salida: 30 monedas de Oro");
                        } else if (PosicionXJugador == 1 && PosicionYJugador == 29) {
                            System.out.println("Salida: 51 monedas de Oro");
                        } else if (PosicionXJugador == 21 && PosicionYJugador == 29) {
                            System.out.println("Salida: 55 monedas de Oro");
                        } else if (PosicionXJugador == 29 && PosicionYJugador == 13) {
                            System.out.println("Salida: 43 monedas de Oro");
                        }
                        turno = 1;
                    } else {
                        System.out.println("En esta casilla no existe ninguna salida, Has persido un turno\n");
                        turno = 1;
                        ConteoError++;
                    }
                } else if ("ORO".equals(comando) || "oro".equals(comando)) {
                    System.out.println(catidadOro);
                    turno = 1;

                } else if ("MOVER<N>".equals(comando) || "mover<n>".equals(comando)) {
                    if (" #".equals(matriz[PosicionXJugador - 1][PosicionYJugador])) {
                        System.out.println("\nEn esta posición existe una pared, por lo tanto pierdes el turno\n");
                    } else if (" G".equals(matriz[PosicionXJugador - 1][PosicionYJugador])) {
                        matriz[PosicionXJugador - 1][PosicionYJugador] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el norte\n");
                        System.out.println("\nEsta casilla contiene Oro\n");
                        casillaActualJugador = " G";
                        PosicionXJugador--;
                    } else if (" S".equals(matriz[PosicionXJugador - 1][PosicionYJugador])) {
                        matriz[PosicionXJugador - 1][PosicionYJugador] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el norte\n");
                        System.out.println("\nSalida\n");
                        casillaActualJugador = " S";
                        PosicionXJugador--;
                    } else if (" B".equals(matriz[PosicionXJugador - 1][PosicionYJugador])) {
                        matriz[PosicionXJugador - 1][PosicionYJugador] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = " O";
                        System.out.println("\nTe has movido una cailla hacia el norte\n");
                        System.out.println("\nEl Boot te atrapo, Has perdido\n");
                        verAtrapaJugador = true;
                        PosicionXJugador--;
                    } else {
                        matriz[PosicionXJugador - 1][PosicionYJugador] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el norte\n");
                        casillaActualJugador = " O";
                        PosicionXJugador--;
                    }
                    ConteoMovimientos = ConteoMovimientos + 1;
                    turno = 1;
                    if (verAtrapaJugador == true) {
                        turno = 2;
                    }

                } else if ("MOVER<S>".equals(comando) || "mover<s>".equals(comando)) {
                    if (" #".equals(matriz[PosicionXJugador + 1][PosicionYJugador])) {
                        System.out.println("\nEn esta posición existe una pared, por lo tanto pierdes el turno\n");
                    } else if (" G".equals(matriz[PosicionXJugador + 1][PosicionYJugador])) {
                        matriz[PosicionXJugador + 1][PosicionYJugador] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el Sur\n");
                        System.out.println("\nEsta casilla contiene Oro\n");
                        casillaActualJugador = " G";
                        PosicionXJugador++;
                    } else if (" S".equals(matriz[PosicionXJugador + 1][PosicionYJugador])) {
                        matriz[PosicionXJugador + 1][PosicionYJugador] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el Sur\n");
                        System.out.println("\nSalida\n");
                        casillaActualJugador = " S";
                        PosicionXJugador++;
                    } else if (" B".equals(matriz[PosicionXJugador + 1][PosicionYJugador])) {
                        matriz[PosicionXJugador + 1][PosicionYJugador] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = " O";
                        System.out.println("\nTe has movido una cailla hacia el Sur\n");
                        System.out.println("\nEl Boot te atrapo, Has perdido\n");
                        verAtrapaJugador = true;
                        PosicionXJugador++;
                    } else {
                        matriz[PosicionXJugador + 1][PosicionYJugador] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el Sur\n");
                        casillaActualJugador = " O";
                        PosicionXJugador++;
                    }
                    ConteoMovimientos = ConteoMovimientos + 1;
                    turno = 1;
                    if (verAtrapaJugador == true) {
                        turno = 2;
                    }

                } else if ("MOVER<E>".equals(comando) || "mover<e>".equals(comando)) {
                    if (" #".equals(matriz[PosicionXJugador][PosicionYJugador + 1])) {
                        System.out.println("\nEn esta posición existe una pared, por lo tanto pierdes el turno\n");
                    } else if (" G".equals(matriz[PosicionXJugador][PosicionYJugador + 1])) {
                        matriz[PosicionXJugador][PosicionYJugador + 1] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el Este\n");
                        System.out.println("\nEsta casilla contiene Oro\n");
                        casillaActualJugador = " G";
                        PosicionYJugador++;
                    } else if (" S".equals(matriz[PosicionXJugador][PosicionYJugador + 1])) {
                        matriz[PosicionXJugador][PosicionYJugador + 1] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el Este\n");
                        System.out.println("\nSalida");
                        casillaActualJugador = " S";
                        PosicionYJugador++;
                    } else if (" B".equals(matriz[PosicionXJugador][PosicionYJugador + 1])) {
                        matriz[PosicionXJugador + 1][PosicionYJugador + 1] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = " O";
                        System.out.println("\nTe has movido una cailla hacia el Este\n");
                        System.out.println("\nEl Boot te atrapo, Has perdido\n");
                        verAtrapaJugador = true;
                        PosicionYJugador++;
                    } else {
                        matriz[PosicionXJugador][PosicionYJugador + 1] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el Este\n");
                        casillaActualJugador = " O";
                        PosicionYJugador++;
                    }
                    ConteoMovimientos = ConteoMovimientos + 1;
                    turno = 1;
                    if (verAtrapaJugador == true) {
                        turno = 2;
                    }

                } else if ("MOVER<O>".equals(comando) || "mover<o>".equals(comando)) {
                    if (" #".equals(matriz[PosicionXJugador][PosicionYJugador - 1])) {
                        System.out.println("\nEn esta posición existe una pared, por lo tanto pierdes el turno\n");
                    } else if (" G".equals(matriz[PosicionXJugador][PosicionYJugador - 1])) {
                        matriz[PosicionXJugador][PosicionYJugador - 1] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el Oeste\n");
                        System.out.println("\nEsta casilla contiene Oro\n");
                        casillaActualJugador = " G";
                        PosicionYJugador--;
                    } else if (" S".equals(matriz[PosicionXJugador][PosicionYJugador - 1])) {
                        matriz[PosicionXJugador][PosicionYJugador - 1] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el Oeste\n");
                        System.out.println("\nSalida\n");
                        casillaActualJugador = " S";
                        PosicionYJugador--;
                    } else if (" B".equals(matriz[PosicionXJugador][PosicionYJugador - 1])) {
                        matriz[PosicionXJugador + 1][PosicionYJugador - 1] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el Oeste\n");
                        System.out.println("\nEl Boot te atrapo, Has perdido\n");
                        verAtrapaJugador = true;
                        PosicionYJugador--;
                    } else {
                        matriz[PosicionXJugador][PosicionYJugador - 1] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = " O";
                        System.out.println("\nTe has movido una cailla hacia el Oeste\n");
                        casillaActualJugador = " O";
                        PosicionYJugador--;
                    }
                    ConteoMovimientos = ConteoMovimientos + 1;
                    turno = 1;
                    if (verAtrapaJugador == true) {
                        turno = 2;
                    }

                } else if ("LEVANTAR".equals(comando) || "levantar".equals(comando)) {
                    if (" G".equals(casillaActualJugador)) {
                        OroObtendo = (int) (Math.random() * 15 + 5);
                        System.out.println("\nHas obtenido " + OroObtendo + " monedas de Oro");
                        catidadOro = catidadOro + OroObtendo;
                        System.out.println("Tiene en total " + catidadOro + " monedas de Oro\n");
                        casillaActualJugador = " O";
                        turno = 1;
                    } else {
                        System.out.println("Comando invalido, en esta casilla no existe Oro, Has perdido un turno\n");
                        ConteoError++;
                        turno = 1;

                    }

                } else if ("MIRAR".equals(comando) || "mirar".equals(comando)) {
                    System.out.println("\nPosición Actual");
                    Matriz.MatrizPequeña(matriz, PosicionXJugador, PosicionYJugador);
                    turno = 1;
                } else if ("SALIR".equals(comando) || "salir".equals(comando)) {
                    if (" S".equals(casillaActualJugador)) {
                        if (PosicionXJugador == 1 && PosicionYJugador == 0) {
                            OroRequerido = 15;

                        } else if (PosicionXJugador == 0 && PosicionYJugador == 8) {
                            OroRequerido = 30;
                        } else if (PosicionXJugador == 1 && PosicionYJugador == 29) {
                            OroRequerido = 51;
                        } else if (PosicionXJugador == 21 && PosicionYJugador == 29) {
                            OroRequerido = 55;
                        } else if (PosicionXJugador == 29 && PosicionYJugador == 13) {
                            OroRequerido = 43;
                        }
                        if (OroObtendo >= OroRequerido) {
                            System.out.println("\nFelicidades Has ganado\n");
                            casillaActualJugador = " S";
                            turno = 2;
                            verAtrapaJugador = true;
                            VerSalida = true;
                        } else {
                            System.out.println("No tiene Oro suficiente para Salir\n");
                            turno = 1;
                        }
                    } else {
                        System.out.println("Comando Invalido, esta casilla no es una salida, Has perdido un turno\n");
                        ConteoError++;
                        turno = 1;
                    }
                } else {
                    System.out.println("Comando invalido, Has perdido un turno");
                    ConteoError = ConteoError + 1;
                    turno = 1;
                }
                if (ConteoError == 3) {
                    verAtrapaJugador = true;
                    turno = 2;
                }
            }

            if (turno == 1) {
                System.out.println("\nEl Boot esta viendo el mapa");
                if (PosicionXBoot == 1 || PosicionXBoot == 28 || PosicionYBoot == 1 || PosicionYJugador == 28) {
                    if (" J".equals(matriz[PosicionXBoot - 1][PosicionYBoot - 1]) || " J".equals(matriz[PosicionXBoot][PosicionYBoot - 1]) || " J".equals(matriz[PosicionXBoot + 1][PosicionYBoot - 1])) {
                        System.out.println("Estas a la vista del Boot");
                        conteoJVistaBoot = conteoJVistaBoot + 1;
                    } else if (" J".equals(matriz[PosicionXBoot - 1][PosicionYBoot - 1]) || " J".equals(matriz[PosicionXBoot - 1][PosicionYBoot]) || " J".equals(matriz[PosicionXBoot - 1][PosicionYBoot + 1])) {
                        System.out.println("Estas a la vista del Boot");
                        conteoJVistaBoot = conteoJVistaBoot + 1;
                    } else if (" J".equals(matriz[PosicionXBoot - 1][PosicionYBoot - 1]) || " J".equals(matriz[PosicionXBoot - 1][PosicionYBoot]) || " J".equals(matriz[PosicionXBoot - 1][PosicionYBoot + 1])) {
                        System.out.println("Estas a la vista del Boot");
                        conteoJVistaBoot = conteoJVistaBoot + 1;
                    } else if (" J".equals(matriz[PosicionXBoot + 1][PosicionYBoot - 1]) || " J".equals(matriz[PosicionXBoot + 1][PosicionYBoot]) || " J".equals(matriz[PosicionXBoot + 1][PosicionYBoot + 1])) {
                        System.out.println("Estas a la vista del Boot");
                        conteoJVistaBoot = conteoJVistaBoot + 1;
                    } else {
                        System.out.println("El Boot no esta cerca de tu posición");
                    }
                } else {
                    if (" J".equals(matriz[PosicionXBoot - 2][PosicionYBoot - 2]) || " J".equals(matriz[PosicionXBoot - 1][PosicionYBoot - 2]) || " J".equals(matriz[PosicionXBoot][PosicionYBoot - 2]) || " J".equals(matriz[PosicionXBoot + 1][PosicionYBoot - 2]) || " J".equals(matriz[PosicionXBoot + 2][PosicionYBoot - 2]) || " J".equals(matriz[PosicionXBoot][PosicionYBoot - 1])) {
                        System.out.println("Estas a la vista del Boot");
                        conteoJVistaBoot = conteoJVistaBoot + 1;
                    } else if (" J".equals(matriz[PosicionXBoot - 2][PosicionYBoot + 2]) || " J".equals(matriz[PosicionXBoot - 1][PosicionYBoot + 2]) || " J".equals(matriz[PosicionXBoot][PosicionYBoot + 2]) || " J".equals(matriz[PosicionXBoot + 1][PosicionYBoot + 2]) || " J".equals(matriz[PosicionXBoot + 2][PosicionYBoot + 2]) || " J".equals(matriz[PosicionXBoot][PosicionYBoot + 1])) {
                        System.out.println("Estas a la vista del Boot");
                        conteoJVistaBoot = conteoJVistaBoot + 1;
                    } else if (" J".equals(matriz[PosicionXBoot - 2][PosicionYBoot - 1]) || " J".equals(matriz[PosicionXBoot - 2][PosicionYBoot]) || " J".equals(matriz[PosicionXBoot - 2][PosicionYBoot + 1]) || " J".equals(matriz[PosicionXBoot - 1][PosicionYBoot - 1]) || " J".equals(matriz[PosicionXBoot - 1][PosicionYBoot]) || " J".equals(matriz[PosicionXBoot - 1][PosicionYBoot + 1])) {
                        System.out.println("Estas a la vista del Boot");
                        conteoJVistaBoot = conteoJVistaBoot + 1;
                    } else if (" J".equals(matriz[PosicionXBoot + 2][PosicionYBoot - 1]) || " J".equals(matriz[PosicionXBoot + 2][PosicionYBoot]) || " J".equals(matriz[PosicionXBoot + 2][PosicionYBoot + 1]) || " J".equals(matriz[PosicionXBoot + 1][PosicionYBoot - 1]) || " J".equals(matriz[PosicionXBoot + 1][PosicionYBoot]) || " J".equals(matriz[PosicionXBoot + 1][PosicionYBoot + 1])) {
                        System.out.println("Estas a la vista del Boot");
                        conteoJVistaBoot = conteoJVistaBoot + 1;
                    } else {
                        System.out.println("El Boot no esta cerca de tu posición");
                    }
                }
                turno = 0;

            }
            if (turno == 0) {
                System.out.println("\nIngrese un comando: ");
                comando = scanner.next();

                if ("ORO_REQUERIDO".equals(comando) || "oro_requerido".equals(comando)) {
                    if (" S".equals(casillaActualJugador)) {
                        System.out.println("\nCantidad de monedas de oro que requieres para salir\n");
                        if (PosicionXJugador == 1 && PosicionYJugador == 0) {
                            System.out.println("Salida: 15 monedas de Oro");
                        } else if (PosicionXJugador == 0 && PosicionYJugador == 8) {
                            System.out.println("Salida: 30 monedas de Oro");
                        } else if (PosicionXJugador == 1 && PosicionYJugador == 29) {
                            System.out.println("Salida: 51 monedas de Oro");
                        } else if (PosicionXJugador == 21 && PosicionYJugador == 29) {
                            System.out.println("Salida: 55 monedas de Oro");
                        } else if (PosicionXJugador == 29 && PosicionYJugador == 13) {
                            System.out.println("Salida: 43 monedas de Oro");
                        }
                        turno = 1;
                    } else {
                        System.out.println("En esta casilla no existe ninguna salida, Has perdido un turno\n");
                        turno = 1;
                        ConteoError++;
                    }
                } else if ("ORO".equals(comando) || "oro".equals(comando)) {
                    System.out.println(catidadOro);
                    turno = 1;

                } else if ("MOVER<N>".equals(comando) || "mover<n>".equals(comando)) {
                    if (" #".equals(matriz[PosicionXJugador - 1][PosicionYJugador])) {
                        System.out.println("\nEn esta posición existe una pared, por lo tanto pierdes el turno\n");
                    } else if (" G".equals(matriz[PosicionXJugador - 1][PosicionYJugador])) {
                        matriz[PosicionXJugador - 1][PosicionYJugador] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el norte\n");
                        System.out.println("\nEsta casilla contiene Oro\n");
                        casillaActualJugador = " G";
                        PosicionXJugador--;
                    } else if (" S".equals(matriz[PosicionXJugador - 1][PosicionYJugador])) {
                        matriz[PosicionXJugador - 1][PosicionYJugador] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el norte\n");
                        System.out.println("\nSalida\n");
                        casillaActualJugador = " S";
                        PosicionXJugador--;
                    } else if (" B".equals(matriz[PosicionXJugador - 1][PosicionYJugador])) {
                        matriz[PosicionXJugador - 1][PosicionYJugador] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = " O";
                        System.out.println("\nTe has movido una cailla hacia el norte\n");
                        System.out.println("\nEl Boot te atrapo, Has perdido\n");
                        verAtrapaJugador = true;
                        PosicionXJugador--;
                    } else {
                        matriz[PosicionXJugador - 1][PosicionYJugador] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el norte\n");
                        casillaActualJugador = " O";
                        PosicionXJugador--;
                    }
                    ConteoMovimientos = ConteoMovimientos + 1;
                    turno = 1;
                    if (verAtrapaJugador == true) {
                        turno = 2;
                    }

                } else if ("MOVER<S>".equals(comando) || "mover<s>".equals(comando)) {
                    if (" #".equals(matriz[PosicionXJugador + 1][PosicionYJugador])) {
                        System.out.println("\nEn esta posición existe una pared, por lo tanto pierdes el turno\n");
                    } else if (" G".equals(matriz[PosicionXJugador + 1][PosicionYJugador])) {
                        matriz[PosicionXJugador + 1][PosicionYJugador] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el Sur\n");
                        System.out.println("\nEsta casilla contiene Oro\n");
                        casillaActualJugador = " G";
                        PosicionXJugador++;
                    } else if (" S".equals(matriz[PosicionXJugador + 1][PosicionYJugador])) {
                        matriz[PosicionXJugador + 1][PosicionYJugador] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el Sur\n");
                        System.out.println("\nSalida\n");
                        casillaActualJugador = " S";
                        PosicionXJugador++;
                    } else if (" B".equals(matriz[PosicionXJugador + 1][PosicionYJugador])) {
                        matriz[PosicionXJugador + 1][PosicionYJugador] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = " O";
                        System.out.println("\nTe has movido una cailla hacia el Sur\n");
                        System.out.println("\nEl Boot te atrapo, Has perdido\n");
                        verAtrapaJugador = true;
                        PosicionXJugador++;
                    } else {
                        matriz[PosicionXJugador + 1][PosicionYJugador] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el Sur\n");
                        casillaActualJugador = " O";
                        PosicionXJugador++;
                    }
                    ConteoMovimientos = ConteoMovimientos + 1;
                    turno = 1;
                    if (verAtrapaJugador == true) {
                        turno = 2;
                    }

                } else if ("MOVER<E>".equals(comando) || "mover<e>".equals(comando)) {
                    if (" #".equals(matriz[PosicionXJugador][PosicionYJugador + 1])) {
                        System.out.println("\nEn esta posición existe una pared, por lo tanto pierdes el turno\n");
                    } else if (" G".equals(matriz[PosicionXJugador][PosicionYJugador + 1])) {
                        matriz[PosicionXJugador][PosicionYJugador + 1] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el Este\n");
                        System.out.println("\nEsta casilla contiene Oro\n");
                        casillaActualJugador = " G";
                        PosicionYJugador++;
                    } else if (" S".equals(matriz[PosicionXJugador][PosicionYJugador + 1])) {
                        matriz[PosicionXJugador][PosicionYJugador + 1] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el Este\n");
                        System.out.println("\nSalida");
                        casillaActualJugador = " S";
                        PosicionYJugador++;
                    } else if (" B".equals(matriz[PosicionXJugador][PosicionYJugador + 1])) {
                        matriz[PosicionXJugador + 1][PosicionYJugador + 1] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = " O";
                        System.out.println("\nTe has movido una cailla hacia el Este\n");
                        System.out.println("\nEl Boot te atrapo, Has perdido\n");
                        verAtrapaJugador = true;
                        PosicionYJugador++;
                    } else {
                        matriz[PosicionXJugador][PosicionYJugador + 1] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el Este\n");
                        casillaActualJugador = " O";
                        PosicionYJugador++;
                    }
                    ConteoMovimientos = ConteoMovimientos + 1;
                    turno = 1;
                    if (verAtrapaJugador == true) {
                        turno = 2;
                    }

                } else if ("MOVER<O>".equals(comando) || "mover<o>".equals(comando)) {
                    if (" #".equals(matriz[PosicionXJugador][PosicionYJugador - 1])) {
                        System.out.println("\nEn esta posición existe una pared, por lo tanto pierdes el turno\n");
                    } else if (" G".equals(matriz[PosicionXJugador][PosicionYJugador - 1])) {
                        matriz[PosicionXJugador][PosicionYJugador - 1] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el Oeste\n");
                        System.out.println("\nEsta casilla contiene Oro\n");
                        casillaActualJugador = " G";
                        PosicionYJugador--;
                    } else if (" S".equals(matriz[PosicionXJugador][PosicionYJugador - 1])) {
                        matriz[PosicionXJugador][PosicionYJugador - 1] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el Oeste\n");
                        System.out.println("\nSalida\n");
                        casillaActualJugador = " S";
                        PosicionYJugador--;
                    } else if (" B".equals(matriz[PosicionXJugador][PosicionYJugador - 1])) {
                        matriz[PosicionXJugador + 1][PosicionYJugador - 1] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = casillaActualJugador;
                        System.out.println("\nTe has movido una cailla hacia el Oeste\n");
                        System.out.println("\nEl Boot te atrapo, Has perdido\n");
                        verAtrapaJugador = true;
                        PosicionYJugador--;
                    } else {
                        matriz[PosicionXJugador][PosicionYJugador - 1] = " J";
                        matriz[PosicionXJugador][PosicionYJugador] = " O";
                        System.out.println("\nTe has movido una cailla hacia el Oeste\n");
                        casillaActualJugador = " O";
                        PosicionYJugador--;
                    }
                    ConteoMovimientos = ConteoMovimientos + 1;
                    turno = 1;
                    if (verAtrapaJugador == true) {
                        turno = 2;
                    }

                } else if ("LEVANTAR".equals(comando) || "levantar".equals(comando)) {
                    if (" G".equals(casillaActualJugador)) {
                        OroObtendo = (int) (Math.random() * 15 + 5);
                        System.out.println("\nHas obtenido " + OroObtendo + " monedas de Oro");
                        catidadOro = catidadOro + OroObtendo;
                        System.out.println("Tiene en total " + catidadOro + " monedas de Oro\n");
                        casillaActualJugador = " O";
                        turno = 1;
                    } else {
                        System.out.println("Comando invalido, en esta casilla no existe Oro, Has perdido un turno\n");
                        ConteoError++;
                        turno = 1;

                    }

                } else if ("MIRAR".equals(comando) || "mirar".equals(comando)) {
                    System.out.println("\nPosición Actual");
                    Matriz.MatrizPequeña(matriz, PosicionXJugador, PosicionYJugador);
                    turno = 1;
                } else if ("SALIR".equals(comando) || "salir".equals(comando)) {
                    if (" S".equals(casillaActualJugador)) {
                        if (PosicionXJugador == 1 && PosicionYJugador == 0) {
                            OroRequerido = 15;

                        } else if (PosicionXJugador == 0 && PosicionYJugador == 8) {
                            OroRequerido = 30;
                        } else if (PosicionXJugador == 1 && PosicionYJugador == 29) {
                            OroRequerido = 51;
                        } else if (PosicionXJugador == 21 && PosicionYJugador == 29) {
                            OroRequerido = 55;
                        } else if (PosicionXJugador == 29 && PosicionYJugador == 13) {
                            OroRequerido = 43;
                        }
                        if (OroObtendo >= OroRequerido) {
                            System.out.println("\nFelicidades Has ganado\n");
                            casillaActualJugador = " S";
                            turno = 2;
                            verAtrapaJugador = true;
                            VerSalida = true;
                        } else {
                            System.out.println("No tiene Oro suficiente para Salir\n");
                            turno = 1;
                        }
                    } else {
                        System.out.println("Comando Invalido, esta casilla no es una salida, Has perdido un turno\n");
                        ConteoError++;
                        turno = 1;
                    }
                } else {
                    System.out.println("Comando Invalido, Has perdido un turno");
                    ConteoError++;
                    turno = 1;
                }
                if (ConteoError == 3) {
                    verAtrapaJugador = true;
                    turno = 2;
                }

            }
        }

        System.out.println("\nREPORTES DE LA PARTIDA\n");
        if (ConteoError == 3) {
            System.out.println("Te Equivocaste 3 veces al ingresar los comandos");
            System.out.println("Obtuviste " + catidadOro + " monedas de Oro durante la partida");
            System.out.println("Realizaste " + ConteoMovimientos + " movimientos durante la partida");
            System.out.println("Estuviste " + conteoJVistaBoot + " veces a la vista del Boot");
        } else if (VerSalida == true) {
            System.out.println("Obtuviste " + catidadOro + " monedas de Oro durante la partida");
            System.out.println("Realizaste " + ConteoMovimientos + " movimientos durante la partida");
            System.out.println("Estuviste " + conteoJVistaBoot + " veces a la vista del Boot");
        } else if (verAtrapaJugador == true) {
            System.out.println("Obtuviste " + catidadOro + " monedas de Oro durante la partida");
            System.out.println("Realizaste " + ConteoMovimientos + " movimientos durante la partida");
            System.out.println("El Boot hizo " + conteoMovimientoboot + " movimientos para atraparte");
            System.out.println("Estuviste " + conteoJVistaBoot + " veces a la vista del Boot");
        }

    }

}