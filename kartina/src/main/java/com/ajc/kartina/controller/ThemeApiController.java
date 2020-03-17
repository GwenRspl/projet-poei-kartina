package com.ajc.kartina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajc.kartina.model.Theme;
import com.ajc.kartina.repository.ThemeRepository;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ThemeApiController {
	@Autowired
	private ThemeRepository repository;

	@GetMapping("/themes")
	public ResponseEntity<List<Theme>> list() {
		return new ResponseEntity<>(this.repository.findAll(), HttpStatus.OK);
	}

	@PostMapping("/themes")
	public ResponseEntity<String> create(@RequestBody Theme theme) {
		if (!this.repository.existsById(theme.getId())) {
			this.repository.save(theme);
			return new ResponseEntity<>("Thème créé", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Erreur, le thème existe déjà", HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/themes/{id}")
	public ResponseEntity<Theme> findById(@PathVariable(name = "id") Integer id) {
		if (this.repository.existsById(id)) {
			return new ResponseEntity<>(this.repository	.findById(id)
														.get(),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new Theme(), HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/themes")
	public ResponseEntity<String> update(@RequestBody Theme theme) {
		if (this.repository.existsById(theme.getId())) {
			this.repository.save(theme);
			return new ResponseEntity<>("Thème mis à jour", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Erreur, le thème n'existe pas", HttpStatus.NOT_MODIFIED);
		}
	}

	@DeleteMapping("/themes/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") Integer id) {
		if (this.repository.existsById(id)) {
			Theme t = this.repository	.findById(id)
											.get();
			this.repository.delete(t);
			return new ResponseEntity<>("Thème supprimé", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Erreur, le thème n'existe pas", HttpStatus.NOT_FOUND);
		}
	}
}
