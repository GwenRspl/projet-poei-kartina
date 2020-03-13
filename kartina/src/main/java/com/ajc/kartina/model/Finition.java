package com.ajc.kartina.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Finition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(mappedBy="finition")
	private List<LigneCommande> lignecmde;
	
	@Version
	private int version;
	
//	accesseurs
	
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
//	constructeur
	
	public Finition(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Finition() {
		super();
	}

	
//	tostring
	
	@Override
	public String toString() {
		return "Finition [id=" + id + ", name=" + name + "]";
	}
	
	
}
