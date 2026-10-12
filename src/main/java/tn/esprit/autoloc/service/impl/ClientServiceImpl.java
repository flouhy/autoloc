package tn.esprit.autoloc.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.ClientRepository;
import tn.esprit.autoloc.service.interfaces.IClientService;

import java.util.HashSet;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements IClientService {

    private final ClientRepository clientRepository;

    @Override
    public HashSet<Client> retrieveAllClients() {
        return new HashSet<>(clientRepository.findAll());
    }


    public Client retrieveClient(Long clientId) {
        return clientRepository.findById(clientId).get();
    }


    public Client addClient(Client c) {
        return clientRepository.save(c);
    }


    public void removeClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }


    public Client modifyClient(Client c) {
        return clientRepository.save(c);
    }
}