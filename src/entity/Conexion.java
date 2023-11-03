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
    private Connection con = null;
    private Statement st;
    private ResultSet rs;
    private String bdName;
    private String tableName;

    public Conexion() {

    }

    public boolean isExistBd() {
        return existBd;
    }

    public boolean isExistTable() {
        return existTable;
    }

    private boolean conect(String base) {
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
            if(ex.getMessage().contains("no existe"))
                return  false;
            else
                System.out.println("Error al conectar: " + ex.getMessage());
        }
        return true;
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

    private boolean baseExist(String bdName) {
        existBd=conect(bdName);
        if(existBd)
            disconect();
        return existBd;
    }

    private boolean tableExist(String tableName) throws SQLException {
        conect(bdName);
        DatabaseMetaData metaData = con.getMetaData();
        disconect();
        try (var rs = metaData.getTables(null, null, tableName, null)) {
            existTable = rs.next();
            return existTable;
        }
    }

    public void crearBase(String baseName) {
        try {

            if (!baseExist(baseName)) {
                conect("");
                st.execute("create database " + baseName);
                disconect();
            }

            bdName = baseName;
        } catch (SQLException ex) {
            System.out.println("Error al crear la base de datos: " + ex.getMessage());
        }
    }

    public void crearTabla(String nombreT) {
        try {
            conect(bdName);

            if (!tableExist(nombreT)) {
                st.execute("create table " + nombreT
                        + " (matricula varchar(11) PRIMARY KEY,"
                        + "nombre varchar(30),"
                        + "carrera varchar(11))");
            }

            disconect();

            tableName = nombreT;
        } catch (SQLException ex) {
            System.out.println("Error al crear la tabla " + nombreT
                    + ": " + ex.getMessage());
        }
    }

}
