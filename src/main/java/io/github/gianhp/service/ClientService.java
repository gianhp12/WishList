package io.github.gianhp.service;

import io.github.gianhp.domain.entity.Client;
import io.github.gianhp.domain.entity.Product;
import io.github.gianhp.rest.dto.WishListDTO;

import java.util.List;

public interface ClientService  {
    public Client createClient(Client client);

    public Client findClient(Long cpf);

    public List<Product> findAllItems(WishListDTO dto);

    public void saveItemList(WishListDTO dto);

    public void deleteItemList(WishListDTO dto);

    public Product getItemListByCode(WishListDTO dto);
}
