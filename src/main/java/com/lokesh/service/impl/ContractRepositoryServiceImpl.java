package com.lokesh.service.impl;

 

import java.util.List;

 

import org.springframework.stereotype.Service;

 

import com.lokesh.dao.ContractRepository;
import com.lokesh.model.Contract;
import com.lokesh.service.ContractRepositoryService;

 

@Service
public class ContractRepositoryServiceImpl implements ContractRepositoryService  {

 

private ContractRepository contractRepository;
    
    public ContractRepositoryServiceImpl(ContractRepository contractRepository) {
        super();
        this.contractRepository = contractRepository;
    }

 

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

 

    @Override
    public Contract saveContract(Contract contract) {
        return contractRepository.save(contract);
    }

 

    @Override
    public Contract getContractById(Long id) {
        return contractRepository.findById(id).get();
    }

 

    @Override
    public Contract updateContract(Contract contract) {
        return contractRepository.save(contract);
    }

 

    @Override
    public void deleteContractById(Long id) {
        contractRepository.deleteById(id);    
    }
    
}





