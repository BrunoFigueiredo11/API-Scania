package com.api.scania.api.scania.controller;

import com.api.scania.api.scania.model.Descricao;
import com.api.scania.api.scania.repository.DescricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/list")
public class DescricaoController {
    @Autowired
    private DescricaoRepository descricaoRepository;

    @GetMapping("/descricao/{id}")
    public List<Descricao> lista(@PathVariable int id) {
        return descricaoRepository.findAllById(Collections.singleton(id
        ));
    }

    @GetMapping("/descricao")
    public List<Descricao> lista() {
        return descricaoRepository.findAll();
    }
}
