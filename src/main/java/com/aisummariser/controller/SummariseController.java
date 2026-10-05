package com.aisummariser.controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;


import com.aisummariser.dto.SummariseRequest;
import com.aisummariser.dto.SummariseResponse;
import com.aisummariser.service.SummariseService;



@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class SummariseController {

	
	private final SummariseService summariseService ;
	
	public SummariseController(SummariseService summariseService) {
		this.summariseService = summariseService;
		
	}
	
	@PostMapping("/summarise")
	public ResponseEntity<SummariseResponse>summarise(@RequestBody SummariseRequest request){
		
		if(request.getContent() == null || request.getContent().trim().isEmpty()) {
			return ResponseEntity.badRequest().build();
	}
	
	
		
	SummariseResponse response = summariseService.summariseText(request.getContent());
	return ResponseEntity.ok(response);
	
}
}
	

