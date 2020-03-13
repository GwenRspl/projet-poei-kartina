package com.ajc.kartina.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ajc.kartina.model.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer> {
	
	@Query("select p from Photo p join LigneCommande od on p.id = od.photo.id group by p.id order by sum(od.quantity) desc")
	List<Photo> findBestPhotos(Pageable firstpage);

	@Query("SELECT p FROM Photo as p order by date_debut desc")
	List<Photo> findRecentPhotos(Pageable firstpage);

	List<Photo> findByThemeId(int id);

	List<Photo> findByArtisteId(int id);

	List<Photo> findTop5ByOrderByTirages();

}
