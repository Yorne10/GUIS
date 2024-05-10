/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author lucho
 */
public class GUI_ver_mas extends JFrame implements ActionListener {

    Font letra_titulo = new Font("Lucida Sans", Font.BOLD, 50);
    Font letra_boton = new Font("Lucida Sans", Font.PLAIN, 25);
    String nombre, desc,eti;
    int cod, can,pre;
    Image img;
    JLabel tit, lbl_des;
    JTextArea us_des;
    JLabel txtimg,txt_pre;
    JButton anadir;
    JButton canc;
    PLATAFORMA_US obj;
    

    public GUI_ver_mas(String nombre, String desc, int cod, int can, Image img,int pre,PLATAFORMA_US obj,String eti) {
        this.nombre = nombre;
        this.desc = desc;
        this.cod = cod;
        this.can = can;
        this.img = img;
        this.pre= pre;
        this.obj = obj;
        this.eti = eti;

        setTitle("PRODUCTO " + nombre);
        setResizable(false);
        setSize(780, 630);
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

    public void comp() {
        tit = new JLabel(nombre);
        tit.setBounds(100, 50, 200, 70);
        tit.setFont(letra_titulo);
        add(tit);
        
        txt_pre = new JLabel("$"+pre);
        txt_pre.setBounds(400, 50, 600, 70);
        txt_pre.setFont(letra_titulo);
        add(txt_pre);

        lbl_des = new JLabel("DESCRIPCION");
        lbl_des.setFont(letra_boton);
        lbl_des.setBounds(10, 100, 200, 50);
        add(lbl_des);

        us_des = new JTextArea();
        us_des.setBounds(10, 150, 340, 300);
        us_des.setLineWrap(true);
        us_des.setWrapStyleWord(true);
        us_des.setEditable(false);
        us_des.setText(desc);
        add(us_des);

        ImageIcon originalIcon = new ImageIcon(img);
        
        
        txtimg = new JLabel();
        txtimg.setBounds(400, 140, 300, 300);
        add(txtimg);
        Image scalImage = originalIcon.getImage().getScaledInstance(txtimg.getWidth(), txtimg.getHeight(), Image.SCALE_SMOOTH);
        txtimg.setIcon(new ImageIcon(scalImage));
        anadir = new JButton("AÑADIR");
        anadir.setBounds(420,500,150,60);
        anadir.addActionListener(this);
        add(anadir);
        
         canc = new JButton("CANCELAR");
         canc.addActionListener(this);
        canc.setBounds(10,500,150,60);
        add(canc);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==canc){
            setVisible(false);
        }
        
        if(e.getSource()==anadir){
            try{
                int c = Integer.parseInt(JOptionPane.showInputDialog(null, "¿CUANTOS PRODUCTOS QUIERES?"));
                int it=0;
                if(obj.cod_can.containsKey(cod)){
                    
                    for(int i =0; i<obj.codigos_g.size();i++){
                        if(obj.codigos_g.get(i) == cod){
                            c += obj.cantidades_g.get(i);
                            it = i;
                        }
                    }
                    if(c>can){
                        JOptionPane.showMessageDialog(null, "LA CANTIDAD AÑADIDA EXCEDE EL LIMITE");
                    }else if(c<0){
                        JOptionPane.showMessageDialog(null, "LA CANTIDAD AÑADIDA Y EL ANTERIOR DA NUMERO NEGATIVO");
                    }else{
                        obj.cod_can.put(cod, c);
                        obj.cantidades_g.set(it, c);
                    }
                    
                }else{
                    System.out.println(cod);
                    System.out.println("NO HAY LLAVE");
                
                if(c>can){
                    JOptionPane.showMessageDialog(null, "LA CANTIDAD EXCEDE DEL LIMITE");
                }else if(c<0){
                    JOptionPane.showMessageDialog(null, "LA CANTIDAD TIENE QUE SER MÁS DE 1");
                }else{
                    obj.nombres_g.add(nombre);
                    obj.cantidades_g.add(c);
                    obj.codigos_g.add(cod);
                    obj.precio_g.add(pre);
                    obj.etiquetas_g.add(eti);
                    obj.imageBytes_g.add(img);
                    obj.cod_can.put(cod, c);
                }
                }
                
            }catch(Exception s){
                JOptionPane.showMessageDialog(null, "ERROR EN LOS DATOS");
            }
        }
        
        
    }

}
