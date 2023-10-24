package com.lokesh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lokesh.model.Proposal;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {

}
