package com.api.scania.api.scania.repository;

import com.api.scania.api.scania.model.Item;
import com.api.scania.api.scania.model.Licitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
// criar uma query que altere o status para 1- selecionado



    @Query(value = "select * from tb_item where cd_licitacao=?1", nativeQuery = true)
  List<Item> selectFromStatus(int cd
  );
}
