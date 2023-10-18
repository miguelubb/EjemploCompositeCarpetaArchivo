
import java.util.ArrayList;
import java.util.List;

public class Carpeta extends Elemento{
    private int tamBuffer;

    private ArrayList<Elemento> elementos;

    public Carpeta(String nombre,int tam) {
        super(nombre);
        tamBuffer=tam;
        elementos=new ArrayList<>(tam);
    }

    public int getTamBuffer() {
        return tamBuffer;
    }

    public void setTamBuffer(int tamBuffer) {
        this.tamBuffer = tamBuffer;
    }

    @Override
    public long getTam() {
        int tam=0;
        for (Elemento elemento : elementos) {
            tam+=elemento.getTam();
        }
        return tam;
    }

    @Override
    public void addElemento(Elemento e) {
        if(elementos.size()<tamBuffer) {
            elementos.add(e);
            e.moveCarpeta(this);
        }
    }

    @Override
    public Elemento remove(int pos) {
        return elementos.remove(pos);
    }

    @Override
    public boolean remove(Elemento elem) {
        return elementos.remove(elem);
    }

    @Override
    public String toString(String tab) {

        StringBuffer out= new StringBuffer(super.toString(tab));
        for (Elemento elem : elementos) {
            out.append(elem.toString(tab+"\t"));
        }
        return out.toString();
    }

    @Override
    protected void find(String nombre, List<String> out) {
        //si coincide el nombre de la carpeta con lo buscado se agrega a la salida.
        super.find(nombre, out);
        for (Elemento e : elementos) {
            e.find(nombre, out);
        }
    }
}
