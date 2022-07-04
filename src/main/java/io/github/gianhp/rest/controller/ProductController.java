package io.github.gianhp.rest.controller;

import io.github.gianhp.domain.entity.Product;
import io.github.gianhp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/consultar/todos")
    public List<Product> getAll(){
        return this.service.getAllProducts();
    }

    @GetMapping("consultar/{code}")
    public Product findProduct(@PathVariable Integer code){
        return this.service.findProduct(code);
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    Product create(@RequestBody Product product){
        return this.service.createProduct(product);
    }

}
