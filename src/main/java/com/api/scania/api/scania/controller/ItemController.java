package com.api.scania.api.scania.controller;

import com.api.scania.api.scania.model.Item;
import com.api.scania.api.scania.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/list")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;


// LISTA A LICITACAO DE FORMA INDIVIDUAL
    @GetMapping("/item/{cd}")
    public List<Item> lista(@PathVariable int cd) {
        return itemRepository.selectFromStatus(cd);
    }
}
