package com.example.sandtransportwebsite.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotBlank
    private String name;

    @Column
    @NotBlank
    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = "^\\d{9}$|^Numer telefonu nie został podany$", message = "Phone number should be 9 digits or 'Numer telefonu nie został podany'")
    @Column
    private String phoneNumber;

    @Column
    @NotBlank(message = "message cannot be blank")
    private String message;

    public Client(String name, String email, String phoneNumber, String message) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.message = message;
    }
}
