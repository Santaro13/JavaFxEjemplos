package com.example.ej3gridimageview;

public class Peon extends Pieza {
    public Peon(int color) {
        super(color);
        this.setNombre("peon");
    }

    @Override
    public boolean movimientoValido(Movimiento mov) {
        Posicion posIni = mov.getPosInicial();
        Posicion posFin = mov.getPosFinal();
        int saltov = mov.saltoVertical();
        int saltod = mov.saltoDiagonal();
        if (getColor() == 1) {
            if (saltov <= 0) return false;
            if (posIni.getFila() == 1 && mov.esVertical() && (saltov == 1 || saltov == 2)) {
                return true;
            }
            if (mov.esVertical() && saltov == 1) {
                return true;
            }

        }

        if (getColor() == 0) {
            if (saltov >= 0) return false;
            if (posIni.getFila() == 6 && mov.esVertical() && (saltov == -1 || saltov == -2)) {
                return true;
            }
            if (mov.esVertical() && saltov == -1) {
                return true;
            }
        }

        return false;
    }

    @Override
        public String pintarPieza () {
            return getColor() == 0 ? "[♙]" : "[♟]";
        }
    @Override
    public String toString() {
        return getColor() == 0 ? "PeonNegro.png" : "PeonBlanco.png";    }
}
