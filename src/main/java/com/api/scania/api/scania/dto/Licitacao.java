package com.api.scania.api.scania.dto;

import lombok.Data;

@Data
public class Licitacao {
    private int cd_licitacao;
    private String cd_edital;
    private String dt_acolhimento;
    private String dt_disputa;
    private int cd_status;
    private int cd_orgao;
    private int cd_descricao;
}
