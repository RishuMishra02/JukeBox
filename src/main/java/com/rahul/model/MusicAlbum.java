package com.rahul.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MusicAlbum implements Comparable<MusicAlbum> {
	private String albumName;
	private String genre;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date releaseDate;
	private Long price;
	private String description;

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

	public MusicAlbum(String albumName, String genre, Date releaseDate, Long price, String description) {
		super();
		this.albumName = albumName;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.price = price;
		this.description = description;
	}

	public MusicAlbum() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MusicAlbum [albumName=" + albumName + ", genre=" + genre + ", releaseDate=" + releaseDate + ", price="
				+ price + ", description=" + description + "]";
	}

	@Override
	public int compareTo(MusicAlbum o) {
		if (o.getReleaseDate().compareTo(new Date()) > 0)
			return 1;
		else {
			return -1;
		}

	}
}
