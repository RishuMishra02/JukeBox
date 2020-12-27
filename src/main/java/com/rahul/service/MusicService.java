package com.rahul.service;

import java.util.List;

import com.rahul.entity.MusicAlbumEntity;
import com.rahul.model.MusicAlbum;

public interface MusicService {
	
	public MusicAlbum createMusicAlbum(MusicAlbumEntity entity);
	public MusicAlbum updateMusicAlbum(Integer id,MusicAlbum album);
	public List<MusicAlbum> getAllAlbums();
	
	



}
