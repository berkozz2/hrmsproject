package hrmsproject.hrms.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsproject.hrms.business.abstracts.JobAdvertisementConfirmService;
import hrmsproject.hrms.entities.concretes.JobAdvertisementConfirm;

@RestController
@RequestMapping(value = "/api/jobadvertisementconfirms")
@CrossOrigin
public class JobAdvertisementConfirmsController {
	
	private JobAdvertisementConfirmService jobAdvertisementConfirmService;

	public JobAdvertisementConfirmsController(JobAdvertisementConfirmService jobAdvertisementConfirmService) {
		super();
		this.jobAdvertisementConfirmService = jobAdvertisementConfirmService;
	}
	
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@RequestBody JobAdvertisementConfirm jobAdvertisementConfirm) {
		return ResponseEntity.ok(this.jobAdvertisementConfirmService.add(jobAdvertisementConfirm));
	}
	
	@GetMapping(value = "/getbyjobadvertisementconfirmsid")
	public ResponseEntity<?> getByJobAdvertisementConfirmId(int jobAdvertisementConfirmId){
		return ResponseEntity.ok(this.jobAdvertisementConfirmService.getByJobAdvertisementConfirmId(jobAdvertisementConfirmId));
	}

}
