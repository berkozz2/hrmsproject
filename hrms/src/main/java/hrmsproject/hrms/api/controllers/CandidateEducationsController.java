package hrmsproject.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import hrmsproject.hrms.business.abstracts.CandidateEducationService;
import hrmsproject.hrms.entities.concretes.CandidateEducation;

@RestController
@RequestMapping(value = "/api/candidateeducations")
public class CandidateEducationsController {
	
	private CandidateEducationService candidateEducationService;
	
	@Autowired
	public CandidateEducationsController(CandidateEducationService candidateEducationService) {
		super();
		this.candidateEducationService = candidateEducationService;
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@Valid @RequestBody CandidateEducation candidateEducation){
		return ResponseEntity.ok(this.candidateEducationService.add(candidateEducation));
	}
	
	@GetMapping(value = "/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.candidateEducationService.getAll());
	}
	
	@GetMapping(value = "/getByCandidate")
	public ResponseEntity<?> getByCandidate(int candidateId){
		return ResponseEntity.ok(this.candidateEducationService.getByCandidate(candidateId));
	}
}
