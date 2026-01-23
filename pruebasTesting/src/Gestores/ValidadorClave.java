package Gestores;

public class ValidadorClave {
    public boolean esValida(String clave){
        if(clave == null || clave.length() < 8) {
            return false;
        }
        boolean numEcontrado = false;
        for (int i = 0; i < clave.length(); i++) {
            if(Character.isDigit(clave.charAt(i))){
                numEcontrado = true;
            }
        }
        return numEcontrado;
    }
}
