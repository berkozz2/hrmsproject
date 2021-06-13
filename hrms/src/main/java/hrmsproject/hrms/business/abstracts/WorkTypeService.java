package hrmsproject.hrms.business.abstracts;

import java.util.List;

import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.entities.concretes.WorkType;

public interface WorkTypeService {
	DataResult<List<WorkType>> getAll();
}
