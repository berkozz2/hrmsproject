package hrmsproject.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hrmsproject.hrms.business.abstracts.CandidateExperienceService;
import hrmsproject.hrms.core.utilities.results.ErrorDataResult;
import hrmsproject.hrms.entities.concretes.CandidateExperience;

@RestController
@RequestMapping(value = "/api/candidateexperiences")
public class CandidateExperiencesController {
	
	private CandidateExperienceService candidateExperienceService;

	public CandidateExperiencesController(CandidateExperienceService candidateExperienceService) {
		super();
		this.candidateExperienceService = candidateExperienceService;
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> add (@Valid @RequestBody CandidateExperience candidateExperience){
		return ResponseEntity.ok(this.candidateExperienceService.add(candidateExperience));
	}
	
	@GetMapping(value = "/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.candidateExperienceService.getAll());
	}
	
	@GetMapping(value = "/getByCandidate")
	public ResponseEntity<?> getByCandidate(int candidateId){
		return ResponseEntity.ok(this.candidateExperienceService.getByCandidate(candidateId));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors=new HashMap<String,String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors= new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		
		return errors;
		
	}
}
