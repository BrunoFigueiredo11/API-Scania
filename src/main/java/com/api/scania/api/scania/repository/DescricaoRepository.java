package com.api.scania.api.scania.repository;

import com.api.scania.api.scania.model.Descricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescricaoRepository extends JpaRepository<Descricao,Integer> {

}
