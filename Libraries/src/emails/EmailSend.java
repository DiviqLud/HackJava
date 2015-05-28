package emails;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

 
public class EmailSend {
 
	public static void main(String[] args) throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("galin.angelov5@gmail.com", "*******"));
		email.setSSLOnConnect(true);
		email.setFrom("galin.angelov5@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("galin.angelov5@gmail.com");
		email.setDebug(true);
		email.send();
	}

}