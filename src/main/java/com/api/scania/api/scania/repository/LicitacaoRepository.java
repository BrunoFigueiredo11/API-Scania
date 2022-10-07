package com.api.scania.api.scania.repository;

import com.api.scania.api.scania.model.Licitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicitacaoRepository extends JpaRepository<Licitacao,Integer> {

}
