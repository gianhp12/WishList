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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class WishListServiceImpl implements WishListService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductRepository productRepository;


    List<Product> listProducts = new ArrayList<>();
    public void saveItemList(WishListDTO dto){
        Long clientcpf = dto.getClient();
        Client client = clientRepository
                .findById(clientcpf)
                .orElseThrow(()-> new BusinessRuleException("Cliente não encontrado"));
        Integer productCode = dto.getProduct();
        Product product = productRepository
                .findById(productCode)
                .orElseThrow(()-> new BusinessRuleException("Produto não encontrado"));
        if(listProducts.size() <= 20) {
            listProducts.add(product);
            client.setItems(listProducts);
            clientRepository.save(client);
        }else {
            throw new BusinessRuleException("Wishlist está cheia");
        }
    }
    public void deleteItemList(WishListDTO dto){
        Long clientcpf = dto.getClient();
        Integer productCode = dto.getProduct();
        Client client = clientRepository
                .findById(clientcpf)
                .orElseThrow(()-> new BusinessRuleException("Cliente não encontrado"));
        Product product = productRepository
                .findById(productCode)
                .map(productDelete -> {
                    listProducts.remove(productDelete);
                    client.setItems(listProducts);
                    clientRepository.save(client);
                    return productDelete;
                } )
                .orElseThrow(()-> new BusinessRuleException("Produto não encontrado"));

    }

    public List<Product> getItemListByCode(WishListDTO dto){
        Long clientcpf = dto.getClient();
        Integer productCode = dto.getProduct();
        List<Product> list = new ArrayList<>();
        Client client = clientRepository
                .findById(clientcpf)
                .orElseThrow(()-> new BusinessRuleException("Cliente não encontrado"));
        Product product = productRepository
                .findById(productCode)
                .map(getProductInList -> {
                    if(listProducts.contains(getProductInList)){
                        list.add(getProductInList);
                    }
                   return getProductInList;
                })
                .orElseThrow(()-> new BusinessRuleException("Produto não encontrado"));
        return list;
    }

    public List<Client> getAllItemsList(){
        return this.clientRepository.findAll();

    }

}
