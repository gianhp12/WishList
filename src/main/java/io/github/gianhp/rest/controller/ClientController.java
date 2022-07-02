package io.github.gianhp.rest.controller;

import io.github.gianhp.domain.entity.Client;
import io.github.gianhp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clientes")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("/consulta/{cpf}")
    public Client getClientById(@PathVariable Long cpf){
      return this.clientService.getClientById(cpf);
    }

    @GetMapping("/consulta/todos")
    public List<Client> getAllClients(){
        return this.clientService.getAllClients();
    }

    @PostMapping("/cadastrar")
    public Client createClient(@RequestBody Client client){
        return this.clientService.createClient(client);
    }


}
