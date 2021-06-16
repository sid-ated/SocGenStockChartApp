package com.siddhartha.SocGenPhase3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siddhartha.SocGenPhase3.entity.CompanyEntity;
import com.siddhartha.SocGenPhase3.service.CompanyService;

@RestController
public class CompanyController {
	
	@Autowired
	CompanyService cs;
	
	@RequestMapping(value="/company/all", method=RequestMethod.GET)
	public List<CompanyEntity> getAllCompanies(){
		return cs.getAllCompanies();
	}

	@RequestMapping(value="/company/{id}/show", method=RequestMethod.GET)
	public CompanyEntity getCompanyById(@PathVariable int id){
		return cs.getCompanyById(id);
	}

	@RequestMapping(value="/company/{id}/edit", method=RequestMethod.PUT)
	public String updateCompany(@PathVariable int id, @RequestBody CompanyEntity company){
		if(cs.getCompanyById(id)==null) return "company does not exist";
		cs.editCompany(company, id);
		return company.toString() + "has been edited successfully";
	}
	
	@RequestMapping(value="/company/new", method=RequestMethod.POST)
	public CompanyEntity saveCompany(@RequestBody CompanyEntity company){
		return cs.newCompany(company);
	}
	
	
	@RequestMapping(value="/company/{id}/delete", method=RequestMethod.DELETE)
	public void deleteCompany(@PathVariable int id){
		cs.deleteCompany(id);
	}

}
