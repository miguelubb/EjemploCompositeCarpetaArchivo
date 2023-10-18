import java.util.*;
public abstract class Elemento {
    private String nombre;
    //implementa la composición
    private Carpeta ubicacion;

    public Elemento(String nombre) {
        this.nombre = nombre;
        ubicacion=null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract long getTam();

    public void addElemento(Elemento e){

    }

    public int getNroElementos(){return 0;}

    public Elemento remove(int pos){
        return null;
    }

    public boolean remove(Elemento elem){
        return false;
    }
    public void moveCarpeta(Carpeta carpeta){
        if(ubicacion!=null){
            ubicacion.remove(this);
        }
        ubicacion=carpeta;
    }

    public String getRuta(){
        if(ubicacion==null){
            return "\\"+nombre;
        }
        return ubicacion.getRuta()+"\\"+nombre;
    }

    public String toString(){
        return toString("");
    }

    public String toString(String tab){

        return String.format("%s%s%n",tab,nombre);
    }

    /**
     * retorna todas las ocurrencias del elemento que coincide el nombre pasado por parámetro, dentro del arbol de carpetas (si es) o la ruta del archivo
     * @param nombre del archivo a buscar
     * @return una lista de String
     */
    public List<String> find(String nombre){
        ArrayList<String> out=new ArrayList<>();
        find(nombre, out);
        return out;
    }
    protected void find(String nombre, List<String> out){
        if(nombre.equals(this.nombre)){
            out.add(getRuta());
        }
    }

}
