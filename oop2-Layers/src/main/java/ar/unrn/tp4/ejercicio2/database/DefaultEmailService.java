package ar.unrn.tp4.ejercicio2.database;

import ar.unrn.tp4.ejercicio2.model.EmailService;
import ar.unrn.tp4.ejercicio2.model.Empleado;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class DefaultEmailService implements EmailService {
    public static final String COMPANIA_NOMBRE = "Compania";

    @Override
    public void enviarSaludo(Empleado empleado) {
        // Implementar el envío de correo electrónico aquí
        //gmail de quien recibe
        String to = empleado.getEmail();
        ;
        // quien envia el gmail
        String from = COMPANIA_NOMBRE + "@gmail.com";

        // credenciales de la cuenta mailtrap
        final String username = "94b60ed8ded979";
        final String password = "6d2c7e488844dd";

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
            message.setSubject("Feliz Cumpleaños " + NombreEmpleado);
            // set the content of the email message
            message.setText("Desde " + COMPANIA_NOMBRE + " te deseamos un feliz cumpleaños!");

            // send the email message
            Transport.send(message);

            System.out.println("Email enviado exitosamente!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
