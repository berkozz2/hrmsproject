package hrmsproject.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrmsproject.hrms.business.abstracts.CandidateService;
import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.entities.concretes.Candidate;
import hrmsproject.hrms.entities.dtos.CurriculumVitaeDto;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController {
	private CandidateService candidateService;

	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
	
	@PostMapping("/add")
	public DataResult<Candidate> add(@RequestBody Candidate candidate){
		return this.candidateService.add(candidate);
	}
	

	@GetMapping(value = "/curriculum")
	public DataResult<CurriculumVitaeDto> getCurriculumVitae(@RequestParam int id){
		return this.candidateService.getByCurriculumVitaeDtoId(id);
	}
	

}
