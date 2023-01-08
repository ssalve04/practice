package com.apolis.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apolis.entity.Domain;


@Service
public class DomainService {

    
    public static final String END_POINT = "http://localhost:8080/web/domains/";



    public List<Domain> getDomain() {

        RestTemplate restTemplate = new RestTemplate();
        Domain[] domainArray = restTemplate.getForObject(END_POINT,Domain[].class);

        
        return Arrays.asList(domainArray);

    }

    
}
