/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;
import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author lucho
 */
public class cconexion {
    Connection conectar=null;
    
    String usuario="root";
    String contrasenia="";
    String bd="super_express";
    String ip="localhost";
    String puerto="3306";
    
    String cadena ="jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection estableceConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar= DriverManager.getConnection(cadena,usuario,contrasenia);
            //JOptionPane.showMessageDialog(null, "Se conecto");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se conecto: " + e.toString());
        }
        
        return conectar;
    }
    
}
