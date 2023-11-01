/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package all;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConeccionBase {
    
    public static void main(String[] args) {
//        ConeccionBase c = new ConeccionBase();
//        String st = c.pedirDatos();         
        String st = "select * from m506";

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/prueba1","postgres","Leli1505/");
            
            if(con != null){
                System.out.println("coneccion exitosa");
                Statement s = con.createStatement();
                
                ResultSet rs = s.executeQuery(st);
                
                while (rs.next()) {                    
                    System.out.println("Nombre: " + rs.getString(2));
                }
                
                
                
            }            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            
        }
    }
    
    
    private String pedirDatos(){
        String st = "";
        String cons = "insert into m506 (nombre,matricula,carreta) values (";
        
        do{
            st = JOptionPane.showInputDialog(null, "Ingresa el nombre: ","");
        }while(st.isEmpty());
        cons += "'"+st+"',";
        do{
            st = JOptionPane.showInputDialog(null, "Ingresa la matricula: ","");
        }while(st.isEmpty());
        cons += "'"+st+"',";
        do{
            st = JOptionPane.showInputDialog(null, "Ingresa la carrera: ","");
        }while(st.isEmpty());
        cons += "'"+st+"')";
        
        
        return cons;        
    }
}
