public class Archivo extends Elemento {
    private int tam;

    public Archivo(String nombre, int tam) {
        super(nombre);
        this.tam = tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    @Override
    public long getTam() {
        return tam;
    }
}
