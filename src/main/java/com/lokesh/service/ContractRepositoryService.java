package com.lokesh.service;

import java.util.List;

import com.lokesh.model.Contract;

public interface ContractRepositoryService {

List<Contract> getAllContracts();
    
    Contract saveContract(Contract contract);
    
    Contract getContractById(Long id);
    
    Contract updateContract(Contract contract);
    
    void deleteContractById(Long id);
}
