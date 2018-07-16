package app.service;

import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.concurrent.CompletableFuture;

public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void notify(User user) {
        CompletableFuture.runAsync(()-> javaMailSender.send(registrationEmail(user)));

    }

    private SimpleMailMessage registrationEmail(User user) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(user.getEmail());
        msg.setSubject("Email verification");
        msg.setText
                (String.format("Please follow link below for finishig your " +
                        "registration:http://localhost:8081/activation/%s", user.getToken()));

        return msg;
    }
}
