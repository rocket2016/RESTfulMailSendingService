package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailSenderConfiguration {


    private static JavaMailSenderImpl msender;

    @Bean
    public static JavaMailSender javaMailSender()
    {
        msender = new JavaMailSenderImpl();
        Properties props=new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        msender.setJavaMailProperties(props);
        msender.setHost("smtp.gmail.com");
        msender.setPort(587);
        msender.setUsername("somesender@gmail.com");
        msender.setPassword("somepassword");
        return msender;
    }
}



