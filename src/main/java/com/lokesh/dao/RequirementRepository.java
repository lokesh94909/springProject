package com.lokesh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lokesh.model.Requirement;

public interface RequirementRepository extends JpaRepository<Requirement, Long> {

}
