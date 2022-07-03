package io.github.gianhp.rest.controller;

import io.github.gianhp.domain.entity.Client;
import io.github.gianhp.domain.entity.Product;
import io.github.gianhp.rest.dto.WishListDTO;
import io.github.gianhp.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/clientes")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService service;

    @GetMapping("/consulta/{cpf}")
    public Client findClient(@PathVariable Long cpf){
      return this.service.findClient(cpf);
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody @Valid Client client){
        return this.service.createClient(client);
    }

    @PostMapping("/wishlist/salvarItem")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveItemList(@RequestBody WishListDTO dto){
        service.saveItemList(dto);
    }

    @GetMapping("/wishlist/consultar/todos")
    public List<Product> findAllItems(@RequestBody WishListDTO dto){
        return this.service.findAllItems(dto);
    }

    @GetMapping("/wishlist/consultar")
    public Product getItemListByCode(@RequestBody WishListDTO dto){
        return this.service.getItemListByCode(dto);
    }

    @DeleteMapping("/wishlist/deletar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItemList(@RequestBody WishListDTO dto){
        service.deleteItemList(dto);
    }

}
