package com.example.sandtransportwebsite.service;

import com.example.sandtransportwebsite.model.Client;
import com.example.sandtransportwebsite.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final ClientRepository clientRepository;
    private final JavaMailSenderImpl mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Value("${admin.email}")
    private String adminEmail;

    public ResponseEntity<?> sendSimpleEmail(String name, String email, String phoneNumber, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromEmail);
        simpleMailMessage.setTo(adminEmail);

        String subject = "Prośba o kontakt od " + name;

        StringBuilder sb = new StringBuilder();
        sb.append("Imię: ").append(name).append("\n");
        sb.append(("Email: ")).append(email).append("\n");
        if(phoneNumber != null && !phoneNumber.isEmpty()) {
            sb.append("Numer Telefonu: ").append(phoneNumber).append("\n");
        }else {
            phoneNumber = "Numer telefonu nie został podany";
            sb.append("Numer Telefonu nie został podany").append("\n");
        }
        sb.append(("Message: ")).append(message).append("\n");
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(sb.toString());
        mailSender.send(simpleMailMessage);
        Client client = new Client(name, email, phoneNumber, message);
        clientRepository.save(client);

       return ResponseEntity.ok("ok");
    }
}
