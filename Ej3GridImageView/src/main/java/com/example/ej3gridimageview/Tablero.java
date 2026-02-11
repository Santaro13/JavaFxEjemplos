package com.example.ej3gridimageview;


public class Tablero {
    Pieza[][] tablero = new Pieza[8][8];


    public Tablero() {
        //vacío
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                tablero[fila][columna] = null;
            }
        }
        //piezas negras
        tablero[7][1] = new Caballo(0);
        tablero[7][6] = new Caballo(0);
        tablero[7][3] = new Rey(0);
        tablero[7][4] = new Dama(0);
        tablero[7][0] = new Torre(0);
        tablero[7][7] = new Torre(0);
        tablero[7][2] = new Alfil(0);
        tablero[7][5] = new Alfil(0);

        // colocar peones
        for (int columna = 0; columna < 8; columna++) {
            tablero[1][columna] = new Peon(1);
        }


        //piezas blancas
        tablero[0][4] = new Dama(1);
        tablero[0][1] = new Caballo(1);
        tablero[0][3] = new Rey(1);
        tablero[0][6] = new Caballo(1);
        tablero[0][0] = new Torre(1);
        tablero[0][7] = new Torre(1);
        tablero[0][2] = new Alfil(1);
        tablero[0][5] = new Alfil(1);

        // colocar peones
        for (int columna = 0; columna < 8; columna++) {
            tablero[6][columna] = new Peon(0);
        }
    }


    public void pintarTablero() {
        for (int fila = 8; fila >= 1; fila--) {
            System.out.print(fila + " ");
            for (int columna = 0; columna < 8; columna++) {
                Pieza p = tablero[fila - 1][columna];
                String unicode = (p == null) ? "[ㅤ]" : p.pintarPieza();
                System.out.print(unicode + "  ");
            }
            System.out.println();
        }

        // letras
        System.out.print("   ");
        for (char letra = 'a'; letra <= 'h'; letra++) {
            System.out.print(letra + "ㅤ   ");
        }
        System.out.println();
    }


    public boolean hayPieza(int fila, int columna) {
        if (fila < 0 || fila > 7 || columna < 0 || columna > 7) {
            return false;
        }
        return tablero[fila][columna] != null;
    }

    public boolean hayPieza(Posicion pos) {

        return pos != null;
    }

    public Pieza[][] getTablero() {
        return tablero;
    }

    public void ponPieza(Pieza figura, int fila, int columna) {
        tablero[fila][columna] = figura;
    }

    public void ponPieza(Pieza figura, Posicion pos) {
        ponPieza(figura, pos.getFila(), pos.getColumna());
    }

    public void quitaPieza(int fila, int columna) {
        tablero[fila][columna] = null;

    }

    public void quitaPieza(Posicion pos) {
        quitaPieza(pos.getFila(), pos.getColumna());
    }

    public void moverPieza(Movimiento mov) {
        Posicion origen = mov.posInicial;
        Posicion destino = mov.posFinal;


        Pieza pieza1 = tablero[origen.getFila()][origen.getColumna()];
        ponPieza(pieza1, destino);
        quitaPieza(origen.getFila(), origen.getColumna());


    }

    public Pieza devuelvePieza(int fila, int columna) {
        return tablero[fila][columna];
    }

    public Pieza devuelvePieza(Posicion pos) {
        return devuelvePieza(pos.getFila(), pos.getColumna());
    }


    public Pieza hayPiezaEntre(Movimiento mov) {
        Posicion origen = mov.posInicial;
        Posicion destino = mov.posFinal;
        if (mov.esVertical()) {
            int col = origen.getColumna();
            int filaIn = Math.min(origen.getFila(), destino.getFila());
            int filaFin = Math.max(origen.getFila(), destino.getFila());
            for (int fila = filaIn + 1; fila < filaFin; fila++) {
                if (hayPieza(fila, col)) {
                    return devuelvePieza(fila, col);
                }
            }
        } else if (mov.esHorizontal()) {
            int fila = origen.getFila();
            int colIn = Math.min(origen.getColumna(), destino.getColumna());
            int colFin = Math.max(origen.getColumna(), destino.getColumna());
            for (int col = colIn + 1; col < colFin; col++)
                if (hayPieza(fila, col)) {
                    return devuelvePieza(fila, col);
                }
        } else if (mov.esDiagonal()) {
            int fila = origen.getFila();
            int col = origen.getColumna();
            int filaFin = destino.getFila();
            int colFin = destino.getColumna();

            int df = (filaFin - fila) > 0 ? 1 : -1;
            int dc = (colFin - col) > 0 ? 1 : -1;

            fila += df;
            col += dc;

            while (fila != filaFin && col != colFin) {
                if (hayPieza(fila, col)) {
                    return devuelvePieza(fila, col);
                }
                fila += df;
                col += dc;
            }
        }
        return null;
    }
    public boolean reyRivalVivo(int turnoActual) {
        int colorRival = turnoActual == 0 ? 1 : 0;
        for (int fila = 0; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                Pieza p = tablero[fila][col];
                if (p != null && p.getColor() == colorRival && p.getNombre().equals("rey")) {
                    return true;
                }
            }
        }
        return false;
    }

    private Posicion buscarRey(int colorRey) {
        for (int fila = 0; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                Pieza p = tablero[fila][col];
                if (p != null && p instanceof Rey && p.getColor() == colorRey) {
                    return new Posicion(fila, col);
                }
            }
        }
        return null;
    }


    public boolean hayJaque(int colorRey) {
        Posicion posRey = buscarRey(colorRey);
        if (posRey == null) return false;
        for (int fila = 0; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                Pieza p = tablero[fila][col];

                if (p != null && p.getColor() != colorRey) {
                    Movimiento mov = new Movimiento(new Posicion(fila, col), posRey);

                    if (p.movimientoValido(mov)) {
                        if (!(p instanceof Caballo)) {
                            if (hayPiezaEntre(mov) != null) continue;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
}


