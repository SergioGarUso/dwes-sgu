package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ProtectoraDeAnimales protectora = new ProtectoraDeAnimales();
        String archivoJSON = "/home/sergaruso/IdeaProjects/dwes-sgu/tema2.practica3/src/main/resources/Animales.json";

        protectora = JSONManager.cargarDesdeArchivo(archivoJSON);

        boolean continuar = true;

        while (continuar) {
            System.out.println("1 Cargar información de fichero JSON");
            System.out.println("2 Guardar información en fichero JSON");
            System.out.println("3 Añadir animal");
            System.out.println("4 Borrar animal");
            System.out.println("5 Consultar animal");
            System.out.println("6 Mostrar todos los animales");
            System.out.println("7 Salir");
            System.out.print("Elige una opción: ");

            int opcion = in.nextInt();
            in.nextLine();

            switch (opcion) {
                case 1:
                    protectora = JSONManager.cargarDesdeArchivo(archivoJSON);
                    System.out.println("Datos cargados del JSON.");
                    break;
                case 2:
                    JSONManager.guardarEnArchivo(protectora, archivoJSON);
                    System.out.println("Datos guardados en el JSON.");
                    break;
                case 3:
                    protectora.addAnimal(in);
                    JSONManager.guardarEnArchivo(protectora, archivoJSON);
                    System.out.println("Animal añadido y guardados.");
                    break;
                case 4:
                    protectora.removeAnimal(in);
                    JSONManager.guardarEnArchivo(protectora, archivoJSON);
                    System.out.println("Animal eliminado y guardados.");
                    break;
                case 5:
                    protectora.consultarAnimal(in);
                    break;
                case 6:
                    protectora.mostrarTodosLosAnimales();
                    break;
                case 7:
                    continuar = false;
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        in.close();
    }
}
