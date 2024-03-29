package com.example.sandtransportwebsite.model;
import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String name;
    @Column
    String lastName;
    @Column
    String email;
    @Column
    int phoneNumber;
}
