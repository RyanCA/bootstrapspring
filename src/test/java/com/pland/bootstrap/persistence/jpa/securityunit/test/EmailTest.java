package com.pland.bootstrap.persistence.jpa.securityunit.test;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailTest {
	
	
	
	/**
	 *  
	 *  Spring link for email sending
	 *  http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mail.html
	 *  
	 *  To enable Telnet command line utilities:
	 *	Click Start > Control Panel.
	 *	Click Programs and Features.
	 *	Click Turn Windows features on or off.
	 *	In the Windows Features dialog box, check the Telnet Client check box.
	 *	Click OK. The system installs the appropriate files. This will take a few seconds to a minute.
	 *  
	 *  Make sure you can connect using telnet from the machine you are using to send email.
     *  TELNET smtp.gmail.com 465
	 *  
	 *  
	 *  ########################################################################
	 *	#                                                                      #
	 *  #              Window Command                                          #
	 *	#                                                                      #
	 *	########################################################################
	 *	netstat -ano | findstr :465 # Get process id from network connection by filter of port
	 *	
	 *	tasklist | findstr 3340 #Get process info from process id
     *
	 */
	
	@Test
	 public void testSendingEmails() throws Exception {
		// of course you would use DI in any real-world cases
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		/**
		 * Gmail incoming host name: imap.gmail.com
		 * Gmail outgoing host name: smtp.gmail.com
		 * 
		 * The following code can be used to send email vis Gmail SMTP server.
		 * However there is one condition need to be met that is to set gmail as
		 * a lesssecureapps and turn it ON. Use below link to set it
		 * https://www.google.com/settings/security/lesssecureapps
		 * 
		 * Refer this link for details: http://stackoverflow.com/questions/28273799/issue-in-sending-a-mail-to-gmail-account-using-spring-mail
		 * 
		 * 
		 */

		sender.setUsername("automationemailsender@gmail.com");
		sender.setPassword("automationemailsender123");
		
		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		javaMailProperties.put("mail.smtp.socketFactory.port", "465"); //SSL Port
		javaMailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		javaMailProperties.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		 
		javaMailProperties.setProperty("mail.smtp.starttls.enable", "true");
		javaMailProperties.setProperty("mail.debug", "true");
		sender.setJavaMailProperties(javaMailProperties);

		
		
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setFrom("automationemailsender@gmail.com");
		helper.setTo("automationemailsender@gmail.com");//You can put the email, you want to send here
		helper.setSubject("Email Testing");
		helper.setText("Thank you for ordering!");

		sender.send(message);
		
	}

}
