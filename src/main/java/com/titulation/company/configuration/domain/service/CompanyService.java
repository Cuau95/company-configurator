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
    
    public Company getCompany(String idEmpresa) {
        try{
            return companyRepository.findByIdEmpresa(idEmpresa);
        }catch(Exception ex){
            return null;
        }
    }
    
    public Company saveCompany(Company company) {
        try{
            return companyRepository.save(company);
        }catch(Exception ex) {
            return null;
        }
    }
    
    public String checkPassword(String idCompany, String password){
        try{
            if(getCompany(idCompany).getPassword().equals(password)){
                return "pass";
            }
            return "not_pass";
        }catch(Exception ex) {
            return "not_found";
        }
    }
    
}
