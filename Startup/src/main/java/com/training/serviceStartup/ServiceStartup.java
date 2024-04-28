package com.training.serviceStartup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.entityService.TrainingCenters;
import com.training.repositoryStartup.repositoryStartupTraning;

@Service
public class ServiceStartup 
{
	
	@Autowired
	repositoryStartupTraning repo;
	
	
	//service to save the TrainingCenters
	public TrainingCenters saveCentre(TrainingCenters t)
	{
		return repo.save(t);
		
	}
	
	//service to get the details of all TrainingCenters present in database
	public List<TrainingCenters> getAllData()
	{
		List<TrainingCenters> centres=new ArrayList<TrainingCenters>();
		repo.findAll().forEach(i -> centres.add(i));
		
		return centres;
	}
	

}
