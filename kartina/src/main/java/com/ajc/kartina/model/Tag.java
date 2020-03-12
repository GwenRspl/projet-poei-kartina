package com.ajc.kartina.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

@Entity
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@ManyToMany(mappedBy="tag")
	private List<Photo>photo;
	@Version
	private int version;
	
//	accesseurs
	
	public int getId() {
		return id;
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
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
//	construct
	
	public Tag(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Tag() {
		super();
	}

//	tostring
	
	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}
