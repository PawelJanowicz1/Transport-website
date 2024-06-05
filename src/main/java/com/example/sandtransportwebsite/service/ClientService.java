package com.example.sandtransportwebsite.service;

import com.example.sandtransportwebsite.dto.CreateClient;
import com.example.sandtransportwebsite.model.Client;
import com.example.sandtransportwebsite.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public void createClient(CreateClient createClient){
        final var client = new Client(createClient.firstName(), createClient.lastName(), createClient.email(), createClient.phoneNumber());
        clientRepository.save(client);
    }

    public Client getMyInfo(Long id){
       return clientRepository.getClientById(id);
    }
}