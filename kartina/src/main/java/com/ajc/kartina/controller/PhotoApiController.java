package com.ajc.kartina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajc.kartina.model.Photo;
import com.ajc.kartina.repository.PhotoRepository;

@RestController
@RequestMapping("/api")
public class PhotoApiController {
	
	@Autowired
	private PhotoRepository repository;

	@GetMapping("/photos")
	public ResponseEntity<List<Photo>> list() {
		return new ResponseEntity<>(this.repository.findAll(), HttpStatus.OK);
	}

	@PostMapping("/photos")
	public ResponseEntity<String> create(@RequestBody Photo photo) {
		if (!this.repository.existsById(photo.getId())) {
			this.repository.save(photo);
			return new ResponseEntity<>("Photo créée", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Erreur, la photo existe déjà", HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/photo/{id}")
	public ResponseEntity<Photo> findById(@PathVariable(name = "id") Integer id) {
		if (this.repository.existsById(id)) {
			return new ResponseEntity<>(this.repository	.findById(id)
														.get(),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new Photo(), HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/photo")
	public ResponseEntity<String> update(@RequestBody Photo photo) {
		if (this.repository.existsById(photo.getId())) {
			this.repository.save(photo);
			return new ResponseEntity<>("Photo mise à jour", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Erreur, la photo n'existe pas", HttpStatus.NOT_MODIFIED);
		}
	}

	@DeleteMapping("/photo/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") Integer id) {
		if (this.repository.existsById(id)) {
			Photo p = this.repository	.findById(id)
											.get();
			this.repository.delete(p);
			return new ResponseEntity<>("Photo supprimée", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Erreur, la photo n'existe pas", HttpStatus.NOT_FOUND);
		}
	}

}
