package com.training.controllerStartup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.training.entityService.TrainingCenters;
import com.training.serviceStartup.*;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;

@RestController
public class ControllerTraningCenter 
{
	@Autowired 
	ServiceStartup service;
	
	//PostMapping to post TrainingCenters details
	@PostMapping("/startup")
	public ResponseEntity<?> createTraningCenter(@Valid @RequestBody TrainingCenters t)
	{
		try
		{
			TrainingCenters savedtc=service.saveCentre(t);
			return new ResponseEntity<>(savedtc ,HttpStatus.CREATED);
		}
		catch(ValidationException e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	//GetMapping to get all the TrainingCenters
	@GetMapping("/getTraningCenter")
	public List<TrainingCenters> getCenter()
	{
		return service.getAllData();
		
	}

}
