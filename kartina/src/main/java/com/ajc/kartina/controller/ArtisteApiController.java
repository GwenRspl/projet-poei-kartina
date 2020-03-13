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

import com.ajc.kartina.model.Artiste;
import com.ajc.kartina.repository.ArtisteRepository;

@RestController
@RequestMapping("/api")
public class ArtisteApiController {

	@Autowired
	private ArtisteRepository repository;

	@GetMapping("/artistes")
	public ResponseEntity<List<Artiste>> list() {
		return new ResponseEntity<>(this.repository.findAll(), HttpStatus.OK);
	}

	@PostMapping("/artistes")
	public ResponseEntity<String> create(@RequestBody Artiste artiste) {
		if (!this.repository.existsById(artiste.getId())) {
			this.repository.save(artiste);
			return new ResponseEntity<>("Artiste créée", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Erreur, l'artiste existe déjà", HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/artistes/{id}")
	public ResponseEntity<Artiste> findById(@PathVariable(name = "id") Integer id) {
		if (this.repository.existsById(id)) {
			return new ResponseEntity<>(this.repository	.findById(id)
														.get(),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new Artiste(), HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/artistes")
	public ResponseEntity<String> update(@RequestBody Artiste artiste) {
		if (this.repository.existsById(artiste.getId())) {
			this.repository.save(artiste);
			return new ResponseEntity<>("Actualité mise à jour", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Erreur, l'actualité n'existe pas", HttpStatus.NOT_MODIFIED);
		}
	}

	@DeleteMapping("/artistes/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") Integer id) {
		if (this.repository.existsById(id)) {
			Artiste a = this.repository	.findById(id)
											.get();
			this.repository.delete(a);
			return new ResponseEntity<>("Artiste supprimé", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Erreur, l'artiste n'existe pas", HttpStatus.NOT_FOUND);
		}
	}
}
