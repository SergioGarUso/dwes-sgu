import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ProtectoraDeAnimales protectora = new ProtectoraDeAnimales();
        String archivoXML = "/home/sergaruso/IdeaProjects/dwes-sgu/tema2.practica2/src/main/resources/Animales.xml";

        protectora = XMLManager.cargarDesdeArchivo(archivoXML);

        boolean continuar = true;

        while (continuar) {
            System.out.println("1 Carga información de fichero XML");
            System.out.println("2 Guarda información en fichero XML");
            System.out.println("3 Añade animal");
            System.out.println("4 Borra animal");
            System.out.println("5 Consulta animal");
            System.out.println("6 Muestra todos los animales");
            System.out.println("7 Salir");
            System.out.print("Elige una opción: ");

            int opt = in.nextInt();
            in.nextLine();

            switch (opt) {
                case 1:
                    protectora = XMLManager.cargarDesdeArchivo(archivoXML);
                    System.out.println("Datos cargados del XML.");
                    break;
                case 2:
                    XMLManager.guardarEnArchivo(protectora, archivoXML);
                    System.out.println("Datos guardados en el XML.");
                    break;
                case 3: // Añadir animal
                    protectora.addAnimal(in);
                    XMLManager.guardarEnArchivo(protectora, archivoXML);
                    System.out.println("Animal añadido y guardado.");
                    break;
                case 4: // Borrar animal
                    protectora.removeAnimal(in);
                    XMLManager.guardarEnArchivo(protectora, archivoXML);
                    System.out.println("Animal eliminado y guardado.");
                    break;
                case 5:
                    protectora.consultarAnimal(in);
                    break;
                case 6:
                    protectora.mostrarTodosAnimales();
                    break;
                case 7:
                    continuar = false;
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }

        in.close();
    }
}
