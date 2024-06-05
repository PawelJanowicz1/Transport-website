package com.example.sandtransportwebsite.controller;

import com.example.sandtransportwebsite.model.Client;
import com.example.sandtransportwebsite.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/myinfo")
    Client getMyInfo(@RequestParam Long id){
        return clientService.getMyInfo(id);
    }
}