package com.example;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
    private String userName;
    private String userEmail;
    private String fromMail;
    private String pass;
    private Session session;
    private Properties properties;
    private String[] toAddress;
    private String host;
    MimeMessage message;
    public EmailSender(String userName, String userEmail) {
        fromMail= "cs48RubberDucks@gmail.com";
        pass = "HelloWorldcs48!";
        //pass = getFromConfig(password)
        this.userEmail = userEmail;
        toAddress = new String[]{this.userEmail};
        properties = System.getProperties();
        host = "smtp.gmail.com";
        this.userName = userName;
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", host);
        properties.put("mail.smtp.user", fromMail);
        properties.put("mail.smtp.password", pass);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        session = Session.getDefaultInstance(properties);
        message = new MimeMessage(session);
    }
    public boolean sendMail() throws AddressException, MessagingException{
        String subject = "Forest";
        String body = "";
        String welcomeHeader = String.format("<h3><font color=\"red\">Welcome to the Crystalis, %s!</font></h3>", userName);
        String paragraph = "<p>Thomas is a 14-year-old boy coming of age in the town of Crystalis. All children who turn 15 in Crystalis must choose an occupation. Thomas now has 3 weeks before he turns 15 and has to choose. Thomas has always wanted to be a knight ever since he was a kid. However, Merlin, the town chief, won’t allow Thomas to officially become a knight. Thomas must now pass all of Merlin’s trials or risk becoming the town’s baker as a last resort.</p><p>For more information, please visit our <a href=\"http://sites.cs.ucsb.edu/~qhong\">website</a>.</p><p>Good luck and enjoy the game!</p>Best,<br><p>Rubber Ducks Developer Team</p>";
        body = welcomeHeader + paragraph;
        message.setFrom(new InternetAddress(fromMail));
        InternetAddress[] internetAddress = new InternetAddress[toAddress.length];

        // iterate array of addresses
        for (int i = 0; i < toAddress.length; i++) {
            internetAddress[i] = new InternetAddress(toAddress[i]);
       }

        for (int i = 0; i < internetAddress.length; i++) {
            message.addRecipient(Message.RecipientType.TO, internetAddress[i]);
        }

        message.setSubject(subject);
        message.setContent(body, "text/html; charset=utf-8");

        Transport transport = session.getTransport("smtp");

        transport.connect(host, fromMail, pass);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        return true;    
    }

}