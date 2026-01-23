package Juego;

public class Orco {
    private String tipo;
    private int vida;
    private int fuerza;

    public Orco(String tipo, int vida, int fuerza) {
        this.tipo = tipo;
        this.vida = vida;
        this.fuerza = fuerza;
    }

    public int morder() {
        return this.fuerza;
    }

    public void recibirDano(int cantidad) {
        this.vida -= cantidad;
        System.out.println("¡El " + this.tipo + " recibe " + cantidad + " de daño!");
    }

    public boolean estaDerrotado() {
        return this.vida < 0;
    }

    public int getVida() {
        return vida; }
    public String getTipo() {
        return tipo; }
}
