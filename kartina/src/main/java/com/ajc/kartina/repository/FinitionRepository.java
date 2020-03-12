package com.ajc.kartina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajc.kartina.model.Finition;

@Repository
public interface FinitionRepository extends JpaRepository<Finition, Integer>{

}
