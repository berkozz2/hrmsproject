package hrmsproject.hrms.business.abstracts;

import java.util.List;

import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.core.utilities.results.Result;
import hrmsproject.hrms.entities.concretes.CandidateLanguage;

public interface CandidateLanguageService {
	Result add(CandidateLanguage candidateLanguage);
	
	DataResult<List<CandidateLanguage>> getAll();
	
	DataResult<List<CandidateLanguage>> getByCandidate_Id(int candidateId);
}
