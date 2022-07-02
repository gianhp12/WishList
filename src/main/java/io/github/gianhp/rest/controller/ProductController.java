package io.github.gianhp.rest.controller;

import io.github.gianhp.domain.entity.Product;
import io.github.gianhp.domain.repository.ProductRepository;
import io.github.gianhp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProductController {
    @Autowired ProductService productService;

    @GetMapping
    public List<Product> getAll(){
        return this.productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Integer code){
        return this.productService.getProductById(code);
    }

    @PostMapping Product create(@RequestBody Product product){
        return this.productService.createProduct(product);
    }
}
