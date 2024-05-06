/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author lucho
 */
public class PLATAFORMA_US extends JFrame implements ActionListener{
    JLabel titulo;
    JPanel title_pan,back,menu,pos;
    Font letra_titulo = new Font("Lucida Sans", Font.BOLD, 50);
    Font letra_boton = new Font("Lucida Sans", Font.PLAIN, 27);
    String[] tit_button={"TODOS","LIMPIEZA","HOGAR","SALUD","MASCOTAS"};
    Color btn_dentro = new Color(155, 35, 161  );
    Color btn_fuera = new Color(153, 1, 160);
    
    public PLATAFORMA_US(){
        setTitle("MENU_USUARIO");
        setIconImage(new ImageIcon(getClass().getResource("/IMAGENES/carro.png")).getImage());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int)screenSize.getWidth(),(int)screenSize.getHeight());
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        getContentPane().setBackground(new Color(255,255,255));
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.out.println(ex);
        }
        
        UIManager.put("defaultFont", new Font("Lucida Sans", Font.PLAIN, 14));
        
        comp();
        
    }
    
    public void comp(){
        //PANEL QUE CONTIENE EL PANEL DE GRID
        pos = new JPanel(new BorderLayout());
        pos.setBounds(0, 0, this.getWidth(), this.getHeight());
        pos.setBackground(Color.white);
        //PANEL PRINCIPAL QUE CONTIENE LOS DEMAS PANELES
        back = new JPanel(new GridBagLayout());
        back.setBounds(0, 0, this.getWidth(), this.getHeight());
        back.setBackground(Color.white);
        
        GridBagConstraints gbc = new GridBagConstraints();
        //PANEL QUE CONTIENE EL TITULO
        title_pan = new JPanel();
        title_pan.setBackground(Color.white);
        title_pan.setBounds(0,0,this.getWidth(),80);
       // title_pan.setBackground(Color.blue);
        titulo = new JLabel("BIENVENIDO A SUPER EXPRESS");
        titulo.setFont(letra_titulo);
        titulo.setSize(1000, 40);
        
        title_pan.add(titulo);
        gbc.gridx=0;
        gbc.gridy=0;
        back.add(title_pan,gbc);
        //PANEL QUE CONTENDRA EL MENU
        menu = new JPanel(new FlowLayout());
        menu.setBackground(Color.white);
        
        menu.setSize(this.getWidth(), 100);
        for(int i=0; i<tit_button.length;i++){
            JButton ele = new JButton(tit_button[i]);
            ele.setBackground(btn_fuera);
            ele.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ele.setBackground(btn_dentro);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ele.setBackground(btn_fuera);
            }
        });
            ele.addActionListener(this);
            
            ele.setForeground(Color.white);
            ele.setFont(letra_boton);
            
            menu.add(ele);
        }
        gbc.gridy=1;
        back.add(menu,gbc);
        pos.add(back,BorderLayout.NORTH);
        add(pos);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         JButton botonPresionado = (JButton) e.getSource();
        String textoBoton = botonPresionado.getLabel();

        switch (textoBoton) {
            case "TODOS":
                // Aquí va el código que quieres que se ejecute cuando se presione el botón 1
                System.out.println("Presionaste el botón 1");
                break;
            case "LIMPIEZA":
                // Aquí va el código que quieres que se ejecute cuando se presione el botón 2
                System.out.println("Presionaste el botón 2");
                break;
            case "HOGAR":
                // Aquí va el código que quieres que se ejecute cuando se presione el botón 3
                System.out.println("Presionaste el botón 3");
                break;
            case "SALUD":
                // Aquí va el código que quieres que se ejecute cuando se presione el botón 3
                System.out.println("Presionaste el botón 3");
                break;
            case "MASCOTAS":
                // Aquí va el código que quieres que se ejecute cuando se presione el botón 3
                System.out.println("Presionaste el botón 3");
                break;
        }
    }
}
