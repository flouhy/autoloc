package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.interfaces.IClientService;

import java.util.HashSet;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientRestController {

    private final IClientService clientService;

    // http://localhost:8089/client/retrieve-all-clients
    @GetMapping("/retrieve-all-clients")
    public HashSet<Client> getClients() {
        return clientService.retrieveAllClients();
    }

    // http://localhost:8089/client/retrieve-client/8
    @GetMapping("/retrieve-client/{client-id}")
    public Client retrieveClient(@PathVariable("client-id") Long clientId) {
        return clientService.retrieveClient(clientId);
    }

    // http://localhost:8089/client/add-client
    @PostMapping("/add-client")
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    // http://localhost:8089/client/remove-client/8
    @DeleteMapping("/remove-client/{client-id}")
    public void removeClient(@PathVariable("client-id") Long clientId) {
        clientService.removeClient(clientId);
    }

    // http://localhost:8089/client/modify-client
    @PutMapping("/modify-client")
    public Client modifyClient(@RequestBody Client client) {
        return clientService.modifyClient(client);
    }
}