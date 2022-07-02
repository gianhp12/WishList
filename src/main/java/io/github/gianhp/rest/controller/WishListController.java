package io.github.gianhp.rest.controller;

import io.github.gianhp.domain.entity.Client;
import io.github.gianhp.domain.entity.Product;
import io.github.gianhp.rest.dto.WishListDTO;
import io.github.gianhp.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishListController {
    @Autowired
    WishListService wishListService;

    @PostMapping("/salvarItem")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveItemList(@RequestBody WishListDTO dto){
        wishListService.saveItemList(dto);
    }

    @GetMapping("/consultar/todos")
    public List<Client> getAllItemsList(){
        return this.wishListService.getAllItemsList();
    }

    @DeleteMapping("/deletar/")
    public void deleteItemList(@RequestBody WishListDTO dto){
        wishListService.deleteItemList(dto);
    }

    @GetMapping("/consultar/")
    public List<Product> getItemListByCode(@RequestBody WishListDTO dto){
       return this.wishListService.getItemListByCode(dto);
    }

}
