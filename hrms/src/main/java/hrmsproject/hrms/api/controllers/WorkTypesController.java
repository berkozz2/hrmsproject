package hrmsproject.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsproject.hrms.business.abstracts.WorkTypeService;
import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.entities.concretes.WorkType;

@RestController
@RequestMapping(value = "/api/worktypes")
@CrossOrigin
public class WorkTypesController {
	
	private WorkTypeService workTypeService;

	public WorkTypesController(WorkTypeService workTypeService) {
		super();
		this.workTypeService = workTypeService;
	}
	
	@GetMapping(value ="/getall")
	public DataResult<List<WorkType>>getAll(){
		return this.workTypeService.getAll();
	}
	

}
