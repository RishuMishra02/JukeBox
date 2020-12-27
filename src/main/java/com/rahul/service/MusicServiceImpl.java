package com.rahul.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.dao.MusicRepository;
import com.rahul.entity.MusicAlbumEntity;
import com.rahul.model.MusicAlbum;

@Service
public class MusicServiceImpl implements MusicService {
	@Autowired
	private MusicRepository musicRepository;

	@Override
	public MusicAlbum createMusicAlbum(MusicAlbumEntity entity) {
		MusicAlbum album = new MusicAlbum();
		MusicAlbumEntity save = musicRepository.save(entity);
		BeanUtils.copyProperties(save, album);
		return album;
	}

	@Override
	public MusicAlbum updateMusicAlbum(Integer id, MusicAlbum album) {
		MusicAlbumEntity updatedEntity = null;
		MusicAlbum updatedAlbum = new MusicAlbum();
		Optional<MusicAlbumEntity> optional = musicRepository.findById(id);
		if (optional.isPresent()) {
			MusicAlbumEntity musicAlbumEntity = optional.get();

			BeanUtils.copyProperties(album, musicAlbumEntity);
			// musicAlbumEntity.setMusicAlbumId(id);
			updatedEntity = musicRepository.save(musicAlbumEntity);
			BeanUtils.copyProperties(updatedEntity, updatedAlbum);
		}
		return updatedAlbum;
	}

	@Override
	public List<MusicAlbum> getAllAlbums() {
		List<MusicAlbum> list = new ArrayList<>();
		MusicAlbum album = new MusicAlbum();
		List<MusicAlbumEntity> findAll = musicRepository.findAll();
		for (MusicAlbumEntity entity : findAll) {
			BeanUtils.copyProperties(entity, album);
			list.add(album);
		}

		return list;
	}

}
