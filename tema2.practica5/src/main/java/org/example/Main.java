package org.example;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        String urlConexion = "jdbc:postgresql://dbdavid.coocf3i553tv.us-east-1.rds.amazonaws.com:5432/a31433";
        String usuario = "postgres";
        String password = "PedroSanchez?";
        List<Casa> casas = new ArrayList<>();
        List<Estudiante> estudiantes = new ArrayList<>();
        List<Mascota> mascotas = new ArrayList<>();
        List<Asignatura> asignaturas = new ArrayList<>();
        List<Profesor> profesores = new ArrayList<>();
        List<Estudiante_Asignatura> estudianteAsignaturas = new ArrayList<>();



        try (Connection conexion = DriverManager.getConnection(urlConexion, usuario, password)) {
            try {

                conexion.setAutoCommit(false);

                String consultaSQL = "SELECT * FROM Casa ";
                PreparedStatement consulta = conexion.prepareStatement(consultaSQL);
                // Metemos como primer parámetro que la nacionalidad sea Española

                ResultSet resultados = consulta.executeQuery();

                while (resultados.next()) {
                    Casa casa = new Casa(
                            resultados.getInt("id_casa"),
                            resultados.getString("nombre_casa"),
                            resultados.getString("fundador"),
                            resultados.getString("jefe_casa"),
                            resultados.getString("fantasma")
                    );

                    casas.add(casa);
                }
            } catch (SQLException ex1) {
                System.err.println(ex1.getClass().getName() + ": " + ex1.getMessage());

            }

            try {

                conexion.setAutoCommit(false);

                String consultaSQL = "SELECT * FROM Estudiante ";
                PreparedStatement consulta = conexion.prepareStatement(consultaSQL);
                // Metemos como primer parámetro que la nacionalidad sea Española

                ResultSet resultados = consulta.executeQuery();

                while (resultados.next()) {
                    Estudiante estudiante = new Estudiante(
                            resultados.getInt("id_estudiante"),
                            resultados.getString("nombre"),
                            resultados.getString("apellido"),
                            resultados.getInt("id_casa"),
                            resultados.getInt("año_curso"),
                            resultados.getDate("fecha_nacimiento").toLocalDate()
                    );

                    estudiantes.add(estudiante);
                }
            } catch (SQLException ex1) {
                System.err.println(ex1.getClass().getName() + ": " + ex1.getMessage());

            }

            try {

                conexion.setAutoCommit(false);

                String consultaSQL = "SELECT * FROM Mascota ";
                PreparedStatement consulta = conexion.prepareStatement(consultaSQL);
                // Metemos como primer parámetro que la nacionalidad sea Española

                ResultSet resultados = consulta.executeQuery();

                while (resultados.next()) {
                    Mascota mascota = new Mascota(
                            resultados.getInt("id_mascota"),
                            resultados.getString("nombre_mascota"),
                            resultados.getString("especie"),
                            resultados.getInt("id_estudiante")
                    );

                    mascotas.add(mascota);
                }
            } catch (SQLException ex1) {
                System.err.println(ex1.getClass().getName() + ": " + ex1.getMessage());

            }

            try {

                conexion.setAutoCommit(false);

                String consultaSQL = "SELECT * FROM Asignatura ";
                PreparedStatement consulta = conexion.prepareStatement(consultaSQL);
                // Metemos como primer parámetro que la nacionalidad sea Española

                ResultSet resultados = consulta.executeQuery();

                while (resultados.next()) {
                    Asignatura asignatura = new Asignatura(
                            resultados.getInt("id_asignatura"),
                            resultados.getString("nombre_asignatura"),
                            resultados.getString("aula"),
                            resultados.getBoolean("obligatoria")
                    );

                    asignaturas.add(asignatura);

                }
            } catch (SQLException ex1) {
                System.err.println(ex1.getClass().getName() + ": " + ex1.getMessage());

            }

            try {

                conexion.setAutoCommit(false);

                String consultaSQL = "SELECT * FROM Profesor";
                PreparedStatement consulta = conexion.prepareStatement(consultaSQL);
                // Metemos como primer parámetro que la nacionalidad sea Española

                ResultSet resultados = consulta.executeQuery();

                while (resultados.next()) {
                    Profesor profesor = new Profesor(
                            resultados.getInt("id_profesor"),
                            resultados.getString("nombre"),
                            resultados.getString("apellido"),
                            resultados.getInt("id_asignatura"),
                            resultados.getDate("fecha_inicio").toLocalDate()
                    );

                    profesores.add(profesor);

                }
            } catch (SQLException ex1) {
                System.err.println(ex1.getClass().getName() + ": " + ex1.getMessage());

            }

            try {
                conexion.setAutoCommit(false);

                String consultaSQL = "SELECT * FROM Estudiante_Asignatura";
                PreparedStatement consulta = conexion.prepareStatement(consultaSQL);
                ResultSet resultados = consulta.executeQuery();

                while (resultados.next()) {
                    Estudiante_Asignatura ea = new Estudiante_Asignatura(
                            resultados.getInt("id_estudiante"),
                            resultados.getInt("id_asignatura"),
                            resultados.getFloat("calificacion")
                    );
                    estudianteAsignaturas.add(ea);
                }
            } catch (SQLException ex1) {
                System.err.println(ex1.getClass().getName() + ": " + ex1.getMessage());
            }
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {

            System.out.println("1. Consulta de estudiantes por casa (Gryffindor)");
            System.out.println("2. Listado de todas las asignaturas obligatorias");
            System.out.println("3. Obtener la mascota de un estudiante específico (Hermione Granger)");
            System.out.println("4. Listar estudiantes sin mascota");
            System.out.println("5. Promedio de calificaciones de un estudiante (Harry Potter)");
            System.out.println("6. Número de estudiantes por casa");
            System.out.println("7. Estudiantes matriculados en una asignatura específica (Defensa Contra las Artes Oscuras)");
            System.out.println("8. Insertar un nuevo estudiante");
            System.out.println("9. Modificar el aula de una asignatura");
            System.out.println("10. Desmatricular a un estudiante de una asignatura");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Consulta de estudiantes por casa (Gryffindor)");
                    mostrarEstudiantesDeCasa(casas, estudiantes, "Gryffindor");
                    break;
                case 2:
                    System.out.println("Listado de todas las asignaturas obligatorias");
                    System.out.println(getAsignaturasObligatorias(asignaturas));
                    break;
                case 3:
                    System.out.println("Obtener la mascota de un estudiante específico (Hermione Granger)");
                    System.out.println(getMascotaEstudiante(mascotas, estudiantes, "Hermione Granger"));
                    break;
                case 4:
                    System.out.println("Listar estudiantes sin mascota");
                    System.out.println(listarEstudiantesSinMascota(estudiantes,mascotas));
                    break;
                case 5:
                    System.out.println("Promedio de calificaciones de un estudiante (Harry Potter)");
                    float promedio = calcularPromedioCalificaciones(estudianteAsignaturas, "Harry Potter", estudiantes);
                    if (promedio != -1) {
                        System.out.println("El promedio de calificaciones de Harry Potter es: " + promedio);
                    }
                    break;
                case 6:
                    System.out.println("Número de estudiantes por casa");
                    contarEstudiantesPorCasa(casas, estudiantes);
                    break;
                case 7:
                    System.out.println("Estudiantes matriculados en una asignatura específica (Defensa Contra las Artes Oscuras)");

                    break;
                case 8:
                    System.out.println("Insertar un nuevo estudiante");
                    mostrarEstudiantesPorAsignatura(estudiantes, asignaturas, estudianteAsignaturas, "Defensa Contra las Artes Oscuras");
                    break;
                case 9:
                    System.out.println("Modificar el aula de una asignatura");
                    scanner.nextLine();  // Limpiar el buffer del scanner
                    System.out.print("Introduce el nombre de la asignatura: ");
                    String nombreAsignatura = scanner.nextLine();
                    System.out.print("Introduce el nuevo aula: ");
                    String nuevoAula = scanner.nextLine();

                    try (Connection conexion = DriverManager.getConnection(urlConexion, usuario, password)) {
                        try {
                            modificarAulaAsignatura(conexion, asignaturas, nombreAsignatura, nuevoAula);
                        } catch (SQLException e) {
                            System.out.println("Error al modificar el aula: " + e.getMessage());
                        }
                    } catch (SQLException ex) {
                        System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
                    }
                    break;

                case 10:
                    System.out.println("Desmatricular a un estudiante de una asignatura");

                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción del 0 al 10.");
                    break;
            }
            System.out.println();
        } while (opcion != 0);


    }

    public static void mostrarEstudiantesDeCasa(List<Casa> casas, List<Estudiante> estudiantes,String nCasa) {

        int idCasaSearch = -1;
        for (Casa casa : casas) {
            if (casa.getNombre_casa().equalsIgnoreCase(nCasa)) {
                idCasaSearch = casa.getId_casa();
                break;
            }
        }

        if (idCasaSearch != -1) {
            System.out.println("Estudiantes de la casa " + nCasa + ":");
            for (Estudiante estudiante : estudiantes) {
                if (estudiante.getId_casa() == idCasaSearch) {
                    System.out.println(estudiante.getNombre() + " " + estudiante.getApellido());
                }
            }
        } else {
            System.out.println("No se encontró la casa que has seleccionado.");
        }
    }

    public static List<Asignatura> getAsignaturasObligatorias(List<Asignatura> asignaturas) {
        List<Asignatura> asignaturasObligatorias = new ArrayList<>();
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.isObligatoria()) {
                asignaturasObligatorias.add(asignatura);
            }
        }
        return asignaturasObligatorias;
    }

    public static Mascota getMascotaEstudiante(List<Mascota> mascotas, List<Estudiante> estudiantes , String NameEstudiante) {
       int idEstudiante = -1;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombre().equalsIgnoreCase(NameEstudiante)) {
                idEstudiante = estudiante.getId_estudiante();
                break;
            }
        }

        if(idEstudiante == -1){
            return null;
        }else{
            for (Mascota mascota : mascotas) {
                if (mascota.getId_estudiante() == idEstudiante) {
                    return mascota;
                }
            }
        }
        return null;
    }

    public static List<Estudiante> listarEstudiantesSinMascota(List<Estudiante> estudiantes, List<Mascota> mascotas) {
        List<Estudiante> estudiantesSinMascota = new ArrayList<>();

        for (Estudiante estudiante : estudiantes) {
            boolean tieneMascota = false;
            for (Mascota mascota : mascotas) {
                if (mascota.getId_estudiante() == estudiante.getId_estudiante()) {
                    tieneMascota = true;
                    break;
                }
            }
            if (!tieneMascota) {
                estudiantesSinMascota.add(estudiante);
            }
        }
        return estudiantesSinMascota;
    }
    public static void contarEstudiantesPorCasa(List<Casa> casas, List<Estudiante> estudiantes) {

        for (Casa casa : casas) {
            int contador = 0;

            for (Estudiante estudiante : estudiantes) {
                if (estudiante.getId_casa() == casa.getId_casa()) {
                    contador++;
                }
            }

            System.out.println("Casa " + casa.getNombre_casa() + ": " + contador + " estudiante(s)");
        }
    }

    public static float calcularPromedioCalificaciones(List<Estudiante_Asignatura> estudianteAsignaturas, String nombreEstudiante, List<Estudiante> estudiantes) {
        int idEstudiante = -1;


        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombre().equalsIgnoreCase(nombreEstudiante)) {
                idEstudiante = estudiante.getId_estudiante();
                break;
            }
        }

        if (idEstudiante == -1) {
            System.out.println("No se encontró al estudiante con nombre: " + nombreEstudiante);
            return -1;
        }

        float sumaCalificaciones = 0;
        int totalAsignaturas = 0;

        for (Estudiante_Asignatura ea : estudianteAsignaturas) {
            if (ea.getId_estudiante() == idEstudiante) {
                sumaCalificaciones += ea.getCalificacion();
                totalAsignaturas++;
            }
        }

        if (totalAsignaturas == 0) {
            System.out.println("El estudiante no tiene calificaciones registradas.");
            return -1;
        }

        return sumaCalificaciones / totalAsignaturas;
    }

    public static void mostrarEstudiantesPorAsignatura(List<Estudiante> estudiantes, List<Asignatura> asignaturas, List<Estudiante_Asignatura> estudianteAsignaturas, String nombreAsignatura) {
        int idAsignatura = 0;

        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getNombre_asignatura().equalsIgnoreCase(nombreAsignatura)) {
                idAsignatura = asignatura.getId_asignatura();
                break;
            }
        }

        System.out.println("Estudiantes matriculados en la asignatura " + nombreAsignatura + ":");
        for (Estudiante_Asignatura ea : estudianteAsignaturas) {
            if (ea.getId_asignatura() == idAsignatura) {
                for (Estudiante estudiante : estudiantes) {
                    if (estudiante.getId_estudiante() == ea.getId_estudiante()) {
                        System.out.println(estudiante.getNombre() + " " + estudiante.getApellido());
                        break;
                    }
                }
            }
        }
    }

    public static void modificarAulaAsignatura(Connection conexion, List<Asignatura> asignaturas, String nombreAsignatura, String nuevoAula) throws SQLException {
        int idAsignatura = 0;

        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getNombre_asignatura().equalsIgnoreCase(nombreAsignatura)) {
                idAsignatura = asignatura.getId_asignatura();
                break;
            }
        }

        String updateSQL = "UPDATE Asignatura SET aula = ? WHERE id_asignatura = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(updateSQL)) {
            preparedStatement.setString(1, nuevoAula);
            preparedStatement.setInt(2, idAsignatura);

            int filasActualizadas = preparedStatement.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("El aula de la asignatura " + nombreAsignatura + " ha sido actualizada a " + nuevoAula);

                for (Asignatura asignatura : asignaturas) {
                    if (asignatura.getId_asignatura() == idAsignatura) {
                        asignatura.setAula(nuevoAula);
                        break;
                    }
                }
            } else {
                System.out.println("No se pudo actualizar el aula.");
            }
        } catch (SQLException ex) {
            System.err.println("Error al actualizar el aula: " + ex.getMessage());
            conexion.rollback();
        }
    }


}