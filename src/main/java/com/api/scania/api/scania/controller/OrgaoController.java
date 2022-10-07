package com.api.scania.api.scania.controller;

import com.api.scania.api.scania.model.Orgao;
import com.api.scania.api.scania.repository.OrgaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/list")
public class OrgaoController {
    @Autowired
    private OrgaoRepository orgaoRepository;

    @GetMapping("/orgao")
    public List<Orgao> lista() {
        return orgaoRepository.findAll();
    }
}
