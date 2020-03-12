package com.ajc.kartina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajc.kartina.model.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer> {

}
