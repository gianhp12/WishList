package io.github.gianhp.service.Impl;

import io.github.gianhp.domain.entity.Client;
import io.github.gianhp.domain.repository.ClientRepository;
import io.github.gianhp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client){
       return clientRepository.save(client);
    }
    public Client getClientById(Long cpf){
        return clientRepository
                .findById(cpf)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não existe"));
    }
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }


}
