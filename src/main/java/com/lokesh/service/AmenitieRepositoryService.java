package com.lokesh.service;

import java.util.List;

import com.lokesh.model.Amenitie;

public interface AmenitieRepositoryService {

	List<Amenitie> getAllAmenities();
Amenitie saveAmenitie(Amenitie amenitie);
	
	Amenitie getAmenitieById(Long id);
	
	Amenitie updateAmenitie(Amenitie amenitie);
	
	void deleteAmenitieById(Long id);

}
