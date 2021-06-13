package hrmsproject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsproject.hrms.business.abstracts.EmployeeService;
import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.entities.concretes.Employee;

@RestController
@RequestMapping(value = "/api/employees")
@CrossOrigin
public class EmployeesController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<Employee>>getAll(){
		return this.employeeService.getAll();
	}
	
	@PostMapping(value = "/add")
	public DataResult<Employee> add(@RequestBody Employee employee){
		return this.employeeService.add(employee);
	}
}
