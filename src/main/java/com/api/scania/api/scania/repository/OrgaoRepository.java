package com.api.scania.api.scania.repository;

import com.api.scania.api.scania.model.Orgao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgaoRepository extends JpaRepository<Orgao,Integer> {
}
