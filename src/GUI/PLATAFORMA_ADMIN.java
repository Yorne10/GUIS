/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BD.a_productos;
import BD.cconexion;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.plaf.ComboBoxUI;
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
    CardLayout cardLayout2 = new CardLayout();
    CardLayout cardLayout3 = new CardLayout();
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
    GridBagConstraints gbc7 = new GridBagConstraints();
    JTextField nom, des, can, cod;
    JTextField e_cod;

    public File selectFile;

    public PLATAFORMA_ADMIN() {
        setTitle("MENU_ADMINISTRADOR");
        setIconImage(new ImageIcon(getClass().getResource("/IMAGENES/usuario.png")).getImage());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) screenSize.getWidth(), (int) screenSize.getHeight() - 100);
        setLocationRelativeTo(null);
        setLayout(null);
//        cconexion objetocon = new cconexion();
//        objetocon.estableceConexion();
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
        est.add(est("SOPA", "255", "ARROZ", "455555", 10, 50, 70, 40));

        eli = new JPanel();
        eli.add(eliminar());

        soli = new JPanel(cardLayout2);

        gbc5.gridx = 0;
        gbc5.gridy = 0;
        JLabel tit = new JLabel("SOLICITAR PEDIDOS");
        tit.setFont(letra);
//        soli.add(tit, gbc5);
//        for (int i = 0; i < 3; i++) {
//            gbc5.gridy = i + 1;
//            for (int e = 0; e < 6; e++) {
//                gbc5.gridx = e + 1;
//                gbc5.insets = new Insets(10, 10, 10, 10);  // Puedes ajustar los valores a tu gusto
//                soli.add(solicitar("JABON", "5", "233223"), gbc5);
//            }
//        }

        modi = new JPanel(cardLayout3);
        gbc6.gridx = 0;
        gbc6.gridy = 0;
//        JLabel t = new JLabel("MODIFICAR PRODUCTOS");
//        t.setFont(letra);
//        modi.add(t, gbc6);
//        for (int i = 0; i < 3; i++) {
//            gbc6.gridy = i + 1;
//            for (int e = 0; e < 6; e++) {
//                gbc6.gridx = e + 1;
//                gbc6.insets = new Insets(10, 10, 10, 10);  // Puedes ajustar los valores a tu gusto
//                modi.add(Modificar("JABON", "5", "233223"), gbc6);
//            }
//        }

        contenido.add(ped, "Pedido");
        contenido.add(est, "Estadisticas");
        contenido.add(agre, "Agregar");
        contenido.add(eli, "Eliminar");
        contenido.add(soli, "Solicitar");
        contenido.add(modi, "Modificar");

        pos.add(contenido, BorderLayout.CENTER);
        add(pos);
    }

    public JPanel Modificar(String nombre, String can, String codigo, Image m) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.white);
        gbc7.gridx = 0;
        gbc7.gridy = 0;
        JLabel nom = new JLabel("Nombre");

        panel.add(nom, gbc7);
        JLabel n = new JLabel(nombre);
        gbc7.gridy = 1;
        panel.add(n, gbc7);
        JLabel txtCan = new JLabel("Cantidad");
        gbc7.gridy = 2;
        panel.add(txtCan, gbc7);
        JLabel cn = new JLabel(can);
        gbc7.gridy = 3;
        panel.add(cn, gbc7);

        JLabel txt_cod = new JLabel("Cod. de barras:");
        gbc7.gridy = 4;
        panel.add(txt_cod, gbc7);
        JLabel cod = new JLabel(codigo);
        gbc7.gridy = 5;
        panel.add(cod, gbc7);
        
        gbc7.gridy = 6;
        JLabel ft = new JLabel();
        ft.setPreferredSize(new Dimension(75, 75));
        panel.add(ft, gbc7);
        
        ImageIcon originalIcon = new ImageIcon(m);

        int lblwidth = ft.getWidth();
        int lblheight = ft.getHeight();

        Image scalImage = originalIcon.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ft.setIcon(new ImageIcon(scalImage));

        JButton boton = new JButton("MODIFICAR");
        gbc7.gridy = 7;
        panel.add(boton, gbc7);

        return panel;
    }

    public JPanel solicitar(String nombre, String can, String codigo, Image m) {
        JPanel panel = new JPanel(new GridBagLayout());
        gbc7.gridx = 0;
        gbc7.gridy = 0;
        panel.setBackground(Color.white);
        JLabel nom = new JLabel("Nombre");

        panel.add(nom, gbc7);
        gbc7.gridy = 1;
        JLabel n = new JLabel(nombre);

        panel.add(n, gbc7);
        JLabel txtCan = new JLabel("Cantidad");
        gbc7.gridy = 2;
        panel.add(txtCan, gbc7);
        JLabel cn = new JLabel(can);
        gbc7.gridy = 3;
        panel.add(cn, gbc7);

        JLabel txt_cod = new JLabel("Cod. de barras:");
        gbc7.gridy = 4;
        panel.add(txt_cod, gbc7);
        JLabel cod = new JLabel(codigo);
        gbc7.gridy = 5;
        panel.add(cod, gbc7);

        gbc7.gridy = 6;
        JLabel ft = new JLabel();
        ft.setPreferredSize(new Dimension(75, 75));
        panel.add(ft, gbc7);
        
        ImageIcon originalIcon = new ImageIcon(m);

        int lblwidth = ft.getWidth();
        int lblheight = ft.getHeight();

        Image scalImage = originalIcon.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ft.setIcon(new ImageIcon(scalImage));
        

        JButton boton = new JButton("PEDIR");
        boton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                accion_pedir(codigo);
            }            
        });
        gbc7.gridy = 7;
        panel.add(boton, gbc7);

        return panel;
    }
    
    public void accion_pedir(String codigo){
        try{
            int c = Integer.parseInt(codigo);
            int mas = Integer.parseInt(JOptionPane.showInputDialog(null,"¿Cuantos elementos quieres pedir?"));
            
            a_productos pd = new a_productos();
            pd.sumar(c, mas);
            actualizarSoli();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR EN LA CANTIDAD");
        }
    }

    public JPanel eliminar() {
        JPanel panel = new JPanel(new GridBagLayout());
        gbc4.gridx = 0;
        gbc4.gridy = 0;

        JLabel txt_n = new JLabel("CODIGO DE BARRAS:");
        txt_n.setFont(letra);
        panel.add(txt_n, gbc4);
        e_cod = new JTextField();
        e_cod.setPreferredSize(new Dimension(200, 60));
        e_cod.setFont(letra);
        gbc4.gridx = 1;
        panel.add(e_cod);
        gbc4.gridy = 1;
        JButton boton = new JButton("ELIMINAR");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int c = Integer.parseInt(e_cod.getText());
                    boolean val_codigo = String.valueOf(Math.abs(c)).length() == 9;
                    if (val_codigo) {
                        a_productos borrar = new a_productos();
                        borrar.eliminar(c);
                    } else {
                        JOptionPane.showMessageDialog(null, "EL CODIGO ES DE 9 DIGITOS");
                    }

                } catch (Exception s) {
                    JOptionPane.showMessageDialog(null, "ERROR EN EL CODIGO DE BARRAS VUELVE A COLOCAR EL CODIGO");
                }
            }
        });
        boton.setFont(letra);
        panel.add(boton, gbc4);

        return panel;
    }

    public JPanel est(String p_m_v, String ganancias, String p_menos_v, String inv_tot, int limp, int hogar, int salud, int mascotas) {
        JPanel estadisticas = new JPanel(new GridBagLayout());
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        JLabel tit = new JLabel("ESTADISTICAS");
        tit.setFont(letra);
        estadisticas.add(tit, gbc2);
        gbc2.gridy = 1;
        JLabel mas = new JLabel("EL PRODUCTO MÁS VENDIDO ES: " + p_m_v);
        mas.setFont(letra);
        estadisticas.add(mas, gbc2);
        gbc2.gridy = 2;
        JLabel menos = new JLabel("EL PRODUCTO MENOS VENDIDO ES: " + p_menos_v);
        menos.setFont(letra);
        estadisticas.add(menos, gbc2);
        JLabel gan = new JLabel("LAS GANANCIAS SON: $" + ganancias);
        gan.setFont(letra);
        gbc2.gridy = 3;
        estadisticas.add(gan, gbc2);
        JLabel pro_t = new JLabel("TIENES " + inv_tot + " productos");
        pro_t.setFont(letra);
        gbc2.gridy = 4;
        estadisticas.add(pro_t, gbc2);
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
        panel.setPreferredSize(new Dimension(600, 500));
        gbc2.gridx = 0;
        gbc2.gridy = 5;
        estadisticas.add(panel, gbc2);
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

    public JPanel ag() {
        JPanel panel = new JPanel(new GridBagLayout());
        gbc3.gridx = 0;
        gbc3.gridy = 0;
        JLabel txt_nm = new JLabel("NOMBRE:");
        txt_nm.setFont(letra);
        panel.add(txt_nm, gbc3);
        gbc3.gridy = 1;
        JLabel txt_des = new JLabel("Descripcion corta:");
        txt_des.setFont(letra);
        panel.add(txt_des, gbc3);
        gbc3.gridy = 2;
        JLabel txt_cant = new JLabel("CANTIDAD: ");
        txt_cant.setFont(letra);
        panel.add(txt_cant, gbc3);
        gbc3.gridy = 3;
        JLabel txt_cod = new JLabel("COD. DE BARRAS: ");
        txt_cod.setFont(letra);
        panel.add(txt_cod, gbc3);
        gbc3.gridx = 1;
        gbc3.gridy = 0;

        nom = new JTextField();
        nom.setPreferredSize(new Dimension(200, 50));
        nom.setFont(letra);
        panel.add(nom, gbc3);
        gbc3.gridx = 1;
        gbc3.gridy = 1;

        des = new JTextField();
        des.setPreferredSize(new Dimension(200, 50));
        des.setFont(letra);
        panel.add(des, gbc3);

        gbc3.gridx = 1;
        gbc3.gridy = 2;

        can = new JTextField();
        can.setPreferredSize(new Dimension(200, 50));
        can.setFont(letra);
        panel.add(can, gbc3);
        gbc3.gridx = 0;
        gbc3.gridy = 4;
        JLabel txt_et = new JLabel("ETIQUETA");
        txt_et.setFont(letra);
        panel.add(txt_et, gbc3);
        gbc3.gridx = 1;
        gbc3.gridy = 4;
        String[] opciones = {"LIMPIEZA", "HOGAR", "SALUD", "MASCOTAS"

        };
        JComboBox<String> comboBox = new JComboBox<>(opciones);

        comboBox.setFont(letra);
        panel.add(comboBox, gbc3);
        gbc3.gridx = 1;
        gbc3.gridy = 3;

        cod = new JTextField();
        cod.setPreferredSize(new Dimension(200, 50));
        cod.setFont(letra);
        panel.add(cod, gbc3);

        gbc3.gridx = 0;
        gbc3.gridy = 5;
        JLabel txtfoto = new JLabel("FOTO");
        txtfoto.setFont(letra);
        panel.add(txtfoto, gbc3);
        gbc3.gridx = 1;
        gbc3.gridy = 6;
        JTextField ruta = new JTextField();
        ruta.setEditable(false);
        ruta.setPreferredSize(new Dimension(200, 50));
        panel.add(ruta, gbc3);
        gbc3.gridx = 1;
        gbc3.gridy = 8;
        JLabel img = new JLabel();
        img.setPreferredSize(new Dimension(100, 100));
        panel.add(img, gbc3);
        gbc3.gridx = 1;
        gbc3.gridy = 5;
        JButton btnimg = new JButton("EXPLORAR");
        btnimg.setFont(letra);
        btnimg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();

                int result = fileChooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    selectFile = fileChooser.getSelectedFile();
                    ruta.setText(selectFile.getName());
                    try {
                        Image imag = ImageIO.read(selectFile);
                        ImageIcon originalIcon = new ImageIcon(imag);

                        int lblwidth = img.getWidth();
                        int lblheight = img.getHeight();

                        Image scalImage = originalIcon.getImage().getScaledInstance(lblwidth, lblheight, Image.SCALE_SMOOTH);
                        img.setIcon(new ImageIcon(scalImage));

                    } catch (Exception s) {
                        JOptionPane.showMessageDialog(null, "ERROR AL CARGAR");
                    }
                }
            }
        });
        panel.add(btnimg, gbc3);

        gbc3.gridx = 1;
        gbc3.gridy = 7;
        JLabel txtimg = new JLabel("IMAGEN SELECCIONADA");
        txtimg.setFont(letra);
        panel.add(txtimg, gbc3);

        gbc3.gridx = 1;
        gbc3.gridy = 9;
        JButton boton = new JButton("ACEPTAR");
        boton.setFont(letra);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    a_productos objeto_producto = new a_productos();
                    String nombre = nom.getText();
                    String descripcion = des.getText();
                    int cantidad = Integer.parseInt(can.getText());
                    int codigo = Integer.parseInt(cod.getText());
                    String etiq = comboBox.getSelectedItem().toString();
                    boolean llenado = nombre != "" && descripcion != "";
                    boolean val_codigo = String.valueOf(Math.abs(codigo)).length() == 9;
                    if (llenado && val_codigo && objeto_producto.val_codigo(cod.getText())) {
                        objeto_producto.agregarProducto(nombre, descripcion, cantidad, codigo, etiq, selectFile);
                    } else {
                        if (!objeto_producto.val_codigo(cod.getText())) {
                            JOptionPane.showMessageDialog(null, "CODIGO DE BARRAS YA UTILIZADO");
                        } else {
                            JOptionPane.showMessageDialog(null, "ERROR EN LOS DATOS, PORFAVOR TOMA EN CUENTA QUE DEBES COMPLETAR LOS DATOS Y EL CODIGO DE BARRAS DEBE TENER SOLO 9 DIGITOS");
                            System.out.println(String.valueOf(Math.abs(codigo)).length());
                        }

                    }

                } catch (Exception rs) {
                    JOptionPane.showMessageDialog(null, "ERROR EN LOS DATOS, PORFAVOR TOMA EN CUENTA QUE DEBES COMPLETAR LOS DATOS Y EL CODIGO DE BARRAS DEBE TENER SOLO 9 DIGITOS");
                }

            }
        });
        panel.add(boton, gbc3);

        return panel;
    }

    public void rellenarSoli() {
        a_productos sol = new a_productos();
        sol.consulta();

        ArrayList<String> nombres = sol.getNombres();
        ArrayList<String> descripciones = sol.getDescripciones();
        ArrayList<Integer> cantidades = sol.getCantidades();
        ArrayList<Integer> codigos = sol.getCodigos();
        ArrayList<String> etiquetas = sol.getEtiquetas();
        ArrayList<byte[]> imageBytes = sol.getImageBytes();
        ArrayList<Image> foto = new ArrayList<>();

        int totalElementos = nombres.size();
        int elementosPorPagina = 15;
        int totalPaginas = (int) Math.ceil((double) totalElementos / elementosPorPagina);

        for (int i = 0; i < imageBytes.size(); i++) {
            foto.add(null);
            if (imageBytes.get(i) != null) {
                try {
                    ImageIcon imageIcon = new ImageIcon(imageBytes.get(i));
                    foto.add(i, imageIcon.getImage());
                } catch (Exception d) {
                    JOptionPane.showMessageDialog(null, "ERROR: " + d.toString());
                }
            }
        }

        for (int pagina = 0; pagina < totalPaginas; pagina++) {
            final int pag = pagina;
            JPanel panelPagina = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    int indice = pagina * elementosPorPagina + i * 5 + j;
                    if (indice < totalElementos) {
                        gbc.gridy = i;
                        gbc.gridx = j;
                        gbc.insets = new Insets(10, 10, 10, 10);
                        panelPagina.add(solicitar(nombres.get(indice), cantidades.get(indice).toString(), codigos.get(indice).toString(), foto.get(indice)), gbc);
                    }
                }
            }
            String txtnxt = "Pagina " + (pagina + 1);
            String txtbk = "Pagina " + (pagina - 1);
//        System.out.println(txtnxt);
//        System.out.println(txtbk);
//        System.out.println(pag);
            if (totalPaginas > 1) {
                if (pagina == 0) {
                    gbc.gridy = 4;
                    gbc.gridx = 5;
                    JButton next = new JButton("SIGUIENTE");
                    next.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cardLayout2.show(soli, txtnxt);
//                System.out.println("SIGUIENTE");
                        }
                    });
                    next.setFont(letra);
                    panelPagina.add(next, gbc);
                } else if (pagina == totalPaginas - 1) {
                    gbc.gridy = 4;
                    gbc.gridx = 0;
                    JButton back = new JButton("ATRAS");
                    back.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cardLayout2.show(soli, txtbk);
                        }
                    });
                    back.setFont(letra);
                    panelPagina.add(back, gbc);
                } else {
                    gbc.gridy = 4;
                    gbc.gridx = 5;
                    JButton next = new JButton("SIGUIENTE");
                    next.setFont(letra);
                    next.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cardLayout2.show(soli, txtnxt);
                        }
                    });

                    panelPagina.add(next, gbc);
                    gbc.gridy = 4;
                    gbc.gridx = 0;
                    JButton back = new JButton("ATRAS");
                    back.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cardLayout2.show(soli, txtbk);
                        }
                    });
                    back.setFont(letra);
                    panelPagina.add(back, gbc);
                }
            }

            soli.add(panelPagina, "Pagina " + (pagina));
        }

        ((CardLayout) soli.getLayout()).first(soli);
    }

    public void rellenarModi() {
        a_productos sol = new a_productos();
        sol.consulta();

        ArrayList<String> nombres = sol.getNombres();
        ArrayList<String> descripciones = sol.getDescripciones();
        ArrayList<Integer> cantidades = sol.getCantidades();
        ArrayList<Integer> codigos = sol.getCodigos();
        ArrayList<String> etiquetas = sol.getEtiquetas();
        ArrayList<byte[]> imageBytes = sol.getImageBytes();
        ArrayList<Image> foto = new ArrayList<>();
        

        int totalElementos = nombres.size();
        int elementosPorPagina = 15;
        int totalPaginas = (int) Math.ceil((double) totalElementos / elementosPorPagina);
        
         for (int i = 0; i < imageBytes.size(); i++) {
            foto.add(null);
            if (imageBytes.get(i) != null) {
                try {
                    ImageIcon imageIcon = new ImageIcon(imageBytes.get(i));
                    foto.add(i, imageIcon.getImage());
                } catch (Exception d) {
                    JOptionPane.showMessageDialog(null, "ERROR: " + d.toString());
                }
            }
        }


        for (int pagina = 0; pagina < totalPaginas; pagina++) {
            final int pag = pagina;
            JPanel panelPagina = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    int indice = pagina * elementosPorPagina + i * 5 + j;
                    if (indice < totalElementos) {
                        gbc.gridy = i;
                        gbc.gridx = j;
                        gbc.insets = new Insets(10, 10, 10, 10);
                        panelPagina.add(Modificar(nombres.get(indice), cantidades.get(indice).toString(), codigos.get(indice).toString(),foto.get(indice)), gbc);
                    }
                }
            }
            String txtnxt = "Pagina " + (pagina + 1);
            String txtbk = "Pagina " + (pagina - 1);
//        System.out.println(txtnxt);
//        System.out.println(txtbk);
//        System.out.println(pag);
            if (totalPaginas > 1) {
                if (pagina == 0) {
                    gbc.gridy = 4;
                    gbc.gridx = 5;
                    JButton next = new JButton("SIGUIENTE");
                    next.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cardLayout3.show(modi, txtnxt);
//                System.out.println("SIGUIENTE");
                        }
                    });
                    next.setFont(letra);
                    panelPagina.add(next, gbc);
                } else if (pagina == totalPaginas - 1) {
                    gbc.gridy = 4;
                    gbc.gridx = 0;
                    JButton back = new JButton("ATRAS");
                    back.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cardLayout3.show(modi, txtbk);
                        }
                    });
                    back.setFont(letra);
                    panelPagina.add(back, gbc);
                } else {
                    gbc.gridy = 4;
                    gbc.gridx = 5;
                    JButton next = new JButton("SIGUIENTE");
                    next.setFont(letra);
                    next.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cardLayout3.show(modi, txtnxt);
                        }
                    });

                    panelPagina.add(next, gbc);
                    gbc.gridy = 4;
                    gbc.gridx = 0;
                    JButton back = new JButton("ATRAS");
                    back.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cardLayout3.show(modi, txtbk);
                        }
                    });
                    back.setFont(letra);
                    panelPagina.add(back, gbc);
                }
            }

            modi.add(panelPagina, "Pagina " + (pagina));
        }
        ((CardLayout) modi.getLayout()).first(modi);
    }
    
    public void actualizarSoli(){
        cardLayout.show(contenido, "Solicitar");
                soli.removeAll();
                rellenarSoli();
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
                soli.removeAll();
                rellenarSoli();
                break;
            case "Modificar":
                // Aquí va el código que quieres que se ejecute cuando se presione el botón 3
                cardLayout.show(contenido, "Modificar");
                modi.removeAll();
                rellenarModi();
                break;
            case "Estadisticas":
                // Aquí va el código que quieres que se ejecute cuando se presione el botón 3
                cardLayout.show(contenido, "Estadisticas");
                break;
        }
    }

}
