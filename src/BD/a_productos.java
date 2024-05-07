/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import java.io.File;
import java.io.FileInputStream;
import javax.swing.JTextField;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lucho
 */
public class a_productos {

    ArrayList<String> nombres = new ArrayList<>();
    ArrayList<String> descripciones = new ArrayList<>();
    ArrayList<Integer> cantidades = new ArrayList<>();
    ArrayList<Integer> codigos = new ArrayList<>();
    ArrayList<String> etiquetas = new ArrayList<>();

    public ArrayList<String> getNombres() {
        return nombres;
    }

    public ArrayList<String> getDescripciones() {
        return descripciones;
    }

    public ArrayList<Integer> getCantidades() {
        return cantidades;
    }

    public ArrayList<Integer> getCodigos() {
        return codigos;
    }

    public ArrayList<String> getEtiquetas() {
        return etiquetas;
    }

    public void agregarProducto(String nombre, String descripcion, int cantidad, int cod, String etiqueta, File foto) {
        cconexion objetoConexion = new cconexion();

        String consulta = "insert into productos (Nombre,Descripcion,Cantidad,Codigobarras,Etiqueta,Foto,Disponible) values(?,?,?,?,?,?,?);";

        try {
            FileInputStream fis = new FileInputStream(foto);
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);

            cs.setString(1, nombre);
            cs.setString(2, descripcion);
            cs.setInt(3, cantidad);
            cs.setInt(4, cod);
            cs.setString(5, etiqueta);
            cs.setBinaryStream(6, fis, (int) foto.length());
            cs.setInt(7, 1);

            cs.execute();

            JOptionPane.showMessageDialog(null, "Registro ingresado");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR :" + e.toString() + " HOLAAA");
        }

    }
    
    
    public boolean val_codigo(String codigo){
        nombres.clear();
        descripciones.clear();
        cantidades.clear();
        codigos.clear();
        etiquetas.clear();
        cconexion objetoConexion = new cconexion();
        String consulta = "SELECT Codigobarras FROM productos WHERE Disponible = 1;";
         try {
            // Crear una lista para cada columna

            // Ejecutar la consulta
            Statement stmt = objetoConexion.estableceConexion().createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            // Recorrer los resultados y añadirlos a las listas
            while (rs.next()) {
                
                codigos.add(rs.getInt("Codigobarras"));
                
            }

            // Cerrar la conexión
            rs.close();
            stmt.close();
            objetoConexion.estableceConexion().close();

            // Aquí puedes trabajar con tus listas
            // Por ejemplo, imprimir los nombres de los productos
           

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR :" + e.toString() + " CONSULTA VALIDAR CODIGO DE BARRAS");
        }
         
         for(int i=0;i<codigos.size();i++){
             if(codigos.get(i).toString().equals(codigo)){
                 return false;
             }
         }
         return true;
       
    }
    

    public void consulta() {
        nombres.clear();
        descripciones.clear();
        cantidades.clear();
        codigos.clear();
        etiquetas.clear();
        cconexion objetoConexion = new cconexion();
        String consulta = "SELECT Nombre, Descripcion, Cantidad, Codigobarras, Etiqueta FROM productos WHERE Disponible = 1;";

        try {
            // Crear una lista para cada columna

            // Ejecutar la consulta
            Statement stmt = objetoConexion.estableceConexion().createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            // Recorrer los resultados y añadirlos a las listas
            while (rs.next()) {
                nombres.add(rs.getString("Nombre"));
                descripciones.add(rs.getString("Descripcion"));
                cantidades.add(rs.getInt("Cantidad"));
                codigos.add(rs.getInt("Codigobarras"));
                etiquetas.add(rs.getString("Etiqueta"));
            }

            // Cerrar la conexión
            rs.close();
            stmt.close();
            objetoConexion.estableceConexion().close();

            // Aquí puedes trabajar con tus listas
            // Por ejemplo, imprimir los nombres de los productos
            for (String nombre : nombres) {
                System.out.println(nombre);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR :" + e.toString() + " CONSULTA SOLICITAR");
        }
    }
}
