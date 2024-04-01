package com.example.sandtransportwebsite.service;
import com.example.sandtransportwebsite.model.Client;
import com.example.sandtransportwebsite.repository.ClientRepository;
import org.springframework.stereotype.Service;
@Service
public class ClientService {
    Client client;
    ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public Client createClient(String name, String lastName, String email, int phoneNumber){
Client client = new Client();
client.setName(name);
client.setLastName(lastName);
client.setEmail(email);
client.setPhoneNumber(phoneNumber);
return clientRepository.save(client);
    }
}
