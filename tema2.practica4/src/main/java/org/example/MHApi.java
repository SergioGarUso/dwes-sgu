package org.example;

import java.util.Scanner;

public class MHApi {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("¡Cazador abre tu libro de bestiario!");

        boolean continuar = true;
        while (continuar) {
            System.out.println("1-Consultar Monstruos por ID");
            System.out.println("2-Salir");
            int opcion = in.nextInt();

            in.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Escribe la id del 1 al :");
                    String name = in.nextLine();

                    Monstruo monstruo = MHData.getMonstruoName(name);

                    if (monstruo != null) {
                        System.out.println(monstruo);
                    } else {
                        System.out.println("No existe el monstruo tal vez sea un nuevo ejemplar.");
                    }
                    break;

                case 2:
                    System.out.println("Cerrando el libro");
                    continuar = false;
                    break;

                default:
                    System.out.println("No sabes que hace??");
                    break;
            }
        }

        in.close();
    }
}
