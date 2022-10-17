package com.api.scania.api.scania.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Item {
    @Id
    private int id_item;
    private int cd_licitacao;
    private int ident;
    private String descricao;
    private String unidade;
    private int quantidade;
    private String melhor_lance;
    private String valor_ref;
    private String situacao;


}
