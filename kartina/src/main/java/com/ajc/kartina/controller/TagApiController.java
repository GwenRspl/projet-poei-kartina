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

import com.ajc.kartina.model.Tag;
import com.ajc.kartina.repository.TagRepository;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class TagApiController {
	
	@Autowired
	private TagRepository repository;

	@GetMapping("/tags")
	public ResponseEntity<List<Tag>> list() {
		return new ResponseEntity<>(this.repository.findAll(), HttpStatus.OK);
	}

	@PostMapping("/tags")
	public ResponseEntity<String> create(@RequestBody Tag tag) {
		if (!this.repository.existsById(tag.getId())) {
			this.repository.save(tag);
			return new ResponseEntity<>("Tag créé", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Erreur, le tag existe déjà", HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/tags/{id}")
	public ResponseEntity<Tag> findById(@PathVariable(name = "id") Integer id) {
		if (this.repository.existsById(id)) {
			return new ResponseEntity<>(this.repository	.findById(id)
														.get(),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new Tag(), HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/tags")
	public ResponseEntity<String> update(@RequestBody Tag tag) {
		if (this.repository.existsById(tag.getId())) {
			this.repository.save(tag);
			return new ResponseEntity<>("Tag mis à jour", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Erreur, le tag n'existe pas", HttpStatus.NOT_MODIFIED);
		}
	}

	@DeleteMapping("/tags/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") Integer id) {
		if (this.repository.existsById(id)) {
			Tag t = this.repository	.findById(id)
											.get();
			this.repository.delete(t);
			return new ResponseEntity<>("Tag supprimé", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Erreur, le tag n'existe pas", HttpStatus.NOT_FOUND);
		}
	}

}
