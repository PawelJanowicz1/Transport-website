package com.example.sandtransportwebsite.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ContactRequest(
                             @NotBlank
                             String name,

                             @NotBlank
                             @Email(message = "Email should be valid")
                             String email,

                             @NotBlank
                             String message,

                             @Pattern(regexp = "^\\d{9}$", message = "nie podano dobrze numeru telefonu")
                             String phoneNumber
                             ) {}