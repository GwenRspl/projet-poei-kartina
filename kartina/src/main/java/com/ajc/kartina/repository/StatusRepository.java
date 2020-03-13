package com.ajc.kartina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajc.kartina.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

}
