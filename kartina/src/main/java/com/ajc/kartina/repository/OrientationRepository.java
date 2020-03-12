package com.ajc.kartina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajc.kartina.model.Orientation;

@Repository
public interface OrientationRepository extends JpaRepository<Orientation, Integer> {

}
