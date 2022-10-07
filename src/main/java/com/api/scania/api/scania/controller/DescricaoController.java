package com.api.scania.api.scania.controller;

import com.api.scania.api.scania.model.Descricao;
import com.api.scania.api.scania.repository.DescricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/list")
public class DescricaoController {
    @Autowired
    private DescricaoRepository descricaoRepository;

    @GetMapping("/descricao")
    public List<Descricao> lista() {

        return descricaoRepository.findAll();
    }
}
