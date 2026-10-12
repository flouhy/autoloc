package tn.esprit.autoloc.service.interfaces;

import tn.esprit.autoloc.domain.Client;

import java.util.HashSet;
import java.util.Set;

public interface IClientService {
    public HashSet<Client> retrieveAllClients();
    public Client retrieveClient(Long clientId);
    public Client addClient(Client c);
    public void removeClient(Long clientId);
    public Client modifyClient(Client client);
}
