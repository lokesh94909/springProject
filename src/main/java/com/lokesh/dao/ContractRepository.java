package com.lokesh.dao;

 

import org.springframework.data.jpa.repository.JpaRepository;

 

import com.lokesh.model.Contract;

 

public interface ContractRepository extends JpaRepository<Contract, Long> {

 

}