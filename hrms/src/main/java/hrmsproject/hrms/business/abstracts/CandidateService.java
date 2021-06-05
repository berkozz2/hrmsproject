package hrmsproject.hrms.business.abstracts;

import java.util.List;

import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.entities.concretes.Candidate;

public interface CandidateService {
	DataResult<Candidate> add(Candidate candidate);
	
	DataResult<List<Candidate>>getAll();

}
