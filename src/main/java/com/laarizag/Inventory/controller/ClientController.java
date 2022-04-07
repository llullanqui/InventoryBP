package com.laarizag.Inventory.controller;

import com.laarizag.Inventory.dto.ClientCURequest;
import com.laarizag.Inventory.dto.model.ClientDto;
import com.laarizag.Inventory.mapper.MapStructMapper;
import com.laarizag.Inventory.model.Client;
import com.laarizag.Inventory.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    private final MapStructMapper mapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getClients() {
        return clientService.getClients();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDto getClient(@PathVariable Long id) {
        return mapper.clientToDto(clientService.getClientById(id) );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createClient(@RequestBody ClientCURequest newClient) {
        clientService.createNewClient(newClient);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateClient(@PathVariable Long id, @Valid @RequestBody ClientCURequest newClient) {
        clientService.updateClient(id, newClient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

}
