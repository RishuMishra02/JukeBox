package com.rahul.controller;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Parameter;
import com.rahul.entity.MusicAlbumEntity;
import com.rahul.entity.MusiciansEntity;
import com.rahul.model.MusicAlbum;
import com.rahul.model.Musicians;
import com.rahul.service.MusicService;
import com.rahul.service.MusiciansService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class MainController {
	@Autowired
	private MusicService service;
	@Autowired
	private MusiciansService service1;

	@Operation(summary = "Add New Album", description = "Arijit Singh New Collection", tags = { "Album" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "New Album Created", content = @Content(schema = @Schema(implementation = MusicAlbumEntity.class))),
			@ApiResponse(responseCode = "400", description = "Invalid input"),
			@ApiResponse(responseCode = "409", description = "Album already exists") })
	@PostMapping(value = "album", consumes = { "application/json", "application/xml" })
	public ResponseEntity<MusicAlbum> MusicAlbum(

			@Parameter(schema = @Schema(implementation = MusicAlbumEntity.class)) @RequestBody MusicAlbum album) {
		MusicAlbumEntity entity = new MusicAlbumEntity();
		BeanUtils.copyProperties(album, entity);
		MusicAlbum returnMusicAlbum = service.createMusicAlbum(entity);
		return new ResponseEntity<MusicAlbum>(returnMusicAlbum, HttpStatus.OK);
	}

	// ********************** UDPATE ALBUMS************

	@Operation(summary = "Update an existing album", description = "", tags = { "Album" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation"),
			@ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
			@ApiResponse(responseCode = "404", description = "Album not found"),
			@ApiResponse(responseCode = "405", description = "Validation exception") })
	@PutMapping("/albums/{id}")
	public ResponseEntity<MusicAlbum> updateMusicAlbum(@RequestBody MusicAlbum album,
			@Parameter(description = "Album to update. Cannot null or empty.", required = true, schema = @Schema(implementation = MusicAlbumEntity.class)) @PathVariable("id") Integer id) {
		MusicAlbum updateMusicAlbum = null;
		if (id != null && id != 0) {
			updateMusicAlbum = service.updateMusicAlbum(id, album);
			return new ResponseEntity<MusicAlbum>(updateMusicAlbum, HttpStatus.OK);
		}

		return null;
	}

	// *********** ALBUMS SORT BY DATE **************

	@GetMapping(value = "/albums/{date}")
	public ResponseEntity<List<MusicAlbum>> getAlbums(@PathVariable("date") String date) {
		System.out.println("MainController.getAlbums()" + date);
		List<MusicAlbum> allAlbums = service.getAllAlbums();

		Collections.sort(allAlbums, Collections.reverseOrder());
		return new ResponseEntity<List<MusicAlbum>>(allAlbums, HttpStatus.OK);
	}

	// ************** ALBUMS SORT BY PRICE *******************

	@GetMapping(value = "/albums/{price}")
	public ResponseEntity<List<MusicAlbum>> getAlbumsPrice(@PathVariable("price") String price) {
		List<MusicAlbum> allAlbums = service.getAllAlbums();
		Collections.sort(allAlbums, Collections.reverseOrder());
		return new ResponseEntity<List<MusicAlbum>>(allAlbums, HttpStatus.OK);
	}

	// **************** MUSICIANS RECORDS ****************

	@Operation(summary = "Add New musicians Records", description = "Old Collections", tags = { "musicians" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "New Records Created", content = @Content(schema = @Schema(implementation = MusiciansEntity.class))),
			@ApiResponse(responseCode = "400", description = "Invalid input"),
			@ApiResponse(responseCode = "409", description = "Musicians Records already exists") })
	@PostMapping(value = "Musicians", consumes = { "application/json", "application/xml" })
	public ResponseEntity<Musicians> Musicians(
			@Parameter(schema = @Schema(implementation = MusiciansEntity.class)) @RequestBody Musicians musicians) {
		MusiciansEntity entity = new MusiciansEntity();
		BeanUtils.copyProperties(musicians, entity);
		Musicians returnmusicians = service1.createMusicians(entity);
		return new ResponseEntity<Musicians>(returnmusicians, HttpStatus.OK);
	}

	// ************ UPDATE MUSICIANS RECORDS **********

	@PutMapping("/records/{id}")
	public ResponseEntity<Musicians> updateMusicians(
			@Parameter(description = "Musicians Records to updated. Cannot null or empty.", required = true, schema = @Schema(implementation = MusiciansEntity.class)) @RequestBody Musicians records,
			@PathVariable("id") Integer id) {
		Musicians updateMusicians = null;
		if (id != null && id != 0) {
			updateMusicians = service1.updateMusicians(id, records);
			return new ResponseEntity<Musicians>(updateMusicians, HttpStatus.OK);
		}

		return null;
	}

	// ********** SORT BY MUSICIANS NAME****************

	@GetMapping(value = "/records/{musicianName}")
	public ResponseEntity<List<Musicians>> getRecords(@PathVariable("musicianName") String musicianName) {
		List<Musicians> allRecords = service1.getAllRecords();
		Collections.sort(allRecords, Collections.reverseOrder());
		return new ResponseEntity<List<Musicians>>(allRecords, HttpStatus.OK);
	}

}
