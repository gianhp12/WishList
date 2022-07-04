package io.github.gianhp.service.Impl;

import io.github.gianhp.domain.entity.Product;
import io.github.gianhp.domain.repository.ProductRepository;
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
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }


    public Product findProduct(Integer code){
        Product product = productRepository
                .findById(code)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Produto não encontrado"));
        return product;
    }

    public Product createProduct(Product product){
        return this.productRepository.save(product);
    }
}