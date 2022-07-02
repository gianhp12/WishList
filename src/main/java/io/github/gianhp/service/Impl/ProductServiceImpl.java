package io.github.gianhp.service.Impl;

import io.github.gianhp.domain.entity.Product;
import io.github.gianhp.domain.repository.ProductRepository;
import io.github.gianhp.exception.BusinessRuleException;
import io.github.gianhp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;


    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }


    public Product getProductById( Integer code){
        return this.productRepository
                .findById(code)
                .orElseThrow(() -> new BusinessRuleException("Produto não existe"));
    }


    public Product createProduct(@RequestBody Product product){
        return this.productRepository.save(product);
    }
}
