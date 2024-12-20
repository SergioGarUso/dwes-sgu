import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

@JacksonXmlRootElement(localName = "protectoraDeAnimales")
public class ProtectoraDeAnimales {

    @JacksonXmlElementWrapper(localName = "animales", useWrapping = true)
    @JacksonXmlProperty(localName = "animal")
    private List<Animal> animales;

    public ProtectoraDeAnimales() {
        this.animales = new ArrayList<>();
    }

    public void addAnimal(Scanner scanner) {
        Animal nuevoAnimal = new Animal();
        System.out.print("ID: ");
        nuevoAnimal.setId(scanner.nextLine());
        System.out.print("Nombre: ");
        nuevoAnimal.setNombre(scanner.nextLine());
        System.out.print("Especie: ");
        nuevoAnimal.setEspecie(scanner.nextLine());
        System.out.print("Edad: ");
        nuevoAnimal.setEdad(scanner.nextInt());
        scanner.nextLine(); // limpiar buffer
        System.out.print("Sexo: ");
        nuevoAnimal.setSexo(scanner.nextLine());
        System.out.print("Fecha de ingreso (YYYY-MM-DD): ");
        nuevoAnimal.setFechaIngreso(scanner.nextLine());
        System.out.print("Adoptado (True/False): ");
        nuevoAnimal.setAdoptado(scanner.nextBoolean());

        animales.add(nuevoAnimal);
        System.out.println("Animal añadido.");

    }

    public void removeAnimal(Scanner scanner) {
        System.out.print("Introduce el ID del animal a borrar: ");
        String id = scanner.nextLine();

        Iterator<Animal> it = animales.iterator();
        boolean deleted = false;

        while (it.hasNext()) {
            Animal animal = it.next();
            if (animal.getId().equals(id)) {
                it.remove();
                deleted = true;
                System.out.println("Animal con ID " + id + " borrado.");
                break;
            }
        }

        if (!deleted) {
            System.out.println("Animal no encontrado.");
        }
    }


    public void consultarAnimal(Scanner scanner) {
        System.out.print("Introduce el ID del animal para buscarlo: ");
        String id = scanner.nextLine();

        for (Animal animal : animales) {
            if (animal.getId().equals(id)) {
                System.out.println(animal);
            } else {
                System.out.println("Animal no encontrado.");
            }
        }
    }

    public void mostrarTodosAnimales() {
        if (animales.isEmpty()) {
            System.out.println("No hay animales en la protectora.");
        } else {
            for (Animal animal : animales) {
                System.out.println(animal);
            }
        }
    }
}