package hrmsproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.CandidateEducationService;
import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.core.utilities.results.Result;
import hrmsproject.hrms.core.utilities.results.SuccessDataResult;
import hrmsproject.hrms.core.utilities.results.SuccessResult;
import hrmsproject.hrms.dataAccess.abstracts.CandidateEducationDao;
import hrmsproject.hrms.entities.concretes.CandidateEducation;

@Service
public class CandidateEducationManager implements CandidateEducationService{

	private CandidateEducationDao candidateEducationDao;
	
	@Autowired
	public CandidateEducationManager(CandidateEducationDao candidateEducationDao) {
		super();
		this.candidateEducationDao = candidateEducationDao;
	}

	@Override
	public Result add(CandidateEducation candidateEducation) {
		this.candidateEducationDao.save(candidateEducation);
		return new SuccessResult(true,"Education Added");
	}

	@Override
	public DataResult<List<CandidateEducation>> getAll() {
		return new SuccessDataResult<List<CandidateEducation>>(this.candidateEducationDao.findAll());
	}

	@Override
	public DataResult<List<CandidateEducation>> getByCandidate(int candidateId) {
		return new SuccessDataResult<List<CandidateEducation>>(this.candidateEducationDao.getByCandidate(candidateId));
	}

}
