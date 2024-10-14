package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JSONManager {

    public static ProtectoraDeAnimales cargarDesdeArchivo(String archivo) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File(archivo);
            System.out.println("Verificando archivo: " + file.getAbsolutePath());
            if (file.exists()) {
                ProtectoraDeAnimalesRoot root = objectMapper.readValue(file, ProtectoraDeAnimalesRoot.class);
                return root.getProtectoraDeAnimales();
            } else {
                System.out.println("El archivo no existe.");
                return new ProtectoraDeAnimales();
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
            return new ProtectoraDeAnimales();
        }
    }

    public static void guardarEnArchivo(ProtectoraDeAnimales protectora, String archivo) {
        ObjectMapper objectMapper = new ObjectMapper();
        ProtectoraDeAnimalesRoot root = new ProtectoraDeAnimalesRoot();
        root.setProtectoraDeAnimales(protectora);

        try {
            objectMapper.writeValue(new File(archivo), root);
            System.out.println("Datos guardados en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo " + e.getMessage());
        }
    }
}
