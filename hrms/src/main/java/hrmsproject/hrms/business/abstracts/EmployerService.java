package hrmsproject.hrms.business.abstracts;

import java.util.List;

import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.entities.concretes.Employer;

public interface EmployerService {
	
	DataResult<Employer> add (Employer employer);
	
	DataResult<List<Employer>>getAll();
}
