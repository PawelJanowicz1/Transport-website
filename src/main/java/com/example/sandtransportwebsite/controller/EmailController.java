package com.example.sandtransportwebsite.controller;

import com.example.sandtransportwebsite.dto.ContactRequest;
import com.example.sandtransportwebsite.service.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
@CrossOrigin(origins = "localhost:8064")
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send-email")
    ResponseEntity <?> sendEmail(@RequestBody @Valid ContactRequest contactRequest) {
        emailService.sendSimpleEmail(contactRequest);
        return ResponseEntity.ok("Email has been sent successfully");
    }
}