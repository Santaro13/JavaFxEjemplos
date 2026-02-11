package com.example.ej3gridimageview;


public abstract class Pieza {
    private final int color;
    //public static final int NEGRAS = 0;
    //public static final int BLANCAS = 1;
    private String nombre;

    //0-Negras 1-Blancas
    public Pieza(int color) {
        this.color = color;
        nombre = getClass().getSimpleName().toLowerCase();
    }

    public Pieza(int color, String nombre) {
        this.color = color;
        this.nombre = nombre;
    }


    public int getColor() {
        return color;
    }

    public abstract boolean movimientoValido(Movimiento mov);

    public String getNombre() {
        // proteger contra nombre == null
        return nombre == null ? "" : nombre.toLowerCase();
    }
    public void setNombre(String nombre) {
        if (nombre == null) {
            this.nombre = null;
        } else {
            this.nombre = nombre.toLowerCase();
        }

    }

    public void setPieza(Posicion posFin, Pieza otra) {
        if (otra == null) return;
        // copiar campos mutables; ahora sólo 'nombre'
        this.setNombre(otra.getNombre());
    }

    public abstract String pintarPieza();
    public abstract String toString();



}
