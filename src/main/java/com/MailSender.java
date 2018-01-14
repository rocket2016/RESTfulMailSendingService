package com;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MailSender  implements RecipientManager{

    private SimpleMailMessage simpleMailMessage;

    public JavaMailSender getMailSender() {
        return MailSenderConfiguration.javaMailSender();
    }

    @Override
    @Bean
    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public SimpleMailMessage send() {
        JavaMailSender javaMailSender = getMailSender();
        this.simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("somesender@gmail.com");
        simpleMailMessage.setSubject("job");
        simpleMailMessage.setText("Hi");
        simpleMailMessage.setTo("somerecipient@gmail.com");

        try {
            javaMailSender.send(simpleMailMessage);

        } catch (MailException mailexc) {
            mailexc.printStackTrace();
        }
        return simpleMailMessage;

    }

    public String[] getRecipient() {
        return simpleMailMessage.getTo();
    }

}
