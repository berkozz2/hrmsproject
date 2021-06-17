package hrmsproject.hrms.business.abstracts;

import java.util.List;

import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.core.utilities.results.Result;
import hrmsproject.hrms.entities.concretes.CandidateEducation;

public interface CandidateEducationService {
	Result add(CandidateEducation candidateEducation);
	
	DataResult<List<CandidateEducation>> getAll();
	
	DataResult<List<CandidateEducation>> getByCandidate_Id(int id);
}
