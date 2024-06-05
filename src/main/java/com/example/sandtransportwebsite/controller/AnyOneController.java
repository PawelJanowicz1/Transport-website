package com.example.sandtransportwebsite.controller;

import com.example.sandtransportwebsite.dto.CreateClient;
import com.example.sandtransportwebsite.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class AnyOneController {

    private final ClientService clientService;

    @PostMapping("/create-client")
    void creatingClient(@RequestBody CreateClient createClient){
        clientService.createClient(createClient);
    }
}
