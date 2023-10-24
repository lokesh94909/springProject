package com.lokesh.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lokesh.dao.DeliveryRepository;
import com.lokesh.model.Delivery;
import com.lokesh.service.DeliveryRepositoryService;


@Service
public class DeliveryRepositoryServiceImpl implements DeliveryRepositoryService{
	
private DeliveryRepository deliveryRepository;
	
	public DeliveryRepositoryServiceImpl(DeliveryRepository deliveryRepository) {
		super();
		this.deliveryRepository = deliveryRepository;
	}

	@Override
	public List<Delivery> getAllDeliverys() {
		return deliveryRepository.findAll();
	}

	@Override
	public Delivery saveDelivery(Delivery delivery) {
		return deliveryRepository.save(delivery);
	}

	@Override
	public Delivery getDeliveryById(Long id) {
		return deliveryRepository.findById(id).get();
	}

	@Override
	public Delivery updateDelivery(Delivery delivery) {
		return deliveryRepository.save(delivery);
	}

	@Override
	public void deleteDeliveryById(Long id) {
		deliveryRepository.deleteById(id);	
	}
	

}
