import java.util.List;

public class Test {
    public static void main(String[] args) {
        Archivo[] archivos=new Archivo[4];
        archivos[0]=new Archivo("Control1.doc", 10);
        archivos[1]=new Archivo("Control2.doc", 10);
        archivos[2]=new Archivo("Control1.doc", 10);
        archivos[3]=new Archivo("Control2.doc", 10);
        Archivo rubrica=new Archivo("Rubrica.doc", 10);


        Carpeta controles=new Carpeta("Controles", 100);
        Carpeta controles2023_1=new Carpeta("Controles2023-1", 100);
        Carpeta controles2023_2=new Carpeta("Controles2023-2", 100);

        controles.addElemento(controles2023_1);
        controles.addElemento(controles2023_2);
        controles.addElemento(rubrica);

        controles2023_1.addElemento(archivos[0]);
        controles2023_1.addElemento(archivos[1]);
        controles2023_2.addElemento(archivos[2]);
        controles2023_2.addElemento(archivos[3]);

        System.out.println("Directorio completo:");
        System.out.println(controles);

        System.out.println("ruta de los controles:");
        for (int i = 0; i < archivos.length; i++) {
            Archivo archivo = archivos[i];
            System.out.println(archivo.getRuta());
        }

        System.out.println("\nListado de ubicaciones donde está el archivo 'Control1.doc'");
        List<String> rutas=controles.find("Control1.doc");
        for (String ruta : rutas) {
            System.out.println(ruta);
        }
    }
}
