package yi.shi.service.impl;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import yi.shi.plinth.annotation.Properties;
import yi.shi.service.MailService;

public class MailServiceImpl implements MailService {

    @Properties(value = "mail.smtp.host", defaultValue = "smtp.qq.com")
    private String host;

    @Properties(value = "mail.smtp.port", defaultValue = "465")
    private int port;

    @Properties(value = "mail.smtp.username", defaultValue = "your username")
    private String username;

    @Properties(value = "mail.smtp.password", defaultValue = "your password")
    private String password;

    @Override
    public void sendHtmlEmail(String to, String subject, String content) throws EmailException {
        HtmlEmail mail = new HtmlEmail();
        mail.setHostName(host);
        mail.setSmtpPort(port);
        mail.setAuthentication(username, password);
        mail.setFrom(username);
        mail.addTo(to);
        mail.setSubject(subject);
        mail.setHtmlMsg(content);
        mail.send();
    }
}
