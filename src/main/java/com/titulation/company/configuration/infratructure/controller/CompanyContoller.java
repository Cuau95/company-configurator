package com.titulation.company.configuration.infratructure.controller;

import static org.springframework.http.HttpStatus.FOUND;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import com.titulation.company.configuration.domain.model.Company;
import com.titulation.company.configuration.domain.model.PasswordResponse;
import com.titulation.company.configuration.domain.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/id/{idEmpresa}")
    public ResponseEntity<Company> getComanies(@PathVariable("idEmpresa") String idEmpresa) {
        return new ResponseEntity<>(companyService.getCompany(idEmpresa), OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/id/{idEmpresa}")
    public ResponseEntity<Company> postComanies(@RequestBody Company company, @PathVariable("idEmpresa") String idEmpresa) {
        company.setIdEmpresa(idEmpresa);
        return new ResponseEntity<>(companyService.saveCompany(company), OK);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/id/{idEmpresa}/password/{password}")
    public ResponseEntity<PasswordResponse> checkPassword(@PathVariable("idEmpresa") String idEmpresa, 
            @PathVariable("password") String password) {
        PasswordResponse passwordResponse = new PasswordResponse();
        String passwordCheck = companyService.checkPassword(idEmpresa, password);
        passwordResponse.setPasswordResponse(passwordCheck);
        HttpStatus status = NOT_FOUND;
        if(passwordCheck.equals("pass")){
            status = OK;
        }
        return new ResponseEntity<>(passwordResponse, status);
    }

}
