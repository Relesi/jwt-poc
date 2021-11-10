package com.relesi.jwt.services;


import com.relesi.jwt.domain.User;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;



@Service
public interface EmailService {

    void sendOrderConfirmationEmail(User obj);

    void sendEmail(SimpleMailMessage msg);

    void sendNewPasswordEmail(User user, String newPasswordReset);



}

