package com.api.scania.api.scania.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;


@Data
public class LicitacaoAdapter {
    @Id
    private int cd_licitacao;

    private String cd_edital;
    private String dt_acolhimento;
    private String dt_disputa;
    private List<Status> status;
    private List<Orgao> orgao;
    private List<Descricao> descricao;

    public LicitacaoAdapter(int cd_licitacao, String cd_edital, String dt_acolhimento, String dt_disputa, List<Status> status, List<Orgao> orgao, List<Descricao> descricao) {
        this.cd_licitacao = cd_licitacao;
        this.cd_edital = cd_edital;
        this.dt_acolhimento = dt_acolhimento;
        this.dt_disputa = dt_disputa;
        this.status = status;
        this.orgao = orgao;
        this.descricao = descricao;
    }
}
