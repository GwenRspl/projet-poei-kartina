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

import com.ajc.kartina.model.EnteteCommande;
import com.ajc.kartina.repository.EnteteCommandeRepository;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EnteteCommandeApiController {

	@Autowired
	private EnteteCommandeRepository repository;

	@GetMapping("/orders")
	public ResponseEntity<List<EnteteCommande>> list() {
		return new ResponseEntity<>(this.repository.findAll(), HttpStatus.OK);
	}

	@PostMapping("/orders")
	public ResponseEntity<String> create(@RequestBody EnteteCommande enteteCommande) {
		if (!this.repository.existsById(enteteCommande.getId())) {
			this.repository.save(enteteCommande);
			return new ResponseEntity<>("Commande créée", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Erreur, commande déjà existante", HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/orders/{id}")
	public ResponseEntity<EnteteCommande> findById(@PathVariable(name = "id") Integer id) {
		if (this.repository.existsById(id)) {
			return new ResponseEntity<>(this.repository	.findById(id)
														.get(),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new EnteteCommande(), HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/orders")
	public ResponseEntity<String> update(@RequestBody EnteteCommande enteteCommande) {
		if (this.repository.existsById(enteteCommande.getId())) {
			this.repository.save(enteteCommande);
			return new ResponseEntity<>("Commande mise à jour", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Erreur, la commande n'existe pas", HttpStatus.NOT_MODIFIED);
		}
	}

	@DeleteMapping("/orders/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") Integer id) {
		if (this.repository.existsById(id)) {
			EnteteCommande e = this.repository	.findById(id)
												.get();
			this.repository.delete(e);
			return new ResponseEntity<>("Commande supprimé", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Erreur, la commande n'existe pas", HttpStatus.NOT_FOUND);
		}
	}

}
