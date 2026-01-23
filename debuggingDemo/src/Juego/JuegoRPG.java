package Juego;

public class JuegoRPG {
    public static void main(String[] args) {
        Guerrero heroe = new Guerrero("Aragorn", 100, 15);
        Orco enemigo = new Orco("Uruk-hai", 60, 10);

        System.out.println("--- INICIO DEL COMBATE ---");

        int turno = 1;

        while (heroe.estaVivo() && !enemigo.estaDerrotado()) {

            System.out.println("\n--- Turno " + turno + " ---");
            System.out.println("Vida Héroe: " + heroe.getVidaActual());
            System.out.println("Vida Enemigo: " + enemigo.getVida());

            // Turno del Héroe
            if (heroe.getVidaActual() < 30) {
                heroe.curar();
            } else {
                int danoHeroe = heroe.atacar();
                enemigo.recibirDano(danoHeroe);
            }

            // Turno del Enemigo
            int danoEnemigo = enemigo.morder();
            heroe.recibirDano(danoEnemigo);

            turno++;

            try { Thread.sleep(1000); } catch (InterruptedException e) { }
        }

        System.out.println("--- FIN DEL COMBATE ---");

        if (heroe.estaVivo()) {
            System.out.println("¡El héroe ha ganado!");
        } else {
            System.out.println("El héroe ha caído...");
        }
    }
}
