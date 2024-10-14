import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class XMLManager {


        public static ProtectoraDeAnimales cargarDesdeArchivo(String archivo) {
            XmlMapper xmlMapper = new XmlMapper();
            try {
                File file = new File(archivo);
                System.out.println("Verificando archivo: " + file.getAbsolutePath());
                if (file.exists()) {
                    return xmlMapper.readValue(file, ProtectoraDeAnimales.class);
                } else {
                    System.out.println("El archivo no existe. Se devolverá una nueva ProtectoraDeAnimales vacía.");
                    return new ProtectoraDeAnimales();
                }
            } catch (IOException e) {
                System.out.println("Error al cargar el archivo: " + e.getMessage());
                return new ProtectoraDeAnimales();
            }
        }



    public static void guardarEnArchivo(ProtectoraDeAnimales protectora, String archivo) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File(archivo), protectora);
            System.out.println("Datos guardados en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}
