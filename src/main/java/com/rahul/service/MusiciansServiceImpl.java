package com.rahul.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.dao.MusiciansRepository;
import com.rahul.entity.MusiciansEntity;
import com.rahul.model.Musicians;

@Service
public class MusiciansServiceImpl implements MusiciansService {
	
	@Autowired
	private MusiciansRepository musiciansRepository;
	
	@Override
	public Musicians createMusicians(MusiciansEntity entity) {
		Musicians records = new Musicians();
		MusiciansEntity save = musiciansRepository.save(entity);
		BeanUtils.copyProperties(save, records);
		return records;
	}

	@Override
	public Musicians updateMusicians(Integer id, Musicians records) {
		MusiciansEntity updatedEntity = null;
		Musicians updatedRecodrds = new Musicians();
		Optional<MusiciansEntity> optional = musiciansRepository.findById(id);
		if (optional.isPresent()) {
			MusiciansEntity musiciansEntity = optional.get();
			
			BeanUtils.copyProperties(records, musiciansEntity);
			//musicAlbumEntity.setMusicAlbumId(id);
			updatedEntity = musiciansRepository.save(musiciansEntity);
			BeanUtils.copyProperties(updatedEntity, updatedRecodrds);
		}
		return updatedRecodrds;
	}
	@Override
	public List<Musicians> getAllRecords() {
		List<Musicians> list  = new  ArrayList<>();
		Musicians records = new Musicians();
		List<MusiciansEntity> findAll = musiciansRepository.findAll();
		for(MusiciansEntity entity : findAll) {
			BeanUtils.copyProperties(entity, records);
			list.add(records);
		}
		
		return list;
	}
}
