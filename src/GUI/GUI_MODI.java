/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BD.a_productos;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author lucho
 */
public class GUI_MODI extends JFrame implements ActionListener{
    String nombre,can,codigo,descri,eti;
    Image m;
    int dis, vend,precio;
    PLATAFORMA_ADMIN obj;
    boolean cambioImg;
    File selectFile;
    
    
    JLabel tit,txt_nom,txt_can,txt_codigo,txt_descri,txt_eti,txt_m,txt_dis,txt_vend,f_m,ruta, txt_pre;
    JTextField f_nom,f_can,f_codigo,f_descri,f_eti,f_dis,f_vend, f_pre;
    JButton boton_cancelar,boton_aceptar,explorar;
    
    public GUI_MODI(String nombre, String can, String codigo, Image m, String descri, String eti, int dis, int vend,PLATAFORMA_ADMIN obj, int precio){
        
        this.nombre = nombre;
        this.can = can;
        this.codigo=codigo;
        this.m = m;
        this.descri = descri;
        this.eti = eti;
        this.dis = dis;
        this.precio = precio;
        
        this.vend = vend;
        this.obj = obj;
        setTitle("MODIFICACION A "+ nombre);
        setResizable(false);
        setSize(400,660);
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.out.println(ex);
        }
        setLayout(null);
        setLocationRelativeTo(null);
        comp();
        setVisible(true);
        
    }
    
    
    
    public void comp(){
        tit = new JLabel("MODIFICACION " + nombre);
        tit.setBounds(150,10,150,30);
        add(tit);
        
        txt_nom = new JLabel("NOMBRE: ");
        txt_nom.setBounds(10,60, 100, 30);
        add(txt_nom);
        
        f_nom = new JTextField(nombre);
        f_nom.setBounds(80,60,100,30);
        add(f_nom);
        
        txt_descri = new JLabel("DESCRIPCION: ");
        txt_descri.setBounds(10, 100, 100, 30);
        add(txt_descri);
        
        f_descri = new JTextField(descri);
        f_descri.setBounds(120,100,100,30);
        add(f_descri);
        
        txt_codigo = new JLabel("CODIGO:");
        txt_codigo.setBounds(10,140,100,30);
        add(txt_codigo);
        
        f_codigo = new JTextField(codigo);
        f_codigo.setEditable(false);
        f_codigo.setBounds(100, 140, 100, 30);
        add(f_codigo);
        
        txt_eti = new JLabel("ETIQUETA:");
        txt_eti.setBounds(10, 180, 100, 30);
        add(txt_eti);
        
        f_eti = new JTextField(eti);
        f_eti.setBounds(100, 180, 100, 30);
        add(f_eti);
        
        txt_dis = new JLabel("DISPONIBLE:");
        txt_dis.setBounds(10, 220, 100, 30);
        add(txt_dis);
        
        f_dis = new JTextField();
        f_dis.setText(dis+"");
        f_dis.setBounds(100, 220, 100, 30);
        add(f_dis);
        
        txt_vend = new JLabel("VENDIDOS:");
        txt_vend.setBounds(10, 260, 100, 30);
        add(txt_vend);
        
        f_vend = new JTextField();
        f_vend.setText(""+vend);
        f_vend.setBounds(100,260,100,30);
        add(f_vend);
        
         txt_can = new JLabel("CANTIDAD:");
        txt_can.setBounds(10, 300, 100, 30);
        add(txt_can);
        
        f_can = new JTextField(can);
        f_can.setBounds(100,300,100,30);
        add(f_can);
        
        txt_pre = new JLabel("PRECIO:");
        txt_pre.setBounds(10, 340, 100, 30);
        add(txt_pre);
        
        f_pre = new JTextField(precio+"");
        f_pre.setBounds(100,340,100,30);
        add(f_pre);
        
        
        txt_m = new JLabel("FOTO");
        txt_m.setBounds(10, 380, 100, 30);
        add(txt_m);
        
        f_m = new JLabel();
        f_m.setBounds(100, 380, 100, 100);
        ImageIcon originalIcon = new ImageIcon(m);
        int lblwidth = f_m.getWidth();
        int lblheight = f_m.getHeight();
        Image scalImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        f_m.setIcon(new ImageIcon(scalImage));
        add(f_m);
        
        explorar = new JButton("EXPLORAR");
        explorar.setBounds(210, 460, 150, 30);
        explorar.addActionListener(this);
        add(explorar);
        
        ruta = new JLabel("");
        ruta.setBounds(100,450,100,30);
        add(ruta);
        
        
        
        boton_cancelar = new JButton("CANCELAR");
        boton_cancelar.setBounds(10, 500, 150, 60);
        boton_cancelar.addActionListener(this);
        add(boton_cancelar);
        
        boton_aceptar = new JButton("ACEPTAR");
        boton_aceptar.setBounds(230, 500, 150, 60);
        boton_aceptar.addActionListener(this);
        add(boton_aceptar);
       
    }
    
    public void cambioImg(){
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton_aceptar){
            try{
            a_productos enviar = new a_productos();
            int can = Integer.parseInt(this.f_can.getText());
            int codigo = Integer.parseInt(this.f_codigo.getText());
            int pr = Integer.parseInt(this.f_pre.getText());
            if(f_nom.getText().equals("")||f_descri.getText().equals("")||f_eti.getText().equals("")){
                JOptionPane.showMessageDialog(null, "COMPLETA LOS DATOS");
            }else{
                if(cambioImg){
                     enviar.modificar(f_nom.getText(),f_descri.getText(),f_eti.getText(),can,selectFile,codigo, pr);
                     obj.actualizarModi();
                     setVisible(false);
                     
                }else{
                    System.out.println(pr);
                    enviar.modificar(f_nom.getText(),f_descri.getText(),f_eti.getText(),can,codigo,pr);
                    obj.actualizarModi();
                    setVisible(false);
                }
               
            }
            
            }catch(Exception r){
                JOptionPane.showMessageDialog(null, "ERROR EN LOS DATOS");
            }
            
        }
        
        if(e.getSource()==boton_cancelar){
            setVisible(false);
        }
        
        if(e.getSource()==explorar){
            JFileChooser fileChooser = new JFileChooser();
                
                int result = fileChooser.showOpenDialog(null);
                
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectFile = fileChooser.getSelectedFile();
                    ruta.setText(selectFile.getName());
                    try {
                        Image imag = ImageIO.read(selectFile);
                        ImageIcon originalIcon = new ImageIcon(imag);
                        
                        int lblwidth = f_m.getWidth();
                        int lblheight = f_m.getHeight();
                        
                        Image scalImage = originalIcon.getImage().getScaledInstance(lblwidth, lblheight, Image.SCALE_SMOOTH);
                        f_m.setIcon(new ImageIcon(scalImage));
                        cambioImg=true;
                        
                    } catch (Exception s) {
                        JOptionPane.showMessageDialog(null, "ERROR AL CARGAR");
                    }
                }
        }
    }
    
}
