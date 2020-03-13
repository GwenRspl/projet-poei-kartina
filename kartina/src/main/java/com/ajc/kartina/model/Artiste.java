package com.ajc.kartina.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Artiste {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String prenom;
	private String nom;
	private String bio;
	private String twitter;
	private String facebook;
	private String pinterest;

	@OneToMany(mappedBy = "artiste")
	private List<Photo> photo;

	@JsonIgnore
	@OneToOne(mappedBy = "artiste")
	private User user;

	@JsonIgnore
	@Version
	private int version;
	// ACCESSEURS

	public int getId() {
		return id;
	}

	public List<Photo> getPhoto() {
		return photo;
	}

	public void setPhoto(List<Photo> photo) {
		this.photo = photo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getPinterest() {
		return pinterest;
	}

	public void setPinterest(String pinterest) {
		this.pinterest = pinterest;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	// CONSTRUCT

	public Artiste() {
		super();
	}

	// public Artiste(int id, String prenom, String nom, String bio, String twitter,
	// String facebook, String pinterest,
	// User user) {
	// super();
	// this.id = id;
	// this.prenom = prenom;
	// this.nom = nom;
	// this.bio = bio;
	// this.twitter = twitter;
	// this.facebook = facebook;
	// this.pinterest = pinterest;
	// this.user = user;
	// }

	// TOSTRING

	@Override
	public String toString() {
		return "Artiste [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", bio=" + bio + ", twitter=" + twitter
				+ ", facebook=" + facebook + ", pinterest=" + pinterest + "]";
	}

}
