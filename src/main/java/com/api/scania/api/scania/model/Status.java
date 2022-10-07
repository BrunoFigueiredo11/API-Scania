package com.api.scania.api.scania.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tb_status")
public class Status {
    @Id
    private int cd_status;
    private String tipo;
}
