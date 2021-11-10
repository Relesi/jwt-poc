package com.relesi.jwt.services;

import com.relesi.jwt.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public class AbstractEmailService implements EmailService{

    @Value("${default.sender}")
    private String sender;


    @Override
    public void sendOrderConfirmationEmail(User obj) {
        SimpleMailMessage sm = prepareSimpleMailMessageFromUser(obj);
        sendEmail(sm);
    }

    @Override
    public void sendEmail(SimpleMailMessage msg) {

    }

    protected SimpleMailMessage prepareSimpleMailMessageFromUser(User obj) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(obj.getAuthor().getEmail());
        sm.setFrom(sender);
        sm.setSubject("Confirmed User! Code: " + obj.getId());
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(obj.toString());
        return sm;
    }

    @Override
    public void sendNewPasswordEmail(User user, String newPasswordReset) {
        SimpleMailMessage sm = prepareNewPasswordEmail(user, newPasswordReset);
        sendEmail(sm);
    }

    protected SimpleMailMessage prepareNewPasswordEmail(User user, String newPasswordReset) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(user.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Request for new password: ");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("New Password " + newPasswordReset);
        return sm;
    }








}
