import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ProtectoraDeAnimales protectora = new ProtectoraDeAnimales();
        String archivoXML = "";

        protectora = XMLManager.cargarDesdeArchivo(archivoXML);

        boolean continuar = true;

        while (continuar) {
            System.out.println("1. Cargar información de fichero XML");
            System.out.println("2. Guardar información en fichero XML");
            System.out.println("3. Añadir animal");
            System.out.println("4. Borrar animal");
            System.out.println("5. Consultar animal");
            System.out.println("6. Mostrar todos los animales");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");

            int opcion = in.nextInt();
            in.nextLine();

            switch (opcion) {
                case 1:
                    protectora = XMLManager.cargarDesdeArchivo(archivoXML);
                    System.out.println("Datos cargados del fichero XML.");
                    break;
                case 2:
                    XMLManager.guardarEnArchivo(protectora, archivoXML);
                    System.out.println("Datos guardados en el fichero XML.");
                    break;
                case 3: // Añadir animal
                    protectora.addAnimal(in);
                    XMLManager.guardarEnArchivo(protectora, archivoXML);
                    System.out.println("Animal añadido y datos guardados.");
                    break;
                case 4: // Borrar animal
                    protectora.removeAnimal(in);
                    XMLManager.guardarEnArchivo(protectora, archivoXML);
                    System.out.println("Animal eliminado y datos guardados.");
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
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }

        in.close();
    }
}
