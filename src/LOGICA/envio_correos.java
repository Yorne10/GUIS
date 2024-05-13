/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author lucho
 */
public class envio_correos {
    public void enviarCorreo_pedido_usuario(String correoUsuario, String nombreProducto, String codigoProducto, int cantidad, double precio) {
        // Configuración del servidor de correo
        String host = "smtp.gmail.com";
        String puerto = "587";
        String usuario = "gaby100195@gmail.com";// correo desde donde se envia 
        String contraseña = "pfet muqt qvib vcow";

      
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", puerto);

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, contraseña);
            }
        });

        try {
            // Crear mensaje de correo de confirmación de compra
            Message mensajeConfirmacion = new MimeMessage(session);
            mensajeConfirmacion.setFrom(new InternetAddress(usuario));
            mensajeConfirmacion.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoUsuario));
            mensajeConfirmacion.setSubject("Confirmación de compra");
            mensajeConfirmacion.setText("Su compra ha sido confirmada.\n\nDetalles de la compra:\n\n"
                    + "Nombre del producto: " + nombreProducto + "\n"
                    + "Código del producto: " + codigoProducto + "\n"
                    + "Cantidad: " + cantidad + "\n"
                    + "Precio: " + precio + "\n\n"
                    + "¡Gracias por su compra!");

            // Enviar correo de confirmación de compra
            Transport.send(mensajeConfirmacion);

            System.out.println("Se ha enviado un correo de confirmación de compra a " + correoUsuario);
        } catch (MessagingException e) {
            System.out.println("Error al enviar el correo: " + e.getMessage());
        }
    }
    
    public void enviarCorreo_pedido_admin(String correoUsuario, String nombreProducto, String codigoProducto, int cantidad, double precio) {
        // Configuración del servidor de correo
        String host = "smtp.gmail.com";
        String puerto = "587";
        String usuario = "gaby100195@gmail.com";// correo desde donde se envia 
        String contraseña = "pfet muqt qvib vcow";

      
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", puerto);

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, contraseña);
            }
        });

        try {
            // Crear mensaje de correo de confirmación de compra
            Message mensajeConfirmacion = new MimeMessage(session);
            mensajeConfirmacion.setFrom(new InternetAddress(usuario));
            mensajeConfirmacion.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoUsuario));
            mensajeConfirmacion.setSubject("SOLICITUD DE PEDIDO");
            mensajeConfirmacion.setText("Hay una nueva solicitud de pedido.\n\n Detalles del pedido:\n\n"
                    + "Nombre del producto: " + nombreProducto + "\n"
                    + "Código del producto: " + codigoProducto + "\n"
                    + "Cantidad: " + cantidad + "\n"
                    + "Precio: " + precio + "\n\n"
                    + "¡Gracias por su compra!");

            // Enviar correo de confirmación de compra
            Transport.send(mensajeConfirmacion);

            System.out.println("Se ha enviado un correo de confirmación de compra a " + correoUsuario);
        } catch (MessagingException e) {
            System.out.println("Error al enviar el correo: " + e.getMessage());
        }
    }
    
    public void correo_agregar_producto(String correoUsuario, String nombreProducto, String codigoProducto, int cantidad, double precio,String des) {
        // Configuración del servidor de correo
        String host = "smtp.gmail.com";
        String puerto = "587";
        String usuario = "gaby100195@gmail.com";// correo desde donde se envia 
        String contraseña = "pfet muqt qvib vcow";

      
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", puerto);

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, contraseña);
            }
        });

        try {
            // Crear mensaje de correo de confirmación de compra
            Message mensajeConfirmacion = new MimeMessage(session);
            mensajeConfirmacion.setFrom(new InternetAddress(usuario));
            mensajeConfirmacion.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoUsuario));
            mensajeConfirmacion.setSubject("SOLICITUD DE PEDIDO");
            mensajeConfirmacion.setText("Hay una nueva solicitud de pedido.\n\n Detalles del pedido:\n\n"
                    + "Nombre del producto: " + nombreProducto + "\n"
                    + "Código del producto: " + codigoProducto + "\n"
                    + "Cantidad: " + cantidad + "\n"
                    + "Precio: " + precio + "\n\n"
                    + "Descripcion"    +          des      + "\n\n"
                    + "¡Gracias por su compra!");

            // Enviar correo de confirmación de compra
            Transport.send(mensajeConfirmacion);

            System.out.println("Se ha enviado un correo de confirmación de compra a " + correoUsuario);
        } catch (MessagingException e) {
            System.out.println("Error al enviar el correo: " + e.getMessage());
        }
    }
    
    public void correo_modificacion_producto(String correoUsuario, String nombreProducto, String codigoProducto, int cantidad, double precio,String des) {
        // Configuración del servidor de correo
        String host = "smtp.gmail.com";
        String puerto = "587";
        String usuario = "gaby100195@gmail.com";// correo desde donde se envia 
        String contraseña = "pfet muqt qvib vcow";

      
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", puerto);

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, contraseña);
            }
        });

        try {
            // Crear mensaje de correo de confirmación de compra
            Message mensajeConfirmacion = new MimeMessage(session);
            mensajeConfirmacion.setFrom(new InternetAddress(usuario));
            mensajeConfirmacion.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoUsuario));
            mensajeConfirmacion.setSubject("SOLICITUD DE PEDIDO");
            mensajeConfirmacion.setText("Hay una nueva solicitud de pedido.\n\n Detalles del pedido:\n\n"
                    + "Nombre del producto: " + nombreProducto + "\n"
                    + "Código del producto: " + codigoProducto + "\n"
                    + "Cantidad: " + cantidad + "\n"
                    + "Precio: " + precio + "\n\n"
                    + "Descripcion"    +          des      + "\n\n"
                    + "¡Gracias por su compra!");

            // Enviar correo de confirmación de compra
            Transport.send(mensajeConfirmacion);

            System.out.println("Se ha enviado un correo de confirmación de compra a " + correoUsuario);
        } catch (MessagingException e) {
            System.out.println("Error al enviar el correo: " + e.getMessage());
        }
    }
    
    
}
