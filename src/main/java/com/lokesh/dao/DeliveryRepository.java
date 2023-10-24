package com.lokesh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lokesh.model.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}
