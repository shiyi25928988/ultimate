package yi.shi.service;

import com.google.inject.ImplementedBy;
import org.apache.commons.mail.EmailException;
import yi.shi.service.impl.MailServiceImpl;

@ImplementedBy(MailServiceImpl.class)
public interface MailService {

    void sendHtmlEmail(String to, String subject, String content) throws EmailException;
}
