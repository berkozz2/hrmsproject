package hrmsproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.WorkTypeService;
import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.core.utilities.results.Result;
import hrmsproject.hrms.core.utilities.results.SuccessDataResult;
import hrmsproject.hrms.core.utilities.results.SuccessResult;
import hrmsproject.hrms.dataAccess.abstracts.WorkTypeDao;
import hrmsproject.hrms.entities.concretes.WorkType;

@Service
public class WorkTypeManager implements WorkTypeService {

	private WorkTypeDao workTypeDao;
	
	@Autowired
	public WorkTypeManager(WorkTypeDao workTypeDao) {
		super();
		this.workTypeDao = workTypeDao;
	}


	@Override
	public DataResult<List<WorkType>> getAll() {
		
		return new SuccessDataResult<List<WorkType>>(this.workTypeDao.findAll(),"Çalışma Tipleri Listelendi.");
	}


	@Override
	public DataResult<List<WorkType>> getByJobAdverId(int id) {
		
		return new SuccessDataResult<List<WorkType>>(this.workTypeDao.getById(id));
	}


	@Override
	public Result add(WorkType workType) {
		this.workTypeDao.save(workType);
		return new SuccessResult(true,"Çalışma tipi eklendi");
	}

}
