/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import java.awt.Image;
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
    ArrayList<Integer> vendidos = new ArrayList<>();
    ArrayList<Integer> disponible = new ArrayList<>();
    ArrayList<Integer> precio = new ArrayList<>();

    public ArrayList<Integer> getPrecio() {
        return precio;
    }

    public void setPrecio(ArrayList<Integer> precio) {
        this.precio = precio;
    }

    public ArrayList<Integer> getVendidos() {
        return vendidos;
    }

    public void setVendidos(ArrayList<Integer> vendidos) {
        this.vendidos = vendidos;
    }

    public ArrayList<Integer> getDisponible() {
        return disponible;
    }

    public void setDisponible(ArrayList<Integer> disponible) {
        this.disponible = disponible;
    }

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
    public void agregarProducto(String nombre, String descripcion, int cantidad, int cod, String etiqueta, File foto, int precio) {
        cconexion objetoConexion = new cconexion();

        String consulta = "insert into productos (Nombre,Descripcion,Cantidad,Codigobarras,Etiqueta,Foto,Disponible,Precio) values(?,?,?,?,?,?,?,?);";

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
            cs.setInt(8, precio);

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
        precio.clear();
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
    
    
    public void modificar(String nombre, String descri, String eti, int can, File m, int cod,int pre){
        nombres.clear();
        descripciones.clear();
        cantidades.clear();
        codigos.clear();
        etiquetas.clear();
        imageBytes.clear();
        precio.clear();
        
        cconexion objetoConexion = new cconexion();
        String consulta = "UPDATE productos SET Nombre = ?, Descripcion = ?, Cantidad = ?, Etiqueta = ?, Foto = ?, Precio = ? WHERE Codigobarras = ?";

        try {
            FileInputStream fis = new FileInputStream(m);

            // Preparar la consulta
            PreparedStatement preparedStatement = objetoConexion.estableceConexion().prepareStatement(consulta);

            // Establecer el valor del código de barras
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, descri);
            preparedStatement.setString(4, eti);
            preparedStatement.setInt(3, can);
            preparedStatement.setBinaryStream(5, fis, (int) m.length());
            preparedStatement.setInt(6, pre);
            preparedStatement.setInt(7, cod);
            
            

            // Ejecutar la consulta
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Filas afectadas: " + filasAfectadas);
            JOptionPane.showMessageDialog(null, "HAZ MODIFICADO EL PRODUCTO");
            // Cerrar la conexión
            preparedStatement.close();
            objetoConexion.estableceConexion().close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR :" + e.toString() + " CONSULTA SOLICITAR");
        }
    }
    public void modificar(String nombre, String descri, String eti, int can, int cod, int pre){
        nombres.clear();
        descripciones.clear();
        cantidades.clear();
        codigos.clear();
        etiquetas.clear();
        imageBytes.clear();
        precio.clear();
        
        cconexion objetoConexion = new cconexion();
        String consulta = "UPDATE productos SET Nombre = ?, Descripcion = ?, Cantidad = ?, Etiqueta = ?, Precio = ? WHERE Codigobarras = ?";

        try {
            // Crear una lista para cada columna

            // Preparar la consulta
            PreparedStatement preparedStatement = objetoConexion.estableceConexion().prepareStatement(consulta);

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, descri);
            preparedStatement.setInt(3, can);
            preparedStatement.setString(4, eti);
            preparedStatement.setInt(5, pre);
            
            preparedStatement.setInt(6, cod);
            

            // Ejecutar la consulta
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Filas afectadas: " + filasAfectadas);
            JOptionPane.showMessageDialog(null, "HAZ MODIFICADO EL PRODUCTO");
            // Cerrar la conexión
            preparedStatement.close();
            objetoConexion.estableceConexion().close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR :" + e.toString() + " CONSULTA SOLICITAR");
        }
    }

    //CONSULTA NORMAL
    public void consulta() {
        nombres.clear();
        descripciones.clear();
        cantidades.clear();
        codigos.clear();
        etiquetas.clear();
        imageBytes.clear();
        disponible.clear();
        vendidos.clear();
        precio.clear();
        cconexion objetoConexion = new cconexion();
        String consulta = "SELECT Nombre, Descripcion, Cantidad, Codigobarras, Etiqueta, Foto, Disponible, Vendidos, Precio FROM productos WHERE Disponible = 1;";

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
                disponible.add(rs.getInt("Disponible"));
                vendidos.add(rs.getInt("Vendidos"));
                precio.add(rs.getInt("Precio"));

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
    
    
    public void consulta_busq(String nom) {
        nombres.clear();
        descripciones.clear();
        cantidades.clear();
        codigos.clear();
        etiquetas.clear();
        imageBytes.clear();
        disponible.clear();
        vendidos.clear();
        precio.clear();
        cconexion objetoConexion = new cconexion();
         String consulta = "SELECT Nombre, Descripcion, Cantidad, Codigobarras, Etiqueta, Foto, Disponible, Vendidos, Precio FROM productos WHERE Disponible = 1 AND Nombre = ?;";

        try {
            // Crear una lista para cada columna

            // Ejecutar la consulta
            PreparedStatement stmt = objetoConexion.estableceConexion().prepareStatement(consulta);
            stmt.setString(1, nom);
            ResultSet rs = stmt.executeQuery();

            // Recorrer los resultados y añadirlos a las listas
            while (rs.next()) {
                nombres.add(rs.getString("Nombre"));
                descripciones.add(rs.getString("Descripcion"));
                cantidades.add(rs.getInt("Cantidad"));
                codigos.add(rs.getInt("Codigobarras"));
                etiquetas.add(rs.getString("Etiqueta"));
                imageBytes.add(rs.getBytes("Foto"));
                disponible.add(rs.getInt("Disponible"));
                vendidos.add(rs.getInt("Vendidos"));
                precio.add(rs.getInt("Precio"));

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
        precio.clear();
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
        precio.clear();
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
    
    public void buscar_limpieza(){
        nombres.clear();
        descripciones.clear();
        cantidades.clear();
        codigos.clear();
        etiquetas.clear();
        imageBytes.clear();
        disponible.clear();
        vendidos.clear();
        precio.clear();
        cconexion objetoConexion = new cconexion();
        String consulta = "SELECT Nombre, Descripcion, Cantidad, Codigobarras, Etiqueta, Foto, Disponible, Vendidos, Precio FROM productos WHERE Disponible = 1 AND Etiqueta = \"LIMPIEZA\";";

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
                disponible.add(rs.getInt("Disponible"));
                vendidos.add(rs.getInt("Vendidos"));
                precio.add(rs.getInt("Precio"));

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
    
    public void buscar_hogar(){
        nombres.clear();
        descripciones.clear();
        cantidades.clear();
        codigos.clear();
        etiquetas.clear();
        imageBytes.clear();
        disponible.clear();
        vendidos.clear();
        precio.clear();
        cconexion objetoConexion = new cconexion();
        String consulta = "SELECT Nombre, Descripcion, Cantidad, Codigobarras, Etiqueta, Foto, Disponible, Vendidos, Precio FROM productos WHERE Disponible = 1 AND Etiqueta = \"HOGAR\";";

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
                disponible.add(rs.getInt("Disponible"));
                vendidos.add(rs.getInt("Vendidos"));
                precio.add(rs.getInt("Precio"));

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
    
    public void buscar_salud(){
        nombres.clear();
        descripciones.clear();
        cantidades.clear();
        codigos.clear();
        etiquetas.clear();
        imageBytes.clear();
        disponible.clear();
        vendidos.clear();
        precio.clear();
        cconexion objetoConexion = new cconexion();
        String consulta = "SELECT Nombre, Descripcion, Cantidad, Codigobarras, Etiqueta, Foto, Disponible, Vendidos, Precio FROM productos WHERE Disponible = 1 AND Etiqueta = \"SALUD\";";

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
                disponible.add(rs.getInt("Disponible"));
                vendidos.add(rs.getInt("Vendidos"));
                precio.add(rs.getInt("Precio"));

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
    public void buscar_mascotas(){
        nombres.clear();
        descripciones.clear();
        cantidades.clear();
        codigos.clear();
        etiquetas.clear();
        imageBytes.clear();
        disponible.clear();
        vendidos.clear();
        precio.clear();
        cconexion objetoConexion = new cconexion();
        String consulta = "SELECT Nombre, Descripcion, Cantidad, Codigobarras, Etiqueta, Foto, Disponible, Vendidos, Precio FROM productos WHERE Disponible = 1 AND Etiqueta = \"MASCOTAS\";";

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
                disponible.add(rs.getInt("Disponible"));
                vendidos.add(rs.getInt("Vendidos"));
                precio.add(rs.getInt("Precio"));

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
