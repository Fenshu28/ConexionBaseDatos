/** **********************************************
 * Autores: Cristopher Alexis Zarate Valencia  *
 * Fecha de creación: 1 nov. 2023                *
 * Descripción: Clase para crear una conexión.
 *********************************************** */
package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    private boolean existBd = false;
    private boolean existTable = false;
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public Conexion() {

    }

    private void conect(String base) {
        try {

            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/" + base,
                    "postgres", "Leli1505/");

            if (con != null) {
                System.out.println("conexión exitosa.");
                st = con.createStatement();
            }
        } catch (Exception ex) {
            System.out.println("Error al conectar: " + ex.getMessage());
        }
    }

    private void disconect() {
        try {
            if (!con.isClosed()) {
                con.close();
            }
            if (!st.isClosed()) {
                st.close();
            }

        } catch (SQLException ex) {
            System.out.println("Error al desconectar: " + ex.getMessage());
        }
    }

    public void crearBase(String baseName) {
        try {
            conect("");
            
            if (!baseExist(baseName)) {
                st.execute("create database " + baseName);
            }
            
            disconect();
        } catch (SQLException ex) {
            System.out.println("Error al crear la base de datos: " + ex.getMessage());
        }

    }

    private boolean baseExist(String bdName) {
        String consulta = "SELECT 1 FROM pg_database WHERE datname = '" + bdName + "'";

        conect("");

        try {
            existBd = st.execute(consulta);
        } catch (SQLException ex) {
            System.out.println("Error al consultar si existe la base de datos: "
                    + ex.getMessage());
        }
        return existBd;
    }

//    private boolean tableExist(DatabaseMetaData metaData, String tableName) throws SQLException {
//        try (var rs = metaData.getTables(null, null, tableName, null)) {
//            return rs.next();
//        }
//    }
}
