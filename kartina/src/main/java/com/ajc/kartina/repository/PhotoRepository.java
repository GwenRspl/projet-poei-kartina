package com.ajc.kartina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajc.kartina.model.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer> {

	List<Photo> findByThemeId(int id);

	List<Photo> findByArtisteId(int id);

	List<Photo> findTop5ByOrderByTirages();

}
