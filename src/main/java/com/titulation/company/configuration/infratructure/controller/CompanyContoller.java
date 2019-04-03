package com.titulation.company.configuration.infratructure.controller;

import com.titulation.company.configuration.domain.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company")
public class CompanyContoller {
    
    private CompanyService companyService;

    @Autowired
    public CompanyContoller(CompanyService companyService) {
        this.companyService = companyService;
    }
    
}
