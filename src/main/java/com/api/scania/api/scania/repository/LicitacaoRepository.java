package com.api.scania.api.scania.repository;

import com.api.scania.api.scania.model.Licitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LicitacaoRepository extends JpaRepository<Licitacao,Integer> {
// criar uma query que altere o status para 1- selecionado

  @Query(value = "select * from view_licitacao", nativeQuery = true)
  List<Licitacao> findAllLicAdapter();

  @Transactional
  @Modifying(clearAutomatically = true)
  @Query(value = "UPDATE tb_licitacao SET cd_status =?1 WHERE cd_licitacao=?2",nativeQuery=true)
  void updateStatus(int status,int cd_licitacao
  )throws Exception;

    @Query(value = "select * from view_licitacao where cd_status=?1", nativeQuery = true)
  List<Licitacao> selectFromStatus(int status
  );
}
