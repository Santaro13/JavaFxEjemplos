package com.example.ej3gridimageview;

import java.util.Scanner;

public class Constantes {
    private static final Scanner sc = new Scanner(System.in);
    //public static final String
    public static final String MSG_TURNO_BLANCO = "Turno de las Blancas";
    public static final String MSG_TURNO_NEGRO = "Turno de las Negras";
    public static final String MSG_INTRODUCE_JUGADA = "Introduce tu jugada: ";
    public static final String MSG_JUGADA_NO_VALIDA = "\n Jugada no valida";
    public static final String MSG_TURNO_INVALIDO = "\n No es tu turno";
    public static final String MSG_ERROR = "ERROR";
    public static final String MSG_CANIBALISMO = "\n Pero no te comas tus piezas, animal";
    public static final String MSG_HAY_PIEZA_ENTRE = "\n Una pieza bloquea tu camino";
    public static final String MSG_GANADOR = "\n FIN DEL JUEGO, HAS GANADO!";
    public static final String MSG_BLANCAS_NEGRAS = "\n EL GANADOR ES: ";
    public static final String MSG_JAQUE= "\n REY EN JAQUE, CUIDADO";
    public static final String MSG_PROMOCION = """
            Selecione el numero de la pieza a promocionar:
            1->Reina
            2->Torre
            3->Alfil
            4->Caballo
            """;

    public static String leerTexto(String mensaje) {
        System.out.println(mensaje);
        return sc.nextLine().trim().toLowerCase();
    }

    public static int leerEntero(String mensaje) {
        System.out.println(mensaje);
        return sc.nextInt();
    }
    public static String print(String msg) {
        System.out.println(msg);
        return msg;
    }
}
