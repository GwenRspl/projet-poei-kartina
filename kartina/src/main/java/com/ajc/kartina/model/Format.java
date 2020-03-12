package com.ajc.kartina.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Format {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String dimensions;
	
	@OneToMany(mappedBy="format")
	private List<LigneCommande> lignecmde;
	
	@ManyToMany(mappedBy="format")
	private List<Photo>photo;
	@Version
	private int version;
	
//	accesseurs
	
	public int getId() {
		return id;
	}
	public List<LigneCommande> getLignecmde() {
		return lignecmde;
	}
	public void setLignecmde(List<LigneCommande> lignecmde) {
		this.lignecmde = lignecmde;
	}
	public List<Photo> getPhoto() {
		return photo;
	}
	public void setPhoto(List<Photo> photo) {
		this.photo = photo;
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
	public String getDimensions() {
		return dimensions;
	}
	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
//	constructeurs
	
	public Format(int id, String name, String dimensions) {
		super();
		this.id = id;
		this.name = name;
		this.dimensions = dimensions;
	}
	public Format() {
		super();
	}
	
//	toString
	
	@Override
	public String toString() {
		return "Format [id=" + id + ", name=" + name + ", dimensions=" + dimensions + "]";
	}
	
	
	
	
	
}
