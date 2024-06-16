package com.example.sandtransportwebsite.controller;

import com.example.sandtransportwebsite.dto.ContactRequest;
import com.example.sandtransportwebsite.service.EmailService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send-email")
    ResponseEntity <?> sendEmail(@RequestBody @Valid ContactRequest contactRequest) {
        emailService.sendSimpleEmail(contactRequest);
        return ResponseEntity.ok("Email has been sent successfully");
    }
}
