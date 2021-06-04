package hrmsproject.hrms.business.abstracts;

import java.util.List;

import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.core.utilities.results.Result;
import hrmsproject.hrms.entities.concretes.LetterOfApproval;

public interface LetterOfApprovalService {
	Result add(LetterOfApproval letterOfApproval);
	
	DataResult<List<LetterOfApproval>> getAll();
	
	DataResult<List<LetterOfApproval>> getByCandidate(int candidateId);
}
