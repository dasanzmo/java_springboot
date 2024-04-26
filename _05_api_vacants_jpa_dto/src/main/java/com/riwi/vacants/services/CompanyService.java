package com.riwi.vacants.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.vacants.repositories.CompanyRepository;
import com.riwi.vacants.services.interfaces.ICompanyService;
import com.riwi.vacants.utils.dto.request.CompanyRequest;
import com.riwi.vacants.utils.dto.response.CompanyResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService{

    @Autowired
    private final CompanyRepository companyRepository;

    @Override
    public CompanyResponse create(CompanyRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Page<CompanyResponse> getAll(int page, int size) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CompanyResponse getByID(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CompanyResponse update(CompanyRequest request, String id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
