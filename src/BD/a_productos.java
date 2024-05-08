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
    ArrayList<byte[]> imageBytes = new ArrayList<>();

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

    //AGREGAR
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

    public boolean val_codigo(String codigo) {
        nombres.clear();
        descripciones.clear();
        cantidades.clear();
        codigos.clear();
        etiquetas.clear();
        imageBytes.clear();
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

        for (int i = 0; i < codigos.size(); i++) {
            if (codigos.get(i).toString().equals(codigo)) {
                return false;
            }
        }
        return true;

    }

    //CONSULTA NORMAL
    public void consulta() {
        nombres.clear();
        descripciones.clear();
        cantidades.clear();
        codigos.clear();
        etiquetas.clear();
        imageBytes.clear();
        cconexion objetoConexion = new cconexion();
        String consulta = "SELECT Nombre, Descripcion, Cantidad, Codigobarras, Etiqueta, Foto FROM productos WHERE Disponible = 1;";

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
                imageBytes.add(rs.getBytes("Foto"));

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

    public ArrayList<byte[]> getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(ArrayList<byte[]> imageBytes) {
        this.imageBytes = imageBytes;
    }

    public void eliminar(int cod) {
        nombres.clear();
        descripciones.clear();
        cantidades.clear();
        codigos.clear();
        etiquetas.clear();
        imageBytes.clear();
        cconexion objetoConexion = new cconexion();
        String consulta = "UPDATE productos SET Disponible = 0 WHERE Codigobarras = ?";

        try {
            // Crear una lista para cada columna

            // Preparar la consulta
            PreparedStatement preparedStatement = objetoConexion.estableceConexion().prepareStatement(consulta);

            // Establecer el valor del código de barras
            preparedStatement.setInt(1, cod);

            // Ejecutar la consulta
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Filas afectadas: " + filasAfectadas);
            JOptionPane.showMessageDialog(null, "HAZ ELIMINADO EL PRODUCTO");
            // Cerrar la conexión
            preparedStatement.close();
            objetoConexion.estableceConexion().close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR :" + e.toString() + " CONSULTA SOLICITAR");
        }
    }

    public void sumar(int codigobarras,int mas) {
        int aux = 0;
        nombres.clear();
        descripciones.clear();
        cantidades.clear();
        codigos.clear();
        etiquetas.clear();
        imageBytes.clear();
        cconexion objetoConexion = new cconexion();
        String consulta = "SELECT Cantidad FROM productos WHERE Codigobarras=?;";

        try {
            // Preparar la consulta
            PreparedStatement preparedStatement = objetoConexion.estableceConexion().prepareStatement(consulta);

            // Establecer el valor del código de barras
            preparedStatement.setInt(1, codigobarras);

            // Ejecutar la consulta
            ResultSet rs = preparedStatement.executeQuery();

            // Si hay un resultado, almacenarlo en 'aux'
            if (rs.next()) {
                aux = rs.getInt("Cantidad");
            }

            // Cerrar la conexión
            rs.close();
            preparedStatement.close();
            
            aux += mas;
            
            String consulta2 = "UPDATE productos SET Cantidad = ? WHERE Codigobarras = ?";
            
            PreparedStatement preparedStatement2 = objetoConexion.estableceConexion().prepareStatement(consulta2);
            
            preparedStatement2.setInt(1, aux);
            preparedStatement2.setInt(2, codigobarras);
            
            
            int filasAfectadas = preparedStatement2.executeUpdate();
            System.out.println("Filas afectadas: " + filasAfectadas);
            JOptionPane.showMessageDialog(null, "HAZ AÑADIDO " + mas +" PRODUCTOS \n AHORA TIENES= " + aux);
            
            
            preparedStatement2.close();
            objetoConexion.estableceConexion().close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR :" + e.toString() + " CONSULTA SOLICITAR");
        }
    }
}
