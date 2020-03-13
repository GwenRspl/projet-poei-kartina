package com.ajc.kartina.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cadre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "cadre")
	private List<LigneCommande> lignecmde;

	@JsonIgnore
	@Version
	private int version;

	// accesseurs
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<LigneCommande> getLignecmde() {
		return lignecmde;
	}

	public void setLignecmde(List<LigneCommande> lignecmde) {
		this.lignecmde = lignecmde;
	}

	// construct

	public Cadre(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Cadre() {
		super();
	}
	// tostring

	@Override
	public String toString() {
		return "Cadre [id=" + id + ", name=" + name + "]";
	}

}
