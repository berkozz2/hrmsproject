package hrmsproject.hrms.business.abstracts;

import java.util.List;

import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.core.utilities.results.Result;
import hrmsproject.hrms.entities.concretes.CandidateAbility;

public interface CandidateAbilityService {
	
	Result add(CandidateAbility candidateAbility);
	
	DataResult<List<CandidateAbility>> getAll();
	DataResult<List<CandidateAbility>> getByCandidateId(int candidateId);
}
