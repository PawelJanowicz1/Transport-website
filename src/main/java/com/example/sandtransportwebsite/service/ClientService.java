package com.example.sandtransportwebsite.service;
import com.example.sandtransportwebsite.model.Client;
import com.example.sandtransportwebsite.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public void createClient(String name, String lastName, String email, int phoneNumber){
Client client = new Client();
client.setName(name);
client.setLastName(lastName);
client.setEmail(email);
client.setPhoneNumber(phoneNumber);
clientRepository.save(client);
    }
    public Client getClientInfo(Long id){
       return clientRepository.findById(id).orElse(null);
    }
    public void modifyClientInfo(Long id, String name, String lastName, String email, int phoneNumber){
        Optional<Client> currentList = clientRepository.findById(id);
        Client client = currentList.orElse(null);
        client.setName(name);
        client.setLastName(lastName);
        client.setEmail(email);
        client.setPhoneNumber(phoneNumber);
        clientRepository.save(client);
    }
    public void deleteClient(Long id){
        clientRepository.deleteById(id);
    }
}
