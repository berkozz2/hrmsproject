package hrmsproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.WorkTimeService;
import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.core.utilities.results.SuccessDataResult;
import hrmsproject.hrms.dataAccess.abstracts.WorkTimeDao;
import hrmsproject.hrms.entities.concretes.WorkTime;

@Service
public class WorkTimeManager implements WorkTimeService {
	
	private WorkTimeDao workTimeDao;
	
	@Autowired
	public WorkTimeManager(WorkTimeDao workTimeDao) {
		super();
		this.workTimeDao = workTimeDao;
	}


	@Override
	public DataResult<List<WorkTime>> getAll() {
		
		return new SuccessDataResult<List<WorkTime>>(this.workTimeDao.findAll(),"Çalışma Saatleri Listelendi.");
	}


	@Override
	public DataResult<List<WorkTime>> getByJobAdverId(int id) {
		
		return new SuccessDataResult<List<WorkTime>>(this.workTimeDao.getByJobAdvertisementId(id));
	}


}
