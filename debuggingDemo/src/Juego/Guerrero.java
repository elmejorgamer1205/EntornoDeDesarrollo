package Juego;

public class Guerrero {
    private String nombre;
    private int vidaActual;
    private int vidaMaxima;
    private int ataqueBase;
    private int pociones;

    public Guerrero(String nombre, int vidaMaxima, int ataqueBase) {
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
        this.ataqueBase = ataqueBase;
        this.pociones = 3;
    }

    public int atacar() {
        int factorSuerte = (int) (Math.random() * 10);
        return this.ataqueBase + factorSuerte;
    }

    public void curar() {
        if (this.pociones > 0) {
            System.out.println(this.nombre + " usa una poción.");

            this.vidaActual += 20;

            if (this.vidaActual > this.vidaMaxima) {
                this.vidaActual = this.vidaMaxima;
            }

            this.pociones--;
        } else {
            System.out.println("¡No quedan pociones!");
        }
    }

    public void recibirDano(int cantidad) {
        this.vidaActual -= cantidad;
    }

    public boolean estaVivo() {
        return this.vidaActual > 0;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public String getNombre() {
        return nombre;
    }
}

