package com.laarizag.Inventory.controller;

import com.laarizag.Inventory.model.Client;
import com.laarizag.Inventory.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client getClient(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Client createClient(@RequestBody Client newClient) {
        return clientService.createNewClient(newClient);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client updateClient(@PathVariable Long id, @RequestBody Client newClient) {
        return clientService.updateClient(id, newClient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

}
