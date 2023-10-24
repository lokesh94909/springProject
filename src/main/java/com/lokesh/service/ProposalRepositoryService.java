package com.lokesh.service;

import java.util.List;

import com.lokesh.model.Proposal;

public interface ProposalRepositoryService {
	
List<Proposal> getAllProposals();
	
	Proposal saveProposal(Proposal proposal);
	
	Proposal getProposalById(Long id);
	
	Proposal updateProposal(Proposal proposal);
	
	void deleteProposalById(Long id);

}