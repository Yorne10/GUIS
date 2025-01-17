/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BD.a_productos;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author ANGEL BARON GARCIA
 */
public class PLATAFORMA_US extends JFrame implements ActionListener {

    JLabel titulo;
    JPanel title_pan, back, menu, pos, bus;
    Font letra_titulo = new Font("Lucida Sans", Font.BOLD, 50);
    Font letra_boton = new Font("Lucida Sans", Font.PLAIN, 27);
    JLabel txt_busqueda;
    JTextField busqueda;
    JButton buscar;
    String[] tit_button = {"TODOS", "LIMPIEZA", "HOGAR", "SALUD", "MASCOTAS", "CARRITO"};
    Color btn_dentro = new Color(155, 35, 161);
    Color btn_fuera = new Color(153, 1, 160);
    JPanel catalogo, todos, limpieza, hogar, salud, mascotas, carrito, busq, carrito_comp;
    CardLayout cardLayout = new CardLayout();
    CardLayout cardLayout2 = new CardLayout();
    CardLayout cardLayout3 = new CardLayout();
    CardLayout cardLayout4 = new CardLayout();
    CardLayout cardLayout5 = new CardLayout();
    CardLayout cardLayout6 = new CardLayout();
    CardLayout cardLayout7 = new CardLayout();
    CardLayout cardLayout8 = new CardLayout();

    PLATAFORMA_US obj = this;

    ArrayList<Integer> carrito_barras = new ArrayList<>();
    ArrayList<Integer> carrito_cant = new ArrayList<>();
    HashMap<Integer, Integer> cod_can = new HashMap<>();

    GridBagConstraints gbc7 = new GridBagConstraints();
    GridBagConstraints gbc5 = new GridBagConstraints();
    Font letra = new Font("Lucida Sans", Font.PLAIN, 27);

    ArrayList<String> nombres_g = new ArrayList<>();
    ArrayList<String> descripciones_g = new ArrayList<>();
    ArrayList<Integer> cantidades_g = new ArrayList<>();
    ArrayList<Integer> codigos_g = new ArrayList<>();
    ArrayList<String> etiquetas_g = new ArrayList<>();
    ArrayList<Image> imageBytes_g = new ArrayList<>();
    ArrayList<Image> foto_g = new ArrayList<>();
    ArrayList<Integer> disponible_g = new ArrayList<>();
    ArrayList<Integer> vendidos_g = new ArrayList<>();
    ArrayList<Integer> precio_g = new ArrayList<>();
    JLabel total;
    JButton pag;

    public PLATAFORMA_US() {
        setTitle("MENU_USUARIO");
        setIconImage(new ImageIcon(getClass().getResource("/IMAGENES/carro.png")).getImage());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
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
        title_pan.setBounds(0, 0, this.getWidth(), 80);
        // title_pan.setBackground(Color.blue);
        titulo = new JLabel("BIENVENIDO A SUPER EXPRESS");
        titulo.setFont(letra_titulo);
        titulo.setSize(1000, 40);

        title_pan.add(titulo);
        gbc.gridx = 0;
        gbc.gridy = 0;
        back.add(title_pan, gbc);
        //PANEL QUE CONTENDRA EL MENU
        menu = new JPanel(new FlowLayout());
        menu.setBackground(Color.white);

        menu.setSize(this.getWidth(), 100);
        for (int i = 0; i < tit_button.length; i++) {
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
        gbc.gridy = 1;
        back.add(menu, gbc);
        gbc.gridy = 2;

        bus = new JPanel(new FlowLayout());
        bus.setBackground(Color.white);
        bus.setSize(this.getWidth(), 100);
        txt_busqueda = new JLabel("BUSCAR:");
        bus.add(txt_busqueda, gbc);

        busqueda = new JTextField();
        busqueda.setPreferredSize(new Dimension(500, 40));
        bus.add(busqueda, gbc);

        buscar = new JButton("BUSCAR");
        buscar.setPreferredSize(new Dimension(100, 40));
        buscar.addActionListener(this);
        bus.add(buscar, gbc);

        back.add(bus, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        catalogo = new JPanel();
        catalogo.setLayout(cardLayout);
        todos = new JPanel();
        todos.setLayout(cardLayout2);
        limpieza = new JPanel();
        limpieza.setLayout(cardLayout3);
        hogar = new JPanel();
        hogar.setLayout(cardLayout4);
        salud = new JPanel();
        salud.setLayout(cardLayout5);
        mascotas = new JPanel();
        mascotas.setLayout(cardLayout6);

        carrito = new JPanel();
        carrito.setLayout(cardLayout7);

        busq = new JPanel();
        busq.setLayout(cardLayout8);

        carrito_comp = new JPanel(new GridBagLayout());
        gbc5.gridx = 0;
        gbc5.gridy = 0;
        carrito_comp.add(carrito, gbc5);

        gbc5.gridy = 1;
        total = new JLabel("TOTAL: $ " + sum());
        total.setFont(letra_titulo);
        carrito_comp.add(total, gbc5);
        gbc5.gridx = 1;
        pag = new JButton("PAGAR");
        pag.setFont(letra_titulo);
        pag.addActionListener((ActionEvent e) -> {
            if (!nombres_g.isEmpty()) {

                String nombre_us = JOptionPane.showInputDialog("COLOQUE SU NOMBRE: ");
                String correo = JOptionPane.showInputDialog("COLOQUE SU CORREO:");

                String lista = "";

                if (nombre_us.matches("[a-zA-Z]+") && correo.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{3,}")) {
                    a_productos n_venta = new a_productos();
                    int v_limp = 0;
                    int v_ho = 0;
                    int v_sa = 0;
                    int v_masc = 0;
                    for (int i = 0; i < nombres_g.size(); i++) {
                        String nombre = nombres_g.get(i);
                        int cantidad = cantidades_g.get(i);
                        double precio = precio_g.get(i);
                        switch (etiquetas_g.get(i)) {
                            case "LIMPIEZA":
                                v_limp += cantidades_g.get(i) * precio_g.get(i);
                                break;
                            case "HOGAR":
                                v_ho += cantidades_g.get(i) * precio_g.get(i);
                                break;
                            case "SALUD":
                                v_sa += cantidades_g.get(i) * precio_g.get(i);
                                break;
                            case "MASCOTAS":
                                v_masc += cantidades_g.get(i) * precio_g.get(i);
                                break;
                        }
                        n_venta.sumar_vend(codigos_g.get(i), cantidades_g.get(i));
                        n_venta.quitar_p(cantidades_g.get(i), codigos_g.get(i));
                        lista += String.format("%-20s x%-10d $%.2f%n", nombre, cantidad, precio);

                    }
                    try {

                        n_venta.agregarPedido(nombre_us, correo, sum(), lista);
                        n_venta.sumar_eti("LIMPIEZA", v_limp);
                        n_venta.sumar_eti("HOGAR", v_ho);
                        n_venta.sumar_eti("SALUD", v_sa);
                        n_venta.sumar_eti("MASCOTAS", v_masc);
                        n_venta.sumar_total(sum());
                        
                        nombres_g.clear();
                        cantidades_g.clear();
                        codigos_g.clear();
                        foto_g.clear();
                        etiquetas_g.clear();
                        precio_g.clear();
                        cod_can.clear();
                        carrito.removeAll();
                        rellenarCarrito();
                        cardLayout.show(catalogo, "Carrito");
                        total.setText("TOTAL: $" + sum());
                        

                    } catch (Exception r) {

                    }
                } else {
                    if (!nombre_us.matches("[a-zA-Z]+")) {
                        JOptionPane.showMessageDialog(this, "Por favor, ingresa un nombre válido (solo letras).", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                    // Validar correo electrónico con expresión regular
                    if (!correo.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{3,}")) {
                        JOptionPane.showMessageDialog(this, "Por favor, ingresa un correo electrónico válido.", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "AÑADA PRODUCTOS AL CARRITO");
            }
        });
        carrito_comp.add(pag, gbc5);

        catalogo.add(todos, "Todos");
        catalogo.add(limpieza, "Limpieza");
        catalogo.add(hogar, "Hogar");
        catalogo.add(salud, "Salud");
        catalogo.add(mascotas, "Mascotas");
        catalogo.add(carrito_comp, "Carrito");
        catalogo.add(busq, "Busqueda");

        back.add(catalogo, gbc);

        pos.add(back, BorderLayout.NORTH);
        add(pos);

    }

    public int sum() {
        int s = 0;
        System.out.println(precio_g.size());
        for (int i = 0; i < precio_g.size(); i++) {
            s += precio_g.get(i) * cantidades_g.get(i);
            System.out.println(s);
        }

        return s;
    }

    public void rellenarLimpieza() {
        a_productos sol = new a_productos();
        sol.buscar_limpieza();

        ArrayList<String> nombres = sol.getNombres();
        ArrayList<String> descripciones = sol.getDescripciones();
        ArrayList<Integer> cantidades = sol.getCantidades();
        ArrayList<Integer> codigos = sol.getCodigos();
        ArrayList<String> etiquetas = sol.getEtiquetas();
        ArrayList<byte[]> imageBytes = sol.getImageBytes();
        ArrayList<Image> foto = new ArrayList<>();
        ArrayList<Integer> disponible = sol.getDisponible();
        ArrayList<Integer> vendidos = sol.getVendidos();
        ArrayList<Integer> precio = sol.getPrecio();

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
            panelPagina.setBackground(Color.white);
            GridBagConstraints gbc = new GridBagConstraints();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    int indice = pagina * elementosPorPagina + i * 5 + j;
                    if (indice < totalElementos) {
                        gbc.gridy = i;
                        gbc.gridx = j;
                        gbc.insets = new Insets(10, 10, 10, 10);
                        panelPagina.add(RELLENAR(nombres.get(indice), cantidades.get(indice).toString(), codigos.get(indice).toString(), foto.get(indice), descripciones.get(indice), etiquetas.get(indice), disponible.get(indice), vendidos.get(indice), precio.get(indice)), gbc);
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
                            cardLayout3.show(limpieza, txtnxt);
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
                            cardLayout3.show(limpieza, txtbk);
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
                            cardLayout3.show(limpieza, txtnxt);
                        }
                    });

                    panelPagina.add(next, gbc);
                    gbc.gridy = 4;
                    gbc.gridx = 0;
                    JButton back = new JButton("ATRAS");
                    back.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cardLayout3.show(limpieza, txtbk);
                        }
                    });
                    back.setFont(letra);
                    panelPagina.add(back, gbc);
                }
            }

            limpieza.add(panelPagina, "Pagina " + (pagina));
        }
        ((CardLayout) limpieza.getLayout()).first(limpieza);
    }

    public void rellenarHogar() {
        a_productos sol = new a_productos();
        sol.buscar_hogar();

        ArrayList<String> nombres = sol.getNombres();
        ArrayList<String> descripciones = sol.getDescripciones();
        ArrayList<Integer> cantidades = sol.getCantidades();
        ArrayList<Integer> codigos = sol.getCodigos();
        ArrayList<String> etiquetas = sol.getEtiquetas();
        ArrayList<byte[]> imageBytes = sol.getImageBytes();
        ArrayList<Image> foto = new ArrayList<>();
        ArrayList<Integer> disponible = sol.getDisponible();
        ArrayList<Integer> vendidos = sol.getVendidos();
        ArrayList<Integer> precio = sol.getPrecio();

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
            panelPagina.setBackground(Color.white);
            GridBagConstraints gbc = new GridBagConstraints();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    int indice = pagina * elementosPorPagina + i * 5 + j;
                    if (indice < totalElementos) {
                        gbc.gridy = i;
                        gbc.gridx = j;
                        gbc.insets = new Insets(10, 10, 10, 10);
                        panelPagina.add(RELLENAR(nombres.get(indice), cantidades.get(indice).toString(), codigos.get(indice).toString(), foto.get(indice), descripciones.get(indice), etiquetas.get(indice), disponible.get(indice), vendidos.get(indice), precio.get(indice)), gbc);
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
                            cardLayout4.show(hogar, txtnxt);
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
                            cardLayout4.show(hogar, txtbk);
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
                            cardLayout4.show(hogar, txtnxt);
                        }
                    });

                    panelPagina.add(next, gbc);
                    gbc.gridy = 4;
                    gbc.gridx = 0;
                    JButton back = new JButton("ATRAS");
                    back.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cardLayout4.show(hogar, txtbk);
                        }
                    });
                    back.setFont(letra);
                    panelPagina.add(back, gbc);
                }
            }

            hogar.add(panelPagina, "Pagina " + (pagina));
        }
        ((CardLayout) hogar.getLayout()).first(hogar);
    }

    public void rellenarSalud() {
        a_productos sol = new a_productos();
        sol.buscar_salud();

        ArrayList<String> nombres = sol.getNombres();
        ArrayList<String> descripciones = sol.getDescripciones();
        ArrayList<Integer> cantidades = sol.getCantidades();
        ArrayList<Integer> codigos = sol.getCodigos();
        ArrayList<String> etiquetas = sol.getEtiquetas();
        ArrayList<byte[]> imageBytes = sol.getImageBytes();
        ArrayList<Image> foto = new ArrayList<>();
        ArrayList<Integer> disponible = sol.getDisponible();
        ArrayList<Integer> vendidos = sol.getVendidos();
        ArrayList<Integer> precio = sol.getPrecio();

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
            panelPagina.setBackground(Color.white);
            GridBagConstraints gbc = new GridBagConstraints();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    int indice = pagina * elementosPorPagina + i * 5 + j;
                    if (indice < totalElementos) {
                        gbc.gridy = i;
                        gbc.gridx = j;
                        gbc.insets = new Insets(10, 10, 10, 10);
                        panelPagina.add(RELLENAR(nombres.get(indice), cantidades.get(indice).toString(), codigos.get(indice).toString(), foto.get(indice), descripciones.get(indice), etiquetas.get(indice), disponible.get(indice), vendidos.get(indice), precio.get(indice)), gbc);
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
                            cardLayout5.show(salud, txtnxt);
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
                            cardLayout5.show(salud, txtbk);
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
                            cardLayout5.show(salud, txtnxt);
                        }
                    });

                    panelPagina.add(next, gbc);
                    gbc.gridy = 4;
                    gbc.gridx = 0;
                    JButton back = new JButton("ATRAS");
                    back.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cardLayout5.show(salud, txtbk);
                        }
                    });
                    back.setFont(letra);
                    panelPagina.add(back, gbc);
                }
            }

            hogar.add(panelPagina, "Pagina " + (pagina));
        }
        ((CardLayout) salud.getLayout()).first(salud);
    }

    public void rellenarMascotas() {
        a_productos sol = new a_productos();
        sol.buscar_salud();

        ArrayList<String> nombres = sol.getNombres();
        ArrayList<String> descripciones = sol.getDescripciones();
        ArrayList<Integer> cantidades = sol.getCantidades();
        ArrayList<Integer> codigos = sol.getCodigos();
        ArrayList<String> etiquetas = sol.getEtiquetas();
        ArrayList<byte[]> imageBytes = sol.getImageBytes();
        ArrayList<Image> foto = new ArrayList<>();
        ArrayList<Integer> disponible = sol.getDisponible();
        ArrayList<Integer> vendidos = sol.getVendidos();
        ArrayList<Integer> precio = sol.getPrecio();

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
            panelPagina.setBackground(Color.white);
            GridBagConstraints gbc = new GridBagConstraints();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    int indice = pagina * elementosPorPagina + i * 5 + j;
                    if (indice < totalElementos) {
                        gbc.gridy = i;
                        gbc.gridx = j;
                        gbc.insets = new Insets(10, 10, 10, 10);
                        panelPagina.add(RELLENAR(nombres.get(indice), cantidades.get(indice).toString(), codigos.get(indice).toString(), foto.get(indice), descripciones.get(indice), etiquetas.get(indice), disponible.get(indice), vendidos.get(indice), precio.get(indice)), gbc);
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
                            cardLayout6.show(mascotas, txtnxt);
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
                            cardLayout6.show(mascotas, txtbk);
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
                            cardLayout6.show(mascotas, txtnxt);
                        }
                    });

                    panelPagina.add(next, gbc);
                    gbc.gridy = 4;
                    gbc.gridx = 0;
                    JButton back = new JButton("ATRAS");
                    back.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cardLayout6.show(mascotas, txtbk);
                        }
                    });
                    back.setFont(letra);
                    panelPagina.add(back, gbc);
                }
            }

            hogar.add(panelPagina, "Pagina " + (pagina));
        }
        ((CardLayout) mascotas.getLayout()).first(mascotas);
    }

    public void rellenarTodos() {
        a_productos sol = new a_productos();
        sol.consulta();

        ArrayList<String> nombres = sol.getNombres();
        ArrayList<String> descripciones = sol.getDescripciones();
        ArrayList<Integer> cantidades = sol.getCantidades();
        ArrayList<Integer> codigos = sol.getCodigos();
        ArrayList<String> etiquetas = sol.getEtiquetas();
        ArrayList<byte[]> imageBytes = sol.getImageBytes();
        ArrayList<Image> foto = new ArrayList<>();
        ArrayList<Integer> disponible = sol.getDisponible();
        ArrayList<Integer> vendidos = sol.getVendidos();
        ArrayList<Integer> precio = sol.getPrecio();
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
            panelPagina.setBackground(Color.white);
            GridBagConstraints gbc = new GridBagConstraints();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    int indice = pagina * elementosPorPagina + i * 5 + j;
                    if (indice < totalElementos) {
                        gbc.gridy = i;
                        gbc.gridx = j;
                        gbc.insets = new Insets(10, 10, 10, 10);
                        panelPagina.add(RELLENAR(nombres.get(indice), cantidades.get(indice).toString(), codigos.get(indice).toString(), foto.get(indice), descripciones.get(indice), etiquetas.get(indice), disponible.get(indice), vendidos.get(indice), precio.get(indice)), gbc);
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
                            cardLayout2.show(todos, txtnxt);
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
                            cardLayout2.show(todos, txtbk);
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
                            cardLayout2.show(todos, txtnxt);
                        }
                    });

                    panelPagina.add(next, gbc);
                    gbc.gridy = 4;
                    gbc.gridx = 0;
                    JButton back = new JButton("ATRAS");
                    back.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cardLayout2.show(todos, txtbk);
                        }
                    });
                    back.setFont(letra);
                    panelPagina.add(back, gbc);
                }
            }

            todos.add(panelPagina, "Pagina " + (pagina));
        }
        ((CardLayout) todos.getLayout()).first(todos);
    }

    public JPanel RELLENAR(String nombre, String can, String codigo, Image m, String descri, String eti, int dis, int vend, int pre) {

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.white);
        gbc7.gridx = 0;
        gbc7.gridy = 0;
        JLabel nom = new JLabel("Nombre");

        panel.add(nom, gbc7);
        JLabel n = new JLabel(nombre);
        gbc7.gridy = 1;
        panel.add(n, gbc7);
        JLabel txtCan = new JLabel("Precio");
        gbc7.gridy = 2;
        panel.add(txtCan, gbc7);
        JLabel cn = new JLabel(pre + "");
        gbc7.gridy = 3;
        panel.add(cn, gbc7);

        gbc7.gridy = 4;
        JLabel ft = new JLabel();
        ft.setPreferredSize(new Dimension(75, 75));
        panel.add(ft, gbc7);

        ImageIcon originalIcon = new ImageIcon(m);

        int lblwidth = ft.getWidth();
        int lblheight = ft.getHeight();

        Image scalImage = originalIcon.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ft.setIcon(new ImageIcon(scalImage));

        JButton boton = new JButton("Añadir");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int c = Integer.parseInt(JOptionPane.showInputDialog(null, "¿CUANTOS PRODUCTOS QUIERES?"));
                    int it = 0;
                    if (cod_can.containsKey(Integer.valueOf(codigo))) {

                        for (int i = 0; i < codigos_g.size(); i++) {
//                        System.out.println("CICLO FOR DESPUES");
//                        System.out.println();
                            if (Objects.equals(codigos_g.get(i), Integer.valueOf(codigo))) {
//                            System.out.println(cantidades_g.get(i));
                                c += cantidades_g.get(i);
                                it = i;
                            }
                        }
                        if (c > Integer.parseInt(can)) {
                            JOptionPane.showMessageDialog(null, "LA CANTIDAD AÑADIDA EXCEDE EL LIMITE");
                        } else if (c < 0) {
                            JOptionPane.showMessageDialog(null, "LA CANTIDAD AÑADIDA Y EL ANTERIOR DA NUMERO NEGATIVO");
                        } else {
                            cod_can.put(Integer.valueOf(codigo), c);
                            cantidades_g.set(it, c);
                        }

                    } else {
                        System.out.println("NO HAY LLAVE");
                        System.out.println(codigo);

                        if (c > Integer.parseInt(can)) {
                            JOptionPane.showMessageDialog(null, "LA CANTIDAD EXCEDE DEL LIMITE");
                        } else if (c < 0) {
                            JOptionPane.showMessageDialog(null, "LA CANTIDAD TIENE QUE SER MÁS DE 1");
                        } else {
                            nombres_g.add(nombre);
                            cantidades_g.add(c);
                            codigos_g.add(Integer.valueOf(codigo));
                            precio_g.add(pre);
                            etiquetas_g.add(eti);
                            imageBytes_g.add(m);
                            cod_can.put(Integer.valueOf(codigo), c);
                        }
                    }
                } catch (Exception s) {
                    JOptionPane.showMessageDialog(null, "ERROR EN LOS DATOS");
                }
            }

        });
        gbc7.gridy = 5;
        panel.add(boton, gbc7);

        JButton boton2 = new JButton("Ver mas");
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI_ver_mas inicio = new GUI_ver_mas(nombre, descri, Integer.parseInt(codigo), Integer.parseInt(can), m, pre, obj, eti);
            }

        });
        gbc7.gridy = 6;
        panel.add(boton2, gbc7);

        return panel;
    }

    public JPanel RELLENAR_C(String nombre, String can, String codigo, Image m, String eti, int pre, int indice) {

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.white);
        gbc7.gridx = 0;
        gbc7.gridy = 0;
        JLabel nom = new JLabel("Nombre");

        panel.add(nom, gbc7);
        JLabel n = new JLabel(nombre);
        gbc7.gridy = 1;
        panel.add(n, gbc7);
        JLabel txtCan = new JLabel("Precio");
        gbc7.gridy = 2;
        panel.add(txtCan, gbc7);
        JLabel cn = new JLabel(pre + "");
        gbc7.gridy = 3;
        panel.add(cn, gbc7);
        gbc7.gridy = 4;
        JLabel txtCann = new JLabel("Cantidad");
        panel.add(txtCann, gbc7);
        gbc7.gridy = 5;
        JLabel c = new JLabel(can);
        panel.add(c, gbc7);

        gbc7.gridy = 6;
        JLabel ft = new JLabel();
        ft.setPreferredSize(new Dimension(75, 75));
        panel.add(ft, gbc7);

        ImageIcon originalIcon = new ImageIcon(m);

        int lblwidth = ft.getWidth();
        int lblheight = ft.getHeight();

        Image scalImage = originalIcon.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ft.setIcon(new ImageIcon(scalImage));

        gbc7.gridy = 7;

        JButton canc = new JButton("ELIMINAR");
        canc.addActionListener((ActionEvent e) -> {
            nombres_g.remove(indice);
            cantidades_g.remove(indice);
            codigos_g.remove(indice);
            foto_g.remove(indice);
            etiquetas_g.remove(indice);
            precio_g.remove(indice);
            cod_can.remove(Integer.valueOf(codigo));
            carrito.removeAll();
            rellenarCarrito();
            cardLayout.show(catalogo, "Carrito");
            total.setText("TOTAL: $" + sum());
        });
        panel.add(canc, gbc7);

        return panel;
    }

    public void rellenarCarrito() {

        int totalElementos = nombres_g.size();
        int elementosPorPagina = 15;
        int totalPaginas = (int) Math.ceil((double) totalElementos / elementosPorPagina);

        for (int i = 0; i < imageBytes_g.size(); i++) {
            foto_g.add(null);
            if (imageBytes_g.get(i) != null) {
                try {
                    ImageIcon imageIcon = new ImageIcon(imageBytes_g.get(i));
                    foto_g.add(i, imageIcon.getImage());
                } catch (Exception d) {
                    JOptionPane.showMessageDialog(null, "ERROR: " + d.toString());
                }
            }
        }

        for (int pagina = 0; pagina < totalPaginas; pagina++) {
            final int pag = pagina;
            JPanel panelPagina = new JPanel(new GridBagLayout());
            panelPagina.setBackground(Color.white);
            GridBagConstraints gbc = new GridBagConstraints();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    int indice = pagina * elementosPorPagina + i * 5 + j;
                    if (indice < totalElementos) {
                        gbc.gridy = i;
                        gbc.gridx = j;
                        gbc.insets = new Insets(10, 10, 10, 10);
                        panelPagina.add(RELLENAR_C(nombres_g.get(indice), cantidades_g.get(indice).toString(), codigos_g.get(indice).toString(), foto_g.get(indice), etiquetas_g.get(indice), precio_g.get(indice), indice), gbc);
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
                            cardLayout7.show(carrito, txtnxt);
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
                            cardLayout7.show(carrito, txtbk);
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
                            cardLayout7.show(carrito, txtnxt);
                        }
                    });

                    panelPagina.add(next, gbc);
                    gbc.gridy = 4;
                    gbc.gridx = 0;
                    JButton back = new JButton("ATRAS");
                    back.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cardLayout7.show(carrito, txtbk);
                        }
                    });
                    back.setFont(letra);
                    panelPagina.add(back, gbc);
                }
            }

            carrito.add(panelPagina, "Pagina " + (pagina));
        }
        ((CardLayout) carrito.getLayout()).first(carrito);
    }

    public void rellenarBusq(String nom) {
        a_productos sol = new a_productos();
        sol.consulta_busq(nom);

        ArrayList<String> nombres = sol.getNombres();
        ArrayList<String> descripciones = sol.getDescripciones();
        ArrayList<Integer> cantidades = sol.getCantidades();
        ArrayList<Integer> codigos = sol.getCodigos();
        ArrayList<String> etiquetas = sol.getEtiquetas();
        ArrayList<byte[]> imageBytes = sol.getImageBytes();
        ArrayList<Image> foto = new ArrayList<>();
        ArrayList<Integer> disponible = sol.getDisponible();
        ArrayList<Integer> vendidos = sol.getVendidos();
        ArrayList<Integer> precio = sol.getPrecio();
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
            panelPagina.setBackground(Color.white);
            GridBagConstraints gbc = new GridBagConstraints();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    int indice = pagina * elementosPorPagina + i * 5 + j;
                    if (indice < totalElementos) {
                        gbc.gridy = i;
                        gbc.gridx = j;
                        gbc.insets = new Insets(10, 10, 10, 10);
                        panelPagina.add(RELLENAR(nombres.get(indice), cantidades.get(indice).toString(), codigos.get(indice).toString(), foto.get(indice), descripciones.get(indice), etiquetas.get(indice), disponible.get(indice), vendidos.get(indice), precio.get(indice)), gbc);
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
                            cardLayout8.show(busq, txtnxt);
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
                            cardLayout8.show(busq, txtbk);
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
                            cardLayout8.show(busq, txtnxt);
                        }
                    });

                    panelPagina.add(next, gbc);
                    gbc.gridy = 4;
                    gbc.gridx = 0;
                    JButton back = new JButton("ATRAS");
                    back.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cardLayout8.show(busq, txtbk);
                        }
                    });
                    back.setFont(letra);
                    panelPagina.add(back, gbc);
                }
            }

            busq.add(panelPagina, "Pagina " + (pagina));
        }
        ((CardLayout) busq.getLayout()).first(busq);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botonPresionado = (JButton) e.getSource();
        String textoBoton = botonPresionado.getLabel();

        if (e.getSource() == buscar) {
            busq.removeAll();
            if (busqueda.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "COLOQUE UN NOMBRE DE ALGUN PRODUCTO QUE BUSQUE");
            } else {
                rellenarBusq(busqueda.getText());
                cardLayout.show(catalogo, "Busqueda");
            }

        }

        switch (textoBoton) {
            case "TODOS":
                // Aquí va el código que quieres que se ejecute cuando se presione el botón 1
                System.out.println("Presionaste el botón 1");
                todos.removeAll();
                rellenarTodos();
                cardLayout.show(catalogo, "Todos");
                break;
            case "LIMPIEZA":
                // Aquí va el código que quieres que se ejecute cuando se presione el botón 2
                System.out.println("Presionaste el botón 2");
                limpieza.removeAll();
                rellenarLimpieza();
                cardLayout.show(catalogo, "Limpieza");
                break;
            case "HOGAR":
                // Aquí va el código que quieres que se ejecute cuando se presione el botón 3
                System.out.println("Presionaste el botón 3");
                hogar.removeAll();
                rellenarHogar();
                cardLayout.show(catalogo, "Hogar");
                break;
            case "SALUD":
                // Aquí va el código que quieres que se ejecute cuando se presione el botón 3
                System.out.println("Presionaste el botón 3");
                salud.removeAll();
                rellenarSalud();
                cardLayout.show(catalogo, "Salud");
                break;
            case "MASCOTAS":
                // Aquí va el código que quieres que se ejecute cuando se presione el botón 3
                System.out.println("Presionaste el botón 3");
                mascotas.removeAll();
                rellenarLimpieza();
                cardLayout.show(catalogo, "Mascotas");
                break;
            case "CARRITO":
                carrito.removeAll();
                rellenarCarrito();
                cardLayout.show(catalogo, "Carrito");
                total.setText("TOTAL: $" + sum());
                System.out.println("Presionaste el botón CARRITO");
                break;

        }
    }
}
