package io.github.gianhp.service.Impl;

import io.github.gianhp.domain.entity.Client;
import io.github.gianhp.domain.entity.Product;
import io.github.gianhp.domain.repository.ClientRepository;
import io.github.gianhp.rest.dto.WishListDTO;
import io.github.gianhp.service.ClientService;
import io.github.gianhp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final ProductService service;
    public Client createClient(Client client){
       return clientRepository.save(client);
    }

    public Client findClient(Long cpf){
        Client client = clientRepository
                .findById(cpf)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
        return client;
    }

    public List<Product> findAllItems(WishListDTO dto){
        Long cpf = dto.getClient();
        Client consumer = findClient(cpf);
        if(consumer.getItems().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"Lista está vazia");
        }
        return consumer.getItems();
    }

    public void saveItemList(WishListDTO dto) {
        Long clientcpf = dto.getClient();
        Integer productCode = dto.getProduct();
        Client consumer = findClient(clientcpf);
        Product product = service.findProduct(productCode);
        if(consumer.getItems().size() < 20) {
            if(consumer.getItems().contains(product)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Produto já existe na lista");
            }else{
                consumer.getItems().add(product);
                clientRepository.save(consumer);
            }
        }else { throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Lista está cheia");
        }
    }

    public void deleteItemList(WishListDTO dto) {
        Long clientcpf = dto.getClient();
        Integer productCode = dto.getProduct();
        Client consumer = findClient(clientcpf);
        Product product = service.findProduct(productCode);
        if(consumer.getItems().contains(product)){
            consumer.getItems().remove(product);
            clientRepository.save(consumer);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Produto não encontrado");
        }
    }

    public Product getItemListByCode(WishListDTO dto) {
        Long clientcpf = dto.getClient();
        Integer productCode = dto.getProduct();
        Client consumer = findClient(clientcpf);
        Product product = service.findProduct(productCode);
        if(consumer.getItems().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"Lista está vazia");
        }
        if(consumer.getItems().contains(product)){
            return product;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Produto não encontrado");
        }
    }

}
