package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestProvider {
    private RestTemplate restTemplate;
    @Autowired
    private MailSender mailSender;

    public RestProvider() {}

    @Autowired
    public RestProvider(RestTemplateBuilder restTemplateBuilder, MailSender mailSender) {
        this.mailSender = mailSender;
        this.restTemplate = restTemplateBuilder.build();
    }

    @Bean
    @Async
    public String restCallBuilder() {
        String path;
        try{
            path = this.restTemplate.getForObject("http://localhost:8080/sendMessage", String.class);
        } catch(RestClientException ex) {
            path = null;
        }
       return path;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Response postResponse() {
       return new Response(mailSender.getRecipient());
    }



}
