package hrmsproject.hrms.business.abstracts;

import java.util.List;

import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.entities.concretes.Employee;

public interface EmployeeService {
	DataResult<Employee> add(Employee employee);
	
	DataResult<List<Employee>>getAll();
}
