package com.rahul.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "Music_Album")
public class MusicAlbumEntity {

	@Schema(description = "Unique identifier of the Album.", example = "1", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer musicAlbumId;

	@Schema(description = "Name of the Album.", example = "New Collection", required = true)
	private String albumName;

	@Schema(description = "Genre of the Album.", example = "Slow", required = true)
	private String genre;

	@Schema(description = "Album Relase Date.", example = "27-12-2020", required = true)
	private Date releaseDate;

	@Schema(description = "Price of Album", example = "1200", required = true)
	private Long price;

	@Schema(description = "description of Alubm", example = "Jessica Abigail", required = true)
	private String description;

	public Integer getMusicAlbumId() {
		return musicAlbumId;
	}

	public void setMusicAlbumId(Integer musicAlbumId) {
		this.musicAlbumId = musicAlbumId;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "MusicAlbumEntity [musicAlbumId=" + musicAlbumId + ", albumName=" + albumName + ", genre=" + genre
				+ ", releaseDate=" + releaseDate + ", price=" + price + ", description=" + description + "]";
	}

	public MusicAlbumEntity(Integer musicAlbumId, String albumName, String genre, Date releaseDate, Long price,
			String description) {
		super();
		this.musicAlbumId = musicAlbumId;
		this.albumName = albumName;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.price = price;
		this.description = description;
	}

	public MusicAlbumEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
