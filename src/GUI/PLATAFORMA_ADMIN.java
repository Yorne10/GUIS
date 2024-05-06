/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author lucho
 */
public class PLATAFORMA_ADMIN extends JFrame implements ActionListener {

    Color btn_dentro = new Color(11, 90, 139);
    Color btn_fuera = new Color(45, 123, 170);
    CardLayout cardLayout = new CardLayout();
    Font letra = new Font("Lucida Sans", Font.PLAIN, 27);
    Font letra_boton = new Font("Lucida Sans", Font.PLAIN, 27);
    JPanel pos, btns, cont, contenido, ped, est, agre, eli, soli, modi;
    String[] btns_nombre = {"Pedidos", "Estadisticas", "Agregar", "Eliminar", "Solicitar", "Modificar"};
    GridBagConstraints gbc = new GridBagConstraints();
    GridBagConstraints gbc2 = new GridBagConstraints();
GridBagConstraints gbc3 = new GridBagConstraints();
GridBagConstraints gbc4 = new GridBagConstraints();
GridBagConstraints gbc5 = new GridBagConstraints();
GridBagConstraints gbc6 = new GridBagConstraints();
    JTextField nom,des,can,cod;
    JTextField e_cod;
    public PLATAFORMA_ADMIN() {
        setTitle("MENU_ADMINISTRADOR");
        setIconImage(new ImageIcon(getClass().getResource("/IMAGENES/usuario.png")).getImage());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) screenSize.getWidth(), (int) screenSize.getHeight() - 100);
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

    public void comp() {
        pos = new JPanel(new BorderLayout());
        pos.setBounds(0, 0, this.getWidth(), this.getHeight());
        System.out.println(this.getHeight());
        btns = new JPanel();
        btns.setBounds(0, 0, 100, this.getHeight());
        System.out.println(getHeight());
        btns.setLayout(new GridLayout(btns_nombre.length, 1));
        for (int i = 0; i < btns_nombre.length; i++) {
            JButton ele = new JButton(btns_nombre[i]);
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

            btns.add(ele);
        }
        pos.add(btns, BorderLayout.WEST);
        contenido = new JPanel(cardLayout);
        contenido.setBackground(btn_fuera);
        ped = new JPanel(new GridBagLayout());
        ped.setBackground(Color.white);
        JLabel titulo = new JLabel("PEDIDOS...");

        gbc.gridx = 0;
        gbc.gridy = 0;
        ped.add(titulo, gbc);

        //EJEMPLO PEDIDO 5X5
        JLabel[] pedidos = {new JLabel("PEDIDO1"), new JLabel("PEDIDO2"), new JLabel("PEDIDO3"), new JLabel("PEDIDO4"), new JLabel("PEDIDO5")};
        for (int i = 0; i < 3; i++) {

            gbc.gridy = i + 1;
            for (int e = 0; e < 7; e++) {
                gbc.gridx = e;
                gbc.insets = new Insets(10, 10, 10, 10);  // Puedes ajustar los valores a tu gusto
                ped.add(info("USER" + 1, "DDNJS \n sasa \n dsdsd \n fgfdfd", "33"), gbc);

            }
        }

        agre = new JPanel();
        agre.add(ag());
        est = new JPanel();
        est.add(est("SOPA","255","ARROZ","455555",10,50,70,40));
        
        eli = new JPanel();
        eli.add(eliminar());
        
        soli = new JPanel(new GridBagLayout());
        gbc5.gridx=0;
        gbc5.gridy=0;
        JLabel tit = new JLabel("SOLICITAR PEDIDOS");
        tit.setFont(letra);
        soli.add(tit,gbc5);
        for(int i =0; i<3;i++){
            gbc5.gridy=i+1;
            for(int e=0;e<6;e++){
                gbc5.gridx=e+1;
                gbc5.insets = new Insets(10, 10, 10, 10);  // Puedes ajustar los valores a tu gusto
                soli.add(solicitar("JABON","5","233223"),gbc5);
            }
        }
        
        modi = new JPanel(new GridBagLayout());
        gbc6.gridx=0;
        gbc6.gridy=0;
        JLabel t = new JLabel("MODIFICAR PRODUCTOS");
        t.setFont(letra);
        modi.add(t,gbc6);
        for(int i =0; i<3;i++){
            gbc6.gridy=i+1;
            for(int e=0;e<6;e++){
                gbc6.gridx=e+1;
                gbc6.insets = new Insets(10, 10, 10, 10);  // Puedes ajustar los valores a tu gusto
                modi.add(Modificar("JABON","5","233223"),gbc6);
            }
        }
        
        
        contenido.add(ped, "Pedido");
        contenido.add(est, "Estadisticas");
        contenido.add(agre, "Agregar");
        contenido.add(eli,"Eliminar");
        contenido.add(soli,"Solicitar");
        contenido.add(modi,"Modificar");
        
        pos.add(contenido, BorderLayout.CENTER);
        add(pos);
    }
    
    public JPanel Modificar(String nombre,String can,String codigo){
        JPanel panel = new JPanel(new GridLayout(7,1));
        panel.setBackground(Color.white);
        JLabel nom = new JLabel("Nombre");
      
        panel.add(nom);
        JLabel n = new JLabel(nombre);
        
        panel.add(n);
        JLabel txtCan = new JLabel("Cantidad");
        
        panel.add(txtCan);
        JLabel cn = new JLabel(can);
        
        panel.add(cn);
        
        JLabel txt_cod = new JLabel("Cod. de barras:");
        panel.add(txt_cod);
        JLabel cod = new JLabel(codigo);
        panel.add(cod);
        
        JButton boton= new JButton("MODIFICAR");
      
        panel.add(boton);
        
        
        
        return panel;
    }
    
    public JPanel solicitar(String nombre,String can,String codigo){
        JPanel panel = new JPanel(new GridLayout(7,1));
        panel.setBackground(Color.white);
        JLabel nom = new JLabel("Nombre");
      
        panel.add(nom);
        JLabel n = new JLabel(nombre);
        
        panel.add(n);
        JLabel txtCan = new JLabel("Cantidad");
        
        panel.add(txtCan);
        JLabel cn = new JLabel(can);
        
        panel.add(cn);
        
        JLabel txt_cod = new JLabel("Cod. de barras:");
        panel.add(txt_cod);
        JLabel cod = new JLabel(codigo);
        panel.add(cod);
        
        JButton boton= new JButton("PEDIR");
      
        panel.add(boton);
        
        
        
        return panel;
    }
    
    public JPanel eliminar(){
        JPanel panel = new JPanel(new GridBagLayout());
        gbc4.gridx=0;
        gbc4.gridy=0;
        
        JLabel txt_n = new JLabel("CODIGO DE BARRAS:");
        txt_n.setFont(letra);
        panel.add(txt_n,gbc4);
        e_cod = new JTextField();
        e_cod.setPreferredSize(new Dimension(200,60));
        e_cod.setFont(letra);
        gbc4.gridx=1;
        panel.add(e_cod);
        gbc4.gridy=1;
        JButton boton = new JButton("ELIMINAR");
        boton.setFont(letra);
        panel.add(boton,gbc4);
        
        
        
        return panel;
    }

    public JPanel est(String p_m_v, String ganancias, String p_menos_v, String inv_tot,int limp, int hogar, int salud, int mascotas) {
        JPanel estadisticas = new JPanel(new GridBagLayout());
        gbc2.gridx=0;
        gbc2.gridy =0;
        JLabel tit = new JLabel("ESTADISTICAS");
        tit.setFont(letra);
        estadisticas.add(tit,gbc2);
        gbc2.gridy =1;
        JLabel mas = new JLabel("EL PRODUCTO MÁS VENDIDO ES: " + p_m_v);
        mas.setFont(letra);
        estadisticas.add(mas,gbc2);
        gbc2.gridy=2;
        JLabel menos = new JLabel("EL PRODUCTO MENOS VENDIDO ES: " + p_menos_v);
        menos.setFont(letra);
        estadisticas.add(menos,gbc2);
        JLabel gan = new JLabel("LAS GANANCIAS SON: $" + ganancias);
        gan.setFont(letra);
        gbc2.gridy=3;
        estadisticas.add(gan,gbc2);
        JLabel pro_t = new JLabel("TIENES " + inv_tot + " productos");
        pro_t.setFont(letra);
        gbc2.gridy=4;
        estadisticas.add(pro_t,gbc2);
        DefaultPieDataset datos = new DefaultPieDataset();
        datos.setValue("LIMPIEZA", limp);
        datos.setValue("HOGAR", hogar);
        datos.setValue("SALUD", salud);
        datos.setValue("MASCOTAS", mascotas);
        
        JFreeChart graficoCircular = ChartFactory.createPieChart(
        "VENTAS POR CATEGORIA",
        datos,
        true,
        true,
        false
        );
        ChartPanel panel = new ChartPanel(graficoCircular);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(600,500));
        gbc2.gridx=0;
        gbc2.gridy=5;
        estadisticas.add(panel,gbc2);
//        pack();
//        repaint();
        return estadisticas;
    }

    public JPanel info(String us, String lista, String precio) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(new GridLayout(7, 1));
        JLabel nombre = new JLabel("Nombre:");
        JLabel txt_nom = new JLabel(us);
        JLabel lis = new JLabel("LISTA: ");
        JTextArea cont = new JTextArea(lista);
        JScrollPane contenedor = new JScrollPane(cont);
        cont.setSize(200, 500);
        cont.setEditable(false);
        JLabel pre = new JLabel("Precio: $" + precio);
        JButton dar = new JButton("ENTREGAR");
        JButton can = new JButton("CANCELAR");
        panel.add(nombre);
        panel.add(txt_nom);
        panel.add(lis);
        panel.add(contenedor);
        panel.add(pre);
        panel.add(dar);
        panel.add(can);
        return panel;
    }
    
    public JPanel ag(){
        JPanel panel = new JPanel(new GridBagLayout());
        gbc3.gridx=0;
        gbc3.gridy=0;
        JLabel txt_nm = new JLabel("NOMBRE:");
        txt_nm.setFont(letra);
        panel.add(txt_nm,gbc3);
        gbc3.gridy=1;
        JLabel txt_des = new JLabel("Descripcion corta:");
        txt_des.setFont(letra);
        panel.add(txt_des,gbc3);
        gbc3.gridy=2;
        JLabel txt_cant = new JLabel("CANTIDAD: ");
        txt_cant.setFont(letra);
        panel.add(txt_cant,gbc3);
         gbc3.gridy=3;
        JLabel txt_cod = new JLabel("COD. DE BARRAS: ");
        txt_cod.setFont(letra);
        panel.add(txt_cod,gbc3);
        gbc3.gridx=1;
        gbc3.gridy=0;
        
        nom = new JTextField();
        nom.setPreferredSize(new Dimension(200,50));
        nom.setFont(letra);
        panel.add(nom,gbc3);
        gbc3.gridx=1;
        gbc3.gridy=1;
        
        des = new JTextField();
        des.setPreferredSize(new Dimension(200,50));
        des.setFont(letra);
        panel.add(des,gbc3);
        
        gbc3.gridx=1;
        gbc3.gridy=2;
        
        can = new JTextField();
        can.setPreferredSize(new Dimension(200,50));
        can.setFont(letra);
        panel.add(can,gbc3);
        gbc3.gridx=0;
        gbc3.gridy=4;
        JLabel txt_et = new JLabel("ETIQUETA");
        txt_et.setFont(letra);
        panel.add(txt_et,gbc3);
        gbc3.gridx=1;
        gbc3.gridy=4;
        String[] opciones = {"LIMPIEZA", "HOGAR","SALUD","MASCOTAS"
            
        };
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        comboBox.setFont(letra);
        panel.add(comboBox,gbc3);
        gbc3.gridx=1;
        gbc3.gridy=3;
        
        cod = new JTextField();
        cod.setPreferredSize(new Dimension(200,50));
        cod.setFont(letra);
        panel.add(cod,gbc3);
        gbc3.gridy=5;
        JButton boton = new JButton("ACEPTAR");
       boton.setFont(letra);
        panel.add(boton,gbc3);
        
        
        return panel;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
         JButton botonPresionado = (JButton) e.getSource();
        String textoBoton = botonPresionado.getLabel();

        switch (textoBoton) {
            case "Pedidos":
                cardLayout.show(contenido, "Pedido");
                break;
            case "Agregar":
                // Aquí va el código que quieres que se ejecute cuando se presione el botón 2
                cardLayout.show(contenido, "Agregar");
                break;
            case "Eliminar":
                // Aquí va el código que quieres que se ejecute cuando se presione el botón 3
                cardLayout.show(contenido, "Eliminar");
                break;
            case "Solicitar":
                // Aquí va el código que quieres que se ejecute cuando se presione el botón 3
                cardLayout.show(contenido, "Solicitar");
                break;
            case "Modificar":
                // Aquí va el código que quieres que se ejecute cuando se presione el botón 3
                cardLayout.show(contenido, "Modificar");
                break;
            case "Estadisticas":
                // Aquí va el código que quieres que se ejecute cuando se presione el botón 3
                cardLayout.show(contenido, "Estadisticas");
                break;
        }
    }

}
