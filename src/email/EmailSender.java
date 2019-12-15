package email;

import log.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.Properties;
import java.util.stream.Collectors;

public class EmailSender {
    public static boolean sendError(String errorMessage) {
        final String login = "yurazast@gmail.com";
        final String password = "UNKNOWN";
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(login, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(login));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(login));
            message.setSubject("Exception thrown at VoiceRecord");
            message.setText(errorMessage);
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            Logger.log("ERROR: " + e.getMessage() + "\n" + Arrays.stream(e.getStackTrace()).map(i -> i + "\n").collect(Collectors.joining()));
            System.out.println("Cannot send email");
            return false;
        }
    }
}
