public class Documento implements Imprimible {
    private String texto;

    public Documento(String texto) {
        this.texto = texto;
    }

    @Override
    public void imprimir() {
    }
}
