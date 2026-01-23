package Gestores;

public class GestorEnvios {
    public double calcular(double precio) {
        double envio = 0.0;
        if (precio < 20){
        return 5;
        }else if (precio >= 20 && precio <= 49){
            return 3;
        }
        else return 0;
    }
}
