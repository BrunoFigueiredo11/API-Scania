package com.api.scania.api.scania.dto;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Licitacao {
    private int cd_licitacao;

    private String cd_edital;
    private String dt_acolhimento;
    private String dt_disputa;
    private int cd_status;
    private String tipo;
    private int cd_orgao;
    private String orgao;
    private int cd_descricao;
    private String texto;
    private String edital_link;

}
