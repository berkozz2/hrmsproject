package hrmsproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.CandidateAbilityService;
import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.core.utilities.results.Result;
import hrmsproject.hrms.core.utilities.results.SuccessDataResult;
import hrmsproject.hrms.core.utilities.results.SuccessResult;
import hrmsproject.hrms.dataAccess.abstracts.CandidateAbilityDao;
import hrmsproject.hrms.entities.concretes.CandidateAbility;

@Service
public class CandidateAbilityManager implements CandidateAbilityService {

	private CandidateAbilityDao candidateAbilityDao;
	
	@Autowired
	public CandidateAbilityManager(CandidateAbilityDao candidateAbilityDao) {
		super();
		this.candidateAbilityDao = candidateAbilityDao;
	}

	@Override
	public Result add(CandidateAbility candidateAbility) {
		this.candidateAbilityDao.save(candidateAbility);
		return new SuccessResult(true,"Ability Added");
	}

	@Override
	public DataResult<List<CandidateAbility>> getAll() {
		return new SuccessDataResult<List<CandidateAbility>>(this.candidateAbilityDao.findAll(),"Ability Listed");
	}

	@Override
	public DataResult<List<CandidateAbility>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CandidateAbility>>(this.candidateAbilityDao.getByCandidate_Id(candidateId));
	}

}
