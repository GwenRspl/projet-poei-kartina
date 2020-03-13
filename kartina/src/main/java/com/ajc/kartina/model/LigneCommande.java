package com.ajc.kartina.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LigneCommande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "photo_id")
	private Photo photo;

	private int quantity;
	private double prixUnitaire;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "commande_id")
	private EnteteCommande enteteCommande;

	@ManyToOne
	@JoinColumn(name = "format_id")
	private Format format;

	@ManyToOne
	@JoinColumn(name = "finition_id")
	private Finition finition;

	@ManyToOne
	@JoinColumn(name = "cadre_id")
	private Cadre cadre;

	@JsonIgnore
	@Version
	private int version;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public EnteteCommande getEnteteCommande() {
		return enteteCommande;
	}

	public void setEnteteCommande(EnteteCommande enteteCommande) {
		this.enteteCommande = enteteCommande;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public Finition getFinition() {
		return finition;
	}

	public void setFinition(Finition finition) {
		this.finition = finition;
	}

	public Cadre getCadre() {
		return cadre;
	}

	public void setCadre(Cadre cadre) {
		this.cadre = cadre;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
