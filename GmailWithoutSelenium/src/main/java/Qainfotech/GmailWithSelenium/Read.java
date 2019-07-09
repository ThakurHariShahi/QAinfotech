package Qainfotech.GmailWithSelenium;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

public class Read {
	public static void main(String a[]) throws MessagingException {
		 Properties properties = new Properties();

	      properties.put("mail.pop3.host", "smtp.gmail.com");
	      properties.put("mail.pop3.port", "995");
	      properties.put("mail.pop3.starttls.enable", "true");
	      Session emailSession = Session.getDefaultInstance(properties);
	      Store store = emailSession.getStore("pop3s");
	      store.connect("smtp.gmail.com","bhattjagdish253@gmail.com", "Hesoyam@12");
	      Folder emailFolder = store.getFolder("Inbox");
	      emailFolder.open(Folder.READ_ONLY);
	      Message[] messages = emailFolder.getMessages();
	      for(Message message:messages) {
	    	  System.out.println(message);
	      }
	}
}
