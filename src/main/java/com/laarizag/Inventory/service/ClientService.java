package com.laarizag.Inventory.service;

import com.laarizag.Inventory.model.Client;
import com.laarizag.Inventory.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client getClientById(Long id) {
        return clientRepository.getById(id);
    }

    public Client createNewClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client client) {
        var currentClient = clientRepository.getById(id);
        currentClient.setIdentification(client.getIdentification());
        currentClient.setName(client.getName());
        currentClient.setPicture(client.getPicture());
        clientRepository.save(currentClient);
        return currentClient;
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

}
