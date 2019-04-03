package com.titulation.company.configuration.domain.service;

import com.titulation.company.configuration.domain.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    
    private CompanyRepository conmpanyRepository;

    @Autowired
    public CompanyService(CompanyRepository conmpanyRepository) {
        this.conmpanyRepository = conmpanyRepository;
    }
    
}
