package com.example.ej3gridimageview;

public class Rey extends Pieza {


    public Rey(int color) {
        super(color);
        this.setNombre("rey");
    }

    @Override
    public boolean movimientoValido(Movimiento mov) {
        if (mov.saltoHorizontal() == 1 || mov.saltoVertical() == 1 || mov.saltoDiagonal() == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String pintarPieza() {
        return getColor() == 0 ? "[♔]" : "[♚]";
    }
    @Override
    public String toString() {
        return getColor() == 0 ? "ReyNegro.png" : "ReyBlanco.png";
    }
}
