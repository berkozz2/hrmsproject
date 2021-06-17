package hrmsproject.hrms.business.concretes;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.JobAdvertisementConfirmService;
import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.core.utilities.results.Result;
import hrmsproject.hrms.core.utilities.results.SuccessDataResult;
import hrmsproject.hrms.core.utilities.results.SuccessResult;
import hrmsproject.hrms.dataAccess.abstracts.JobAdvertisementConfirmDao;
import hrmsproject.hrms.entities.concretes.JobAdvertisementConfirm;


@Service
public class JobAdvertisementConfirmManager implements JobAdvertisementConfirmService{

	private JobAdvertisementConfirmDao jobAdvertisementConfirmDao;
	
	@Autowired
	public JobAdvertisementConfirmManager(JobAdvertisementConfirmDao jobAdvertisementConfirmDao) {
		super();
		this.jobAdvertisementConfirmDao = jobAdvertisementConfirmDao;
	}

	@Override
	public Result add(JobAdvertisementConfirm jobAdvertisementConfirm) {
		this.jobAdvertisementConfirmDao.save(jobAdvertisementConfirm);
		return new SuccessResult();
	}

	@Override
	public DataResult<JobAdvertisementConfirm> getByJobAdvertisementConfirmId(int jobAdvertisementId) {
		
		return new SuccessDataResult<JobAdvertisementConfirm>(this.jobAdvertisementConfirmDao.getByJobAdvertisement_Id(jobAdvertisementId));
	}


}
