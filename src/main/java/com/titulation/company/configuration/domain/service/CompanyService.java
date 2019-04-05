package com.titulation.company.configuration.domain.service;

import com.titulation.company.configuration.domain.model.Company;
import com.titulation.company.configuration.domain.repository.CompanyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    
    private CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository conmpanyRepository) {
        this.companyRepository = conmpanyRepository;
    }
    
    public List<Company> getCompanies(String idEmpresa) {
        return companyRepository.findByIdEmpresa(idEmpresa);
    }
    
}
