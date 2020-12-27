package com.rahul.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "Musicians")
public class MusiciansEntity {
	@Schema(description = "Unique identifier of the Musicians.", example = "1", required = true)

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer musiciansId;
	
	@Schema(description = "Name of the Album", example = "Rahul Mishra", required = true)

	private String musicianName;
	
	@Schema(description = "Musicians Type", example = "Superstar Signed Artist", required = true)

	private String musicianType;

	public Integer getMusiciansId() {
		return musiciansId;
	}

	public void setMusiciansId(Integer musiciansId) {
		this.musiciansId = musiciansId;
	}

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

	@Override
	public String toString() {
		return "MusiciansEntity [musiciansId=" + musiciansId + ", musicianName=" + musicianName + ", musicianType="
				+ musicianType + "]";
	}

	public MusiciansEntity() {
		super();
	}

}
