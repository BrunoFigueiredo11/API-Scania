package com.api.scania.api.scania.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "view_licitacao")
public class Licitacao {
    @Id
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
