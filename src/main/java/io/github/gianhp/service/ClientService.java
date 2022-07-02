package io.github.gianhp.service;

import io.github.gianhp.domain.entity.Client;

import java.util.List;

public interface ClientService  {
    public Client createClient(Client client);

    public Client getClientById(Long cpf);

    public List<Client> getAllClients();


}
