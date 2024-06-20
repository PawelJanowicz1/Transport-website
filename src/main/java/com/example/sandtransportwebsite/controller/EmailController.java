package com.example.sandtransportwebsite.controller;

import com.example.sandtransportwebsite.dto.ContactRequest;
import com.example.sandtransportwebsite.service.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
@CrossOrigin(origins = "https://dobrypiasek.pl")
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send-email")
    ResponseEntity <?> sendEmail(@RequestBody @Valid ContactRequest contactRequest) {
        emailService.sendSimpleEmail(contactRequest);
        return ResponseEntity.ok("Email has been sent successfully");
    }
}