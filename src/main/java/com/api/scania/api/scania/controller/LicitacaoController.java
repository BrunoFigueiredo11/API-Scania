package com.api.scania.api.scania.controller;

import com.api.scania.api.scania.dto.EmailDto;
import com.api.scania.api.scania.model.*;
import com.api.scania.api.scania.repository.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/list")
public class LicitacaoController {
    @Autowired
    private LicitacaoRepository licitacaoRepository;
    @Autowired
    private LicitacaoAdapterRepository licitacaoAdapterRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private OrgaoRepository orgaoRepository;
    @Autowired
    private DescricaoRepository descricaoRepository;

    @Autowired
    private EmailController emailController;
    @Autowired
    private DescricaoController descController;
    @Autowired
    private OrgaoController orgController;

    @GetMapping("/licitacao")
    public List<LicitacaoAdapter> lista() {


        return licitacaoAdapterRepository.findAllLicAdapter();
    }

    @GetMapping("/licitacao/{id}")
    public List<Licitacao> lista(@PathVariable int id) {
        return licitacaoRepository.findAllById(Collections.singleton(id
        ));
    }

    @PutMapping("/licitacao/{id}/{status}")
    public ResponseEntity<Void> list(@PathVariable int id, @PathVariable int status) {
        try {
            List<Licitacao> lic = lista(id);
            licitacaoRepository.updateStatus(status, id);
            if (lic.get(0).getCd_status() == 2 && status == 1 || lic.get(0).getCd_status() == 3 && status == 1) {
                List<Descricao> desc = descController.lista(lic.get(0).getCd_descricao());
                List<Orgao> orgao = orgController.lista(lic.get(0).getCd_orgao());
                emailController.sendEmail(new EmailDto("brunofigueiredo1120@gmail.com",
                        "brunofigueiredo1120@gmail.com",
                         "Licitação Selecionada - Edital - " + lic.get(0).getCd_edital(),
                           "Licitação Selecionada: Edital - " + lic.get(0).getCd_edital() +
                                "\nOrgão - " + orgao.get(0).getOrgao() +
                                "\nData de Acolhimento - " + lic.get(0).getDt_acolhimento() +
                                "\nData de Disputa - " + lic.get(0).getDt_disputa() +
                                "\nDescrição - " + desc.get(0).getTexto() +
                                "\nLink para o Edital - " + desc.get(0).getEdital_link(),
                        "00/00/0000",
                        StatusEmail.SEND));
            }  else if (lic.get(0).getCd_status() == 1 && status == 3) {
                List<Descricao> desc = descController.lista(lic.get(0).getCd_descricao());
                List<Orgao> orgao = orgController.lista(lic.get(0).getCd_orgao());
                emailController.sendEmail(new EmailDto("brunofigueiredo1120@gmail.com",
                        "brunofigueiredo1120@gmail.com",
                        "Alteração ****** Licitação *** DESCARTADA *** Edital - " + lic.get(0).getCd_edital(),
                        "Alteração ****** Licitação DESCARTADA: Edital - " + lic.get(0).getCd_edital() +
                                "\nOrgão - " + orgao.get(0).getOrgao() +
                                "\nData de Acolhimento - " + lic.get(0).getDt_acolhimento() +
                                "\nData de Disputa - " + lic.get(0).getDt_disputa() +
                                "\nDescrição - " + desc.get(0).getTexto() +
                                "\nLink para o Edital - " + desc.get(0).getEdital_link(),
                        "00/00/0000",
                        StatusEmail.SEND));
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }
}
