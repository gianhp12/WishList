package io.github.gianhp.service.Impl;

import io.github.gianhp.domain.entity.Client;
import io.github.gianhp.domain.entity.Product;
import io.github.gianhp.domain.repository.ClientRepository;
import io.github.gianhp.domain.repository.ProductRepository;
import io.github.gianhp.exception.BusinessRuleException;
import io.github.gianhp.rest.dto.WishListDTO;
import io.github.gianhp.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class WishListServiceImpl implements WishListService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductRepository productRepository;

    public void saveItemList(WishListDTO dto){
        Long cpfClient = dto.getClient();
        Client client = clientRepository
                .findById(cpfClient)
                .orElseThrow(()-> new BusinessRuleException("Cliente não encontrado"));
        Integer productCode = dto.getProduct();
        Product product = productRepository
                .findById(productCode)
                .orElseThrow(()-> new BusinessRuleException("Produto não encontrado"));
        client.getItems().forEach(System.out::println);
        if(client.getItems().size() <= 20) {
            client.getItems().add(product);
            clientRepository.save(client);
        }else {
            throw new BusinessRuleException("Wishlist está cheia");
        }
    }
    public void deleteItemList(WishListDTO dto){
        Long cpfClient = dto.getClient();
        Integer productCode = dto.getProduct();
        Client client = clientRepository
                .findById(cpfClient)
                .orElseThrow(()-> new BusinessRuleException("Cliente não encontrado"));
        Product product = productRepository
                .findById(productCode)
                .orElseThrow(()-> new BusinessRuleException("Produto não encontrado"));
        List<Client> list = new ArrayList<>();
        list = getAllItemsList();





    }


    public List<Client> getAllItemsList(){
        return this.clientRepository.findAll();

    }

}
