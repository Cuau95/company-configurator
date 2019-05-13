package com.titulation.company.configuration.domain.service;

import com.titulation.company.configuration.domain.model.Company;
import com.titulation.company.configuration.domain.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    
    private CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository conmpanyRepository) {
        this.companyRepository = conmpanyRepository;
    }
    
    public Company getCompanies(String idEmpresa) {
        return companyRepository.findByIdEmpresa(idEmpresa);
    }
    
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }
    
}
