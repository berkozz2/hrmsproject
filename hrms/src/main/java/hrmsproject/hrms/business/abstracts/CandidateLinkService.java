package hrmsproject.hrms.business.abstracts;

import java.util.List;

import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.core.utilities.results.Result;
import hrmsproject.hrms.entities.concretes.CandidateLink;

public interface CandidateLinkService {
	Result add(CandidateLink candidateLink);
	
	DataResult<List<CandidateLink>> getAll();
	
	DataResult<List<CandidateLink>> getByCandidate_Id(int candidateId);
}
