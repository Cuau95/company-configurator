package com.titulation.company.configuration.domain.repository;

import com.titulation.company.configuration.domain.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer>{
    
    public Company findByIdEmpresa (String idEmpresa);
    
}
