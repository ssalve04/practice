package com.apolis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apolis.entity.Domain;
import com.apolis.service.DomainService;



@RestController
@RequestMapping ("web/domainservice")
public class DomainController {


    @Autowired
    DomainService domainService;

    @GetMapping(value = "/domains")
    public ResponseEntity< List<Domain>> getDomain() {

        List<Domain> domainList = domainService.getDomain();

        return ResponseEntity.status(HttpStatus.OK).body(domainList);

    }



    
}
