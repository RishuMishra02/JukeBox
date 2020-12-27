package com.rahul.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Musicians implements Comparable<Musicians> {
	private String musicianName;
	private String musicianType;

	public String getMusicianName() {
		return musicianName;
	}

	public void setMusicianName(String musicianName) {
		this.musicianName = musicianName;
	}

	public String getMusicianType() {
		return musicianType;
	}

	public void setMusicianType(String musicianType) {
		this.musicianType = musicianType;
	}

	public Musicians(String musicianName, String musicianType) {
		super();
		this.musicianName = musicianName;
		this.musicianType = musicianType;
	}

	public Musicians() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Musicians [musicianName=" + musicianName + ", musicianType=" + musicianType + "]";
	}

	@Override
	public int compareTo(Musicians o) {
		if (this.getMusicianName().compareTo(o.getMusicianName()) > 0)
			return 1;
		else {
			return -1;
		}

	}

}
