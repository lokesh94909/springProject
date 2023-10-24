package com.lokesh.service;

import java.util.List;

import com.lokesh.model.Delivery;

public interface DeliveryRepositoryService {

List<Delivery> getAllDeliverys();
	
	Delivery saveDelivery(Delivery delivery);
	
	Delivery getDeliveryById(Long id);
	
	Delivery updateDelivery(Delivery delivery);
	
	void deleteDeliveryById(Long id);

}
