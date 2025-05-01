package ar.unrn.tp4.ejercicio2.Mail;

import ar.unrn.tp4.ejercicio2.model.Empleado;
import ar.unrn.tp4.ejercicio2.model.ManejoDeNotificaciones;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class MailtrapManejoDeNotificaciones implements ManejoDeNotificaciones {
    public static final String COMPANIA_NOMBRE = "Compania";
    private static final String FELIZ_CUMPLEAÑOS = "Feliz Cumpleaños ";
    private static final String ENVIADO_EXITOSAMENTE = "Email enviado exitosamente!";
    private static final String PASSWORD = "6d2c7e488844dd";
    private static final String USERNAME = "94b60ed8ded979";

    @Override
    public void enviarSaludo(Empleado empleado) {
        // Implementar el envío de correo electrónico aquí
        //gmail de quien recibe
        String to = empleado.getEmail();
        ;
        // quien envia el gmail
        String from = COMPANIA_NOMBRE + "@gmail.com";

        // credenciales de la cuenta mailtrap
        final String username = USERNAME;
        final String password = PASSWORD;

        // provide host address
        String host = "sandbox.smtp.mailtrap.io";

        // configure SMTP details
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // create the mail Session object
        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // create a MimeMessage object
            Message message = new MimeMessage(session);
            // set From email field
            message.setFrom(new InternetAddress(from));
            // set To email field
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // set email subject field
            String NombreEmpleado = empleado.getNombre();
            ;
            message.setSubject(FELIZ_CUMPLEAÑOS + NombreEmpleado);
            // set the content of the email message
            message.setText("Desde " + COMPANIA_NOMBRE + " te deseamos un feliz cumpleaños!");

            // send the email message
            Transport.send(message);

            System.out.println(ENVIADO_EXITOSAMENTE);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
