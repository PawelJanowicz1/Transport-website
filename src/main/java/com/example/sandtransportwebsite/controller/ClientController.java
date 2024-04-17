package com.example.sandtransportwebsite.controller;

import com.example.sandtransportwebsite.model.Client;
import com.example.sandtransportwebsite.service.ClientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ClientController {
   private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @PostMapping("/add")
    public void creatingClient( String name, String lastName, String email, int phoneNumber){
        clientService.createClient(name, lastName, email, phoneNumber);
    }
    @GetMapping("/get/{id}")
    public Client getClientInfo(@PathVariable Long id){
       return clientService.getClientInfo(id);
    }
    @PutMapping("/update/{id}")
    public void modifyClientInfo(@PathVariable Long id, String name, String lastName, String email, int phoneNumber){
        clientService.modifyClientInfo(id, name, lastName, email, phoneNumber);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteClientInfo(@PathVariable Long id){
        clientService.deleteClient(id);
    }
}
