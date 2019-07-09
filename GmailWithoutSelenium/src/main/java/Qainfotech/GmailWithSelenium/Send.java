package Qainfotech.GmailWithSelenium;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Send {
	public static void main(String []a) {
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); //TLS

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication("bhattjagdish253@gmail.com", "Hesoyam@12");
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("bhattjagdish253@gmail.com"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress("bhattjagdish253@gmail.com"));
			message.setSubject("Testing");
			message.setText("hello");
			Transport.send(message);
			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
                                                                            