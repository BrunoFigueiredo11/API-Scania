package com.api.scania.api.scania.controller;

import com.api.scania.api.scania.dto.EmailDto;
import com.api.scania.api.scania.model.Descricao;
import com.api.scania.api.scania.model.Licitacao;
import com.api.scania.api.scania.model.StatusEmail;
import com.api.scania.api.scania.repository.LicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/list")
public class LicitacaoController {
    @Autowired
    private LicitacaoRepository licitacaoRepository;

    @Autowired
    private EmailController emailController;

    @GetMapping("/licitacao")
    public List<Licitacao> lista() {
        return licitacaoRepository.findAll();
    }

    @GetMapping("/licitacao/{id}")
    public List<Licitacao> lista(@PathVariable int id) {
        return licitacaoRepository.findAllById(Collections.singleton(id
        ));
    }

    @PutMapping("/licitacao/{id}/{status}")
    public ResponseEntity<Void> list(@PathVariable int id, @PathVariable int status) {
        try {
            licitacaoRepository.updateStatus(status, id);
            if (status == 1) {
                emailController.sendEmail(new EmailDto("brunofigueiredo1120@gmail.com", "brunofigueiredo1120@gmail.com", "Licitação Selecionada: ", "texto", "00/00/0000", StatusEmail.SEND));
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }
}
