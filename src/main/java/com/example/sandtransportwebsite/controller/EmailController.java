package com.example.sandtransportwebsite.controller;

import com.example.sandtransportwebsite.service.EmailService;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send-email")
    ResponseEntity <?> sendEmail(@RequestParam @NotBlank(message = "Name is Mandatory") String name,
                                 @RequestParam @NotBlank(message = "Email is Mandatory") @Email(message = "Email should be valid") String email,
                                 @RequestParam(required = false) @Pattern(regexp = "^\\d{9}$", message = "Phone number should be 9 digits") String phoneNumber,
            @RequestParam @NotBlank(message = "Message cannot be blank") String message) {
        emailService.sendSimpleEmail(name, email, phoneNumber, message);
        return ResponseEntity.ok("Email has been sent successfully");
    }
}
