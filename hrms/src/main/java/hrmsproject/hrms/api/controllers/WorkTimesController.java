package hrmsproject.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsproject.hrms.business.abstracts.WorkTimeService;
import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.entities.concretes.WorkTime;

@RestController
@RequestMapping(value = "/api/worktimes")
@CrossOrigin
public class WorkTimesController {

	private WorkTimeService workTimeService;

	public WorkTimesController(WorkTimeService workTimeService) {
		super();
		this.workTimeService = workTimeService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<WorkTime>>getAll(){
		return this.workTimeService.getAll();
	}
	
}
