package hrmsproject.hrms.business.abstracts;

import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.core.utilities.results.Result;
import hrmsproject.hrms.entities.concretes.JobAdvertisementConfirm;

public interface JobAdvertisementConfirmService {
	Result add(JobAdvertisementConfirm jobAdvertisementConfirm);
	
	DataResult<JobAdvertisementConfirm> getByJobAdvertisementConfirmId(int jobAdvertisementId);
}
