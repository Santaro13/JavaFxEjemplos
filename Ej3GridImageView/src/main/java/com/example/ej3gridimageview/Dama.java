package com.example.ej3gridimageview;

public class Dama extends Pieza {

    public Dama(int color) {
        super(color);
        this.setNombre("Piezas.Dama");
    }

    @Override
    public boolean movimientoValido(Movimiento mov) {
        if (mov.esDiagonal() || mov.esHorizontal() || mov.esVertical()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String pintarPieza() {
        return getColor() == 0 ? "[♕]" : "[♛]";
    }
    @Override
    public String toString() {
        return getColor() == 0 ? "ReinaNegra.png" : "ReinaBlanca.png";    }
}
