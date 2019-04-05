package com.titulation.company.configuration.infratructure.controller;

import static org.springframework.http.HttpStatus.FOUND;
import static org.springframework.http.HttpStatus.OK;

import com.titulation.company.configuration.domain.model.Company;
import com.titulation.company.configuration.domain.service.CompanyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company")
public class CompanyContoller {

    private CompanyService companyService;

    @Autowired
    public CompanyContoller(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/id/{idEmpresa}")
    public ResponseEntity<List<Company>> getComanies(@PathVariable("idEmpresa") String idEmpresa) {
        return new ResponseEntity<>(companyService.getCompanies(idEmpresa), FOUND);
    }

    @PostMapping("/id/{idEmpresa}")
    public ResponseEntity<Company> postComanies(@RequestBody Company company, @PathVariable("idEmpresa") String idEmpresa) {
        company.setIdEmpresa(idEmpresa);
        return new ResponseEntity<>(companyService.saveCompany(company), OK);
    }

}
