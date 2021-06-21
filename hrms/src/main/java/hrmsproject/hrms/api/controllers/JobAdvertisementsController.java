package hrmsproject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrmsproject.hrms.business.abstracts.JobAdvertisementService;
import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
@CrossOrigin
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}

	@GetMapping("/getallbydate")
	public DataResult<List<JobAdvertisement>> getAllByDate() {
		return this.jobAdvertisementService.getAllSortedByDate();
	}

	@GetMapping("/getallbyactive")
	public DataResult<List<JobAdvertisement>> getAllByActive() {
		return this.jobAdvertisementService.getAllSortedByActive();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementService.update(jobAdvertisement);
	}
	
	@GetMapping(value = "/getbyemployerid")
	public ResponseEntity<?> getByEmployerId(@RequestParam int employerId){
		return ResponseEntity.ok(this.jobAdvertisementService.getByEmployerId(employerId));
	}
}
