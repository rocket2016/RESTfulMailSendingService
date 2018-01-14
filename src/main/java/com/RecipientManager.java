package com;

import org.springframework.mail.SimpleMailMessage;


public interface RecipientManager {
    SimpleMailMessage send();
}
