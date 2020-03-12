package com.ajc.kartina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajc.kartina.model.Cadre;

@Repository
public interface CadreRepository extends JpaRepository<Cadre, Integer>{

}
