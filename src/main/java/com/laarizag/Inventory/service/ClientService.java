package com.laarizag.Inventory.service;

import com.laarizag.Inventory.dto.ClientCURequest;
import com.laarizag.Inventory.dto.model.ClientDto;
import com.laarizag.Inventory.mapper.MapStructMapper;
import com.laarizag.Inventory.model.Client;
import com.laarizag.Inventory.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final MapStructMapper mapper;

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.getById(id);
    }

    public void createNewClient(ClientCURequest request) {
        var client = new Client();
        client.setIdentification(request.getIdentification());
        client.setName(request.getName());
        client.setPicture(request.getPicture());
        clientRepository.save(client);
    }

    public void updateClient(Long id, ClientCURequest request) {
        var currentClient = clientRepository.getById(id);
        currentClient.setIdentification(request.getIdentification());
        currentClient.setName(request.getName());
        currentClient.setPicture(request.getPicture());
        clientRepository.save(currentClient);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

}
