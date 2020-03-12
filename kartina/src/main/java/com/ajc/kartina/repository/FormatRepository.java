package com.ajc.kartina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajc.kartina.model.Format;

@Repository
public interface FormatRepository extends JpaRepository<Format, Integer> {

}
