package hrmsproject.hrms.business.abstracts;

import java.util.List;

import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.core.utilities.results.Result;
import hrmsproject.hrms.entities.concretes.CandidateExperience;

public interface CandidateExperienceService {
	Result add (CandidateExperience candidateExperience);
	
	DataResult<List<CandidateExperience>> getAll();
	
	DataResult<List<CandidateExperience>> getByCandidate(int candidateId);
}
