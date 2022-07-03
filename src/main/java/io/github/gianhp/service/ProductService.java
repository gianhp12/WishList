package io.github.gianhp.service;

import io.github.gianhp.domain.entity.Product;
import io.github.gianhp.rest.dto.WishListDTO;

import java.util.List;

public interface ProductService {
    public List<Product>getAllProducts();

    public Product findProduct(Integer code);

    public Product createProduct(Product product);

}
