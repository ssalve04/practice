package com.apolis.entity;

import java.util.List;

public class DomainResponse {

    List<Domain> domainList;
    
    public List<Domain> getDomainList() {
        return domainList;
    }

    public void setDomainList(List<Domain> domainList) {
        this.domainList = domainList;
    }
}
