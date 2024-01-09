package com.controller;

import com.entity.Client;
import com.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("")
    List<Client> clientAll() {
        return clientService.getAllClients(); }

    @GetMapping("/{id}")
    Client client(@RequestParam Long id) {
            return clientService.client(id); }

    @PostMapping("")
    Client createClient(@RequestBody Client newClient) {
        return clientService.createClient(newClient); }

    @PutMapping("")
    Client updateOrCreateClient(@RequestBody Client newClient) {
        return clientService.updateOrCreateClient(newClient); }

    @DeleteMapping("/{id}")
    void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

}

