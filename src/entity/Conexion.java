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

    public Conexion(String bdName, String tableName) {
        if (baseExist(bdName)) {
            tableExist(tableName);
        }
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
            if (ex.getMessage().contains("no existe")) {
                return false;
            } else {
                System.out.println("Error al conectar: " + ex.getMessage());
            }
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
        existBd = conect(bdName);
        if (existBd) {
            this.bdName = bdName;
            disconect();
        }
        return existBd;
    }

    private boolean tableExist(String tableName) {
        DatabaseMetaData metaData = null;
        try {
            if (con != null || con.isClosed()) {
                conect(bdName);
            }
            metaData = con.getMetaData();
        } catch (SQLException ex) {
            System.out.println("Error con el metaData.");
        }

        try (var rs = metaData.getTables(null, null, tableName, null)) {
            existTable = rs.next();
            return existTable;
        } catch (SQLException ex) {
            System.out.println("Error con el metadate next o no se encontro"
                    + "la tabla.");
        }

        disconect();

        return false;
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

    public void crearRegistro(Alumno a) {
        String sqlQuery = "insert into m506 (matricula,nombre,carreta)"
                + " values ('" + a.getMatricula() + "','" + a.getNombre()
                + "','" + a.getCarrera() + "')";
        conect(bdName);
        try {

            st.execute(sqlQuery);
            disconect();
        } catch (SQLException ex) {
            System.out.println("Error al insetar.");
        }
    }

    public void actualizarRegistro(int id, Alumno... a) {
        String sqlQuery = "insert into m506 (matricula,nombre,carreta)"
                + " values ('" + a[0].getMatricula() + "','" + a[0].getNombre()
                + "','" + a[0].getCarrera() + "')";
        conect(bdName);
        try {

            st.executeUpdate(sqlQuery);
            disconect();
        } catch (SQLException ex) {
            System.out.println("Error al insetar.");
        }
    }

    public Alumno consultarRegistro(int id) {
        String sqlQuery = "SELECT * FROM alumno WHERE matricula = '" + id + "'";
        
        Alumno aTemp = null;
        
        conect(bdName);
        try {

            rs = st.executeQuery(sqlQuery);
            aTemp = new Alumno(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
            disconect();
        } catch (SQLException ex) {
            System.out.println("Error al consultar.");
        }
        
        return aTemp;

    }
}
