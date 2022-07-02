package io.github.gianhp.service;

import io.github.gianhp.domain.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product>getAllProducts();

    public Product getProductById(Integer code);

    public Product createProduct(Product product);

}
