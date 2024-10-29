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
            String consultaSQL = "SELECT estudiantes.nombre_completo FROM estudiantes LEFT JOIN mascotas ON estudiantes.id = mascotas.estudiante_id WHERE mascotas.id IS NULL;";
            PreparedStatement consulta = Conexion.prepareStatement(consultaSQL);

            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {

                String nombre = resultados.getString("nombre_completo");

                System.out.println("Nombre : " + nombre);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void consultaPromedioNotasPorEstudiante(Connection Conexion) {
        try {
            Conexion.setAutoCommit(false);
            String consultaSQL = "SELECT estudiantes.nombre_completo, AVG(calificaciones.nota) AS promedio FROM estudiantes JOIN calificaciones ON estudiantes.id = calificaciones.estudiante_id GROUP BY estudiantes.nombre_completo;";
            PreparedStatement consulta = Conexion.prepareStatement(consultaSQL);

            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {

                String nombre = resultados.getString("nombre_completo");
                double promedio = resultados.getDouble("promedio");
                System.out.println("Nombre : " + nombre + " Promedio: " + promedio);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void consultaEstudiantesQuintoAnoPorCasa(Connection Conexion) {
        try {
            Conexion.setAutoCommit(false);
            String consultaSQL = "SELECT casas.nombre, COUNT(estudiantes.id) AS num_estudiantes FROM estudiantes JOIN casas ON estudiantes.casa_id = casas.id WHERE estudiantes.año = 5 GROUP BY casas.nombre;";
            PreparedStatement consulta = Conexion.prepareStatement(consultaSQL);

            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {

                String nombre = resultados.getString("nombre");
                int numEstudiantes = resultados.getInt("num_estudiantes");
                System.out.println("Casa: " + nombre + " Num. Estudiantes: " + numEstudiantes);

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
            String consultaSQL = "SELECT estudiantes.nombre_completo, calificaciones.nota FROM estudiantes JOIN calificaciones ON estudiantes.id = calificaciones.estudiante_id JOIN asignaturas ON calificaciones.asignatura_id = asignaturas.id WHERE asignaturas.nombre =" + asignatura +  " ORDER BY calificaciones.nota DESC LIMIT 1;";
            PreparedStatement consulta = Conexion.prepareStatement(consultaSQL);

            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {

                String nombre = resultados.getString("nombre_completo");
                double nota = resultados.getDouble("nota");
                System.out.println("Nombre : " + nombre + " Nota: " + nota);

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
            String consultaSQL = "SELECT casas.nombre, AVG(calificaciones.nota) AS promedio FROM calificaciones JOIN estudiantes ON calificaciones.estudiante_id = estudiantes.id JOIN casas ON estudiantes.casa_id = casas.id JOIN asignaturas ON calificaciones.asignatura_id = asignaturas.id WHERE asignaturas.nombre =" +asignatura +"GROUP BY casas.nombre;";
            PreparedStatement consulta = Conexion.prepareStatement(consultaSQL);

            ResultSet resultados = consulta.executeQuery();

            while (resultados.next()) {

                String nombre = resultados.getString("nombre");
                double promedio = resultados.getDouble("promedio");
                System.out.println("Casa: " + nombre + " Promedio: " + promedio);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void incrementarCalificacionesUltimoAno(Connection Conexion) {
        try {
            Conexion.setAutoCommit(false);
            String consultaSQL = "UPDATE calificaciones SET nota = nota * 1.1 WHERE estudiante_id IN ( SELECT id FROM estudiantes WHERE año = (SELECT MAX(año) FROM estudiantes));";
            try {

                PreparedStatement consulta = Conexion.prepareStatement(consultaSQL);
                int rowsUpdate = consulta.executeUpdate();

                System.out.println("Se han actualizado " + rowsUpdate + " registros");
            } catch (Exception e) {

                try {
                    // Deshacemos las operaciones realizadas en la base de datos
                    Conexion.rollback();
                    System.err.println("ROLLBACK ejecutado");
                } catch (SQLException ex2) {
                    System.err.println("Error haciendo ROLLBACK");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void desmatricularEstudiantesOptativas(Connection Conexion) {
        try {
            Conexion.setAutoCommit(false);
            String consultaSQL = "DELETE FROM calificaciones WHERE asignatura_id IN (SELECT id FROM asignaturas WHERE tipo = 'Optativa') AND nota < 5;";
            try {

                PreparedStatement consulta = Conexion.prepareStatement(consultaSQL);
                int rowsUpdate = consulta.executeUpdate();

                System.out.println("Se han actualizado " + rowsUpdate + " registros");
            } catch (Exception e) {
                try {
                    // Deshacemos las operaciones realizadas en la base de datos
                    Conexion.rollback();
                    System.err.println("ROLLBACK ejecutado");
                } catch (SQLException ex2) {
                    System.err.println("Error haciendo ROLLBACK");
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
