package com.api.scania.api.scania.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tb_orgao")
public class Orgao {
    @Id
    private int cd_orgao;
    private String orgao;
}
