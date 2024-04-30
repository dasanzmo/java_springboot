package com.riwi.vacants.services;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.vacants.entities.Company;
import com.riwi.vacants.entities.Vacant;
import com.riwi.vacants.repositories.CompanyRepository;
import com.riwi.vacants.services.interfaces.ICompanyService;
import com.riwi.vacants.utils.dto.request.CompanyRequest;
import com.riwi.vacants.utils.dto.response.CompanyResponse;
import com.riwi.vacants.utils.dto.response.VacantToCompanyResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService{

    @Autowired
    private final CompanyRepository companyRepository;

    @Override
    public CompanyResponse create(CompanyRequest request) {

        //Convertimos el request en la entidad
        Company company = this.requestToEntity(request, new Company());
        // Agregamos la entidad en el repositorio y el retorno lo convertimos en respuesta
        return this.entityToReponse(this.companyRepository.save(company));
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Page<CompanyResponse> getAll(int page, int size) {
        // Configuramos la paginación
        if(page < 0 )
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);

        // LLamamos el repsitorio
        return this.companyRepository.findAll(pagination).map(company -> this.entityToReponse(company));
        // También puede ser (this::entityResponse)
    }

    @Override
    public CompanyResponse getByID(String id) {
        Company company = this.find(id);
        // Buscamos la compañía con el id
        return this.entityToReponse(company);
    }

    @Override
    public CompanyResponse update(CompanyRequest request, String id) {
        // TODO Auto-generated method stub
        return null;
    }

    private CompanyResponse entityToReponse(Company entity){
        CompanyResponse response = new CompanyResponse();

        // BeanUtils nos permite hacer una copia de una clase en otra, en este caso toda la entidad de tipo Company será copiada con
        // la información requerida por la variable tipo Company Response
        BeanUtils.copyProperties(entity, response);


        //Stream -> Convierte la lista en colección para poder iterarse
        // Map -> Itera toda a lista y retorna cambios
        // Collect -> Crea de nuevo toda la lista que se había transformado en 
        response.setVacants(entity.getVacants().stream().map(this::vacantToResponse).collect(Collectors.toList()));
        return response;
    }

    private VacantToCompanyResponse vacantToResponse(Vacant entity){
        VacantToCompanyResponse response = new VacantToCompanyResponse();

        BeanUtils.copyProperties(entity, response);

        return response;
    }

    private Company requestToEntity(CompanyRequest request, Company company){
        company.setContact(request.getContact());
        company.setName(request.getName());
        company.setLocation(request.getLocation());
        company.setVacants(new ArrayList<>());

        return company;
    }

    private Company find(String id){
        return this.companyRepository.findById(id).orElseThrow();
    }
    
}
