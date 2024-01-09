package com.service;


import com.entity.Client;
import com.errors.ItemNotFoundException;
import com.repo.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll(); }

    public Client client(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id)); }

    public Client createClient(Client newClient) {
        return clientRepository.save(newClient); }

    public void deleteClient(Long id){
        clientRepository.deleteById(id); }
    
    public Client updateOrCreateClient(Client newClient) {
        return clientRepository.findById(newClient.getId())
                .map(client -> {
                    client.setName(newClient.getName());
                    client.setAddress(newClient.getAddress());
                    client.setPhoneNumber(newClient.getPhoneNumber());
                    client.setAddress(newClient.getAddress());
                    return clientRepository.save(client);
                })
                .orElseGet(() -> {
                    return clientRepository.save(newClient);
                });
    }
}
