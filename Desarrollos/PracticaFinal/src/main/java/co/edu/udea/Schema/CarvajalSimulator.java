package co.edu.udea.Schema;

import co.edu.udea.controller.InvoiceController;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class CarvajalSimulator {
    private final Properties props = new Properties();

    private final String fromEmail = "santycano4@gmail.com"; //requires valid gmail id
    private final String password = "mariaelenap"; // correct password for gmail id
    private final String toEmail = "santycano4@gmail.com"; // can be any email id

    private Session session;

    public CarvajalSimulator() {
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        props.put("mail.smtp.port", "466"); //SMTP Port
    }

    public static void sendEmail(Session session, String toEmail, String subject, String body){
        try
        {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

            msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

            msg.setSubject(subject, "UTF-8");

            msg.setText(body, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            System.out.println("Message is ready");
            Transport.send(msg);

            System.out.println("EMail Sent Successfully!!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return props;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void emailsend(){
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getDefaultInstance(props, auth);
        System.out.println("Session created");
        XMLInvoice xmlInvoice = new XMLInvoice();
        ArrayList<DataItem> dataItems = new ArrayList<>();
        dataItems.add(new DataItem(12000,"carne"));
        ArrayList unds = new ArrayList<>();
        unds.add(2);
        sendEmail(session, toEmail,"Factura electronica", xmlInvoice.convertJsonToXml(dataItems,unds));

    }

    public static void main(String[] args) throws SQLException {
        CarvajalSimulator carvajalSimulator = new CarvajalSimulator();
        carvajalSimulator.emailsend();
    }
}
