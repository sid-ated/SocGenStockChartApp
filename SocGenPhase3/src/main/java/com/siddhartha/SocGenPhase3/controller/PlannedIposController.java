package com.siddhartha.SocGenPhase3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siddhartha.SocGenPhase3.entity.PlannedIposEntity;
import com.siddhartha.SocGenPhase3.service.PlannedIposService;

@RestController
public class PlannedIposController {
	
	@Autowired
	PlannedIposService ps;
	
	@RequestMapping(value="/ipo/all", method=RequestMethod.GET)
	public List<PlannedIposEntity> getAllIpos(){
		return ps.getAllPlannedIpos();
	}

	@RequestMapping(value="/ipo/{id}/show", method=RequestMethod.GET)
	public PlannedIposEntity getIpoById(@PathVariable int id){
		return ps.getPlannedIposById(id);
	}

	@RequestMapping(value="/ipo/{id}/edit", method=RequestMethod.PUT)
	public String updateIpo(@PathVariable int id, @RequestBody PlannedIposEntity ipo){
		if(ps.getPlannedIposById(id)==null) return "ipo does not exist";
		ps.editPlannedIpos(ipo, id);
		return ipo.toString() + "has been edited successfully";
	}
	
	@RequestMapping(value="/ipo/new", method=RequestMethod.POST)
	public PlannedIposEntity saveCompany(@RequestBody PlannedIposEntity ipo){
		return ps.newPlannedIpos(ipo);
	}
	
	
	@RequestMapping(value="/ipo/{id}/delete", method=RequestMethod.DELETE)
	public void deleteIpo(@PathVariable int id){
		ps.deletePlannedIpos(id);
	}

}
