package hrmsproject.hrms.business.abstracts;

import java.util.List;

import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.core.utilities.results.Result;
import hrmsproject.hrms.entities.concretes.WorkTime;

public interface WorkTimeService {
	DataResult<List<WorkTime>> getAll();
	
	Result add(WorkTime workTime);
}
