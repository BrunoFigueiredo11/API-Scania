package com.api.scania.api.scania.controller;

import com.api.scania.api.scania.model.Licitacao;
import com.api.scania.api.scania.repository.LicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/list")
public class LicitacaoController {
    @Autowired
    private LicitacaoRepository licitacaoRepository;

    @GetMapping("/licitacao")
    public List<Licitacao> lista() {

        return licitacaoRepository.findAll();
    }
}
