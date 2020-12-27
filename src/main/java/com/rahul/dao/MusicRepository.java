package com.rahul.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.entity.MusicAlbumEntity;

public interface MusicRepository extends JpaRepository<MusicAlbumEntity, Integer> {

}
