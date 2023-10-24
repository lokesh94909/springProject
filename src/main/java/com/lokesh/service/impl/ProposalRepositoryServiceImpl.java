package com.lokesh.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lokesh.dao.ProposalRepository;
import com.lokesh.model.Proposal;
import com.lokesh.service.ProposalRepositoryService;

@Service
public class ProposalRepositoryServiceImpl implements ProposalRepositoryService {

private ProposalRepository proposalRepository;
	
	public ProposalRepositoryServiceImpl(ProposalRepository proposalRepository) {
		super();
		this.proposalRepository = proposalRepository;
	}

	@Override
	public List<Proposal> getAllProposals() {
		return proposalRepository.findAll();
	}

	@Override
	public Proposal saveProposal(Proposal proposal) {
		return proposalRepository.save(proposal);
	}

	@Override
	public Proposal getProposalById(Long id) {
		return proposalRepository.findById(id).get();
	}

	@Override
	public Proposal updateProposal(Proposal proposal) {
		return proposalRepository.save(proposal);
	}

	@Override
	public void deleteProposalById(Long id) {
		proposalRepository.deleteById(id);	
	}
	
}
