package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Funciones {

    public static void consultaEstudiantesYCasas(Connection Conexion) {
        try {
            Conexion.setAutoCommit(false);
            String consultaSQL = "SELECT nombre, apellido, nombre_casa FROM estudiante, casa WHERE estudiante.id_casa = casa.id_casa";
            PreparedStatement consulta = Conexion.prepareStatement(consultaSQL);

            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {

                String nombre = resultados.getString("nombre");
                String apellido = resultados.getString("apellido");
                String nombreCasa = resultados.getString("nombre_casa");

                System.out.println("Nombre Completo: " + nombre + apellido + " Casa: " + nombreCasa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void consultaEstudiantesYMascotasIncluidos(Connection Conexion) {
        try {
            Conexion.setAutoCommit(false);
            String consultaSQL = "SELECT estudiantes.nombre_completo, mascotas.nombre AS mascota FROM estudiantes LEFT JOIN mascotas ON estudiantes.id = mascotas.estudiante_id";
            PreparedStatement consulta = Conexion.prepareStatement(consultaSQL);

            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {

                String nombre = resultados.getString("nombre_completo");
                String mascota = resultados.getString("mascota");
                if (mascota == null) {
                    System.out.println("Nombre : " + nombre );
                } else {
                    System.out.println("Nombre : " + nombre + " Mascota: " + mascota);
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void consultaEstudiantesConMascotas(Connection Conexion) {
        try {
            Conexion.setAutoCommit(false);
            String consultaSQL = "SELECT estudiantes.nombre_completo, mascotas.nombre AS mascota FROM estudiantes JOIN mascotas ON estudiantes.id = mascotas.estudiante_id";
            PreparedStatement consulta = Conexion.prepareStatement(consultaSQL);

            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {

                String nombre = resultados.getString("nombre_completo");
                String mascota = resultados.getString("mascota");
                if (mascota != null) {
                    System.out.println("Nombre : " + nombre + " Mascota: " + mascota);
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void consultaEstudiantesSinMascotas(Connection Conexion) {
        try {
            Conexion.setAutoCommit(false);
            String consultaSQL = "";
            PreparedStatement consulta = Conexion.prepareStatement(consultaSQL);

            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void consultaPromedioNotasPorEstudiante(Connection Conexion) {
        try {
            Conexion.setAutoCommit(false);
            String consultaSQL = "";
            PreparedStatement consulta = Conexion.prepareStatement(consultaSQL);

            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void consultaEstudiantesQuintoAnoPorCasa(Connection Conexion) {
        try {
            Conexion.setAutoCommit(false);
            String consultaSQL = "";
            PreparedStatement consulta = Conexion.prepareStatement(consultaSQL);

            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void consultaMejorCalificacionEnAsignatura(Connection Conexion, Scanner scanner) {
        System.out.print("Ingrese el nombre de la asignatura: ");
        String asignatura = scanner.nextLine();
        try {
            Conexion.setAutoCommit(false);
            String consultaSQL = "";
            PreparedStatement consulta = Conexion.prepareStatement(consultaSQL);

            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void consultaPromedioCalificacionesEnAsignaturaPorCasa(Connection Conexion, Scanner scanner) {
        System.out.print("Ingrese el nombre de la asignatura: ");
        String asignatura = scanner.nextLine();
        try {
            Conexion.setAutoCommit(false);
            String consultaSQL = "";
            PreparedStatement consulta = Conexion.prepareStatement(consultaSQL);

            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void incrementarCalificacionesUltimoAno(Connection Conexion) {
        try {
            Conexion.setAutoCommit(false);
            String consultaSQL = "";
            PreparedStatement consulta = Conexion.prepareStatement(consultaSQL);

            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void desmatricularEstudiantesOptativas(Connection Conexion) {
        try {
            Conexion.setAutoCommit(false);
            String consultaSQL = "";
            PreparedStatement consulta = Conexion.prepareStatement(consultaSQL);

            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
