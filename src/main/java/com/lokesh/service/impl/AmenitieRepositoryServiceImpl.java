package com.lokesh.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lokesh.dao.AmenitieRepository;
import com.lokesh.model.Amenitie;
import com.lokesh.service.AmenitieRepositoryService;

@Service
public class AmenitieRepositoryServiceImpl implements AmenitieRepositoryService {

private AmenitieRepository amenitieRepository;
	
	public AmenitieRepositoryServiceImpl(AmenitieRepository amenitieRepository) {
		super();
		this.amenitieRepository = amenitieRepository;
	}

	@Override
	public List<Amenitie> getAllAmenities() {
		return amenitieRepository.findAll();
	}

	@Override
	public Amenitie saveAmenitie(Amenitie proposal) {
		return amenitieRepository.save(proposal);
	}

	@Override
	public Amenitie getAmenitieById(Long id) {
		return amenitieRepository.findById(id).get();
	}

	@Override
	public Amenitie updateAmenitie(Amenitie proposal) {
		return amenitieRepository.save(proposal);
	}

	@Override
	public void deleteAmenitieById(Long id) {
		amenitieRepository.deleteById(id);	
	}
	
}
