package org.example;

import java.sql.*;
import java.util.Scanner;

import org.example.Funciones;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String urlConexion = "jdbc:postgresql://dbdavid.coocf3i553tv.us-east-1.rds.amazonaws.com:5432/a31433";
        String usuario = "postgres";
        String password = "PedroSanchez?";
        Scanner scanner = new Scanner(System.in);
        try (Connection conexion = DriverManager.getConnection(urlConexion, usuario, password)) {
            boolean exit = false;

            while (!exit) {
                System.out.println("\n --- Menú de Consultas SQL ---");
                System.out.println("1. Consulta de estudiantes y sus casas");
                System.out.println("2. Consulta de estudiantes y sus mascotas (incluye los que no tienen)");
                System.out.println("3. Consulta de estudiantes y sus mascotas (solo estudiantes con mascotas)");
                System.out.println("4. Consulta de estudiantes sin mascotas");
                System.out.println("5. Notas promedio por estudiante");
                System.out.println("6. Número de estudiantes en quinto año por casa");
                System.out.println("7. Consulta de la mejor calificación en una asignatura específica");
                System.out.println("8. Promedio de calificaciones en una asignatura para una casa");
                System.out.println("9. Incremento de calificaciones en un 10% para estudiantes en su último año");
                System.out.println("10. Desmatricular estudiantes de asignaturas optativas con calificación menor a 5");
                System.out.println("11. Salir");
                System.out.print("Seleccione una opción: ");

                int option = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (option) {
                    case 1:
                        Funciones.consultaEstudiantesYCasas(conexion);
                        break;
                    case 2:
                        Funciones.consultaEstudiantesYMascotasIncluidos(conexion);
                        break;
                    case 3:
                        Funciones.consultaEstudiantesConMascotas(conexion);
                        break;
                    case 4:
                        Funciones.consultaEstudiantesSinMascotas(conexion);
                        break;
                    case 5:
                        Funciones.consultaPromedioNotasPorEstudiante(conexion);
                        break;
                    case 6:
                        Funciones.consultaEstudiantesQuintoAnoPorCasa(conexion);
                        break;
                    case 7:
                        Funciones.consultaMejorCalificacionEnAsignatura(conexion,scanner);
                        break;
                    case 8:
                        Funciones.consultaPromedioCalificacionesEnAsignaturaPorCasa(conexion,scanner);
                        break;
                    case 9:
                        Funciones.incrementarCalificacionesUltimoAno(conexion);
                        break;
                    case 10:
                        Funciones.desmatricularEstudiantesOptativas(conexion);
                        break;
                    case 11:
                        System.out.println("Saliendo del programa...");
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
                System.out.println("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
