package com.api.scania.api.scania.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tb_descricao")
public class Descricao {
    @Id
    private int cd_descricao;

    private String texto;
    private String edital_link;
}
