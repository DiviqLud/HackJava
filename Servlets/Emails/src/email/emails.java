package email;

import javax.mail.*;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class emails {
	public static void main(String[] args) throws EmailException {
		// Create the attachment
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("/home/galin/stelaiaz.jpg");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Wtf");
		attachment.setName("Wtf");
		
		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("galin.angelov5", "0870f99d"));
		email.setSSLOnConnect(true);
		email.addTo("galin.angelov5@gmail.com", "Galin Angelo");
		email.setFrom("galin.angelov5@gmail.com", "Galin Angelov");
		email.setSubject("Test");
		email.setMsg("Testing email sending");
		
		// add the attachment
		email.attach(attachment);
		
		// send the email
		email.send();
		}
}

