package com.rahul.service;

import java.util.List;

import com.rahul.entity.MusiciansEntity;
import com.rahul.model.Musicians;

public interface MusiciansService  {
	public Musicians createMusicians(MusiciansEntity entity);
	public Musicians updateMusicians(Integer id,Musicians records);
	public List<Musicians> getAllRecords();
}
