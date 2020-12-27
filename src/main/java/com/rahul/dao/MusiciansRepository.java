package com.rahul.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.entity.MusiciansEntity;

public interface MusiciansRepository extends JpaRepository<MusiciansEntity, Integer> {

}
