package io.github.gianhp.service;


import io.github.gianhp.domain.entity.Client;
import io.github.gianhp.domain.entity.Product;
import io.github.gianhp.rest.dto.WishListDTO;

import java.util.List;

public interface WishListService {
    public void saveItemList(WishListDTO dto);

    public List<Client> getAllItemsList();

    public void deleteItemList(WishListDTO dto);

    public List<Product> getItemListByCode(WishListDTO dto);
}
