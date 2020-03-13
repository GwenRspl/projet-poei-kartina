package com.ajc.kartina.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private double prix;
	private int tirages;
	private Date date_debut;
	private Date date_fin;
	private String imgUrl;
	private String imgThumbnail;

	@JsonIgnore
	@OneToMany(mappedBy = "photo")
	private List<LigneCommande> lignecmde;

	@JsonIgnore
	@Version
	private int version;

	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "photo_theme", joinColumns = @JoinColumn(name = "photo_id"), inverseJoinColumns = @JoinColumn(name = "theme_id"))
	private List<Theme> theme;

	@ManyToOne
	@JoinColumn(name = "orientation_id")
	private Orientation orientation;

	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "photo_format", joinColumns = @JoinColumn(name = "photo_id"), inverseJoinColumns = @JoinColumn(name = "format_id"))
	private List<Format> format;

	@ManyToOne
	@JoinColumn(name = "artiste_id")
	private Artiste artiste;

	@ManyToMany(cascade = { CascadeType.ALL })
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "photo_tag", joinColumns = @JoinColumn(name = "photo_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Tag> tag;

	// ACCESSSEURS

	public int getId() {
		return id;
	}

	public List<LigneCommande> getLignecmde() {
		return lignecmde;
	}

	public void setLignecmde(List<LigneCommande> lignecmde) {
		this.lignecmde = lignecmde;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getTirages() {
		return tirages;
	}

	public void setTirages(int tirages) {
		this.tirages = tirages;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getImgThumbnail() {
		return imgThumbnail;
	}

	public void setImgThumbnail(String imgThumbnail) {
		this.imgThumbnail = imgThumbnail;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public List<Theme> getTheme() {
		return theme;
	}

	public void setTheme(List<Theme> theme) {
		this.theme = theme;
	}

	public List<Format> getFormat() {
		return format;
	}

	public void setFormat(List<Format> format) {
		this.format = format;
	}

	public List<Tag> getTag() {
		return tag;
	}

	public void setTag(List<Tag> tag) {
		this.tag = tag;
	}

	public Artiste getArtiste() {
		return artiste;
	}

	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	// CONSTRUCT

	public Photo() {
		super();
	}

	// TOSTRING

	@Override
	public String toString() {
		return "Photo [id=" + id + ", title=" + title + ", prix=" + prix + ", tirages=" + tirages + ", date_debut="
				+ date_debut + ", date_fin=" + date_fin + ", imgUrl=" + imgUrl + ", imgThumbnail=" + imgThumbnail
				+ ", theme=" + theme + ", orientation=" + orientation + ", format=" + format + ", artiste=" + artiste
				+ ", tag=" + tag + "]";
	}

}
