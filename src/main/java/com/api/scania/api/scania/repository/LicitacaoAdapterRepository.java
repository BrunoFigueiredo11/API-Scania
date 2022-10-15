package com.api.scania.api.scania.repository;

import com.api.scania.api.scania.model.LicitacaoAdapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicitacaoAdapterRepository extends JpaRepository<LicitacaoAdapter,Integer> {
// criar uma query que altere o status para 1- selecionado

  @Query(value = "select * from view_licitacao", nativeQuery = true)
  List<LicitacaoAdapter> findAllLicAdapter();
}
