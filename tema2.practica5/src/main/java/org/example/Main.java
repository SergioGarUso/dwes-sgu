package org.example;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        String urlConexion = "jdbc:postgresql://dbdavid.coocf3i553tv.us-east-1.rds.amazonaws.com:5432/a31433";
        String usuario = "postgres";
        String password = "PedroSanchez?";
        List<Casa> casas = new ArrayList<>();
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
                try {
                    // Deshacemos las operaciones realizadas en la base de datos
                    conexion.rollback();
                    System.err.println("ROLLBACK ejecutado");
                } catch (SQLException ex2) {
                    System.err.println("Error haciendo ROLLBACK");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }

        for(Casa casa: casas){
            System.out.println(casa);
        }
    }
}