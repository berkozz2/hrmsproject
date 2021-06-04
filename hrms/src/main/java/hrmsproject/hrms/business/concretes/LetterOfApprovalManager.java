package hrmsproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.LetterOfApprovalService;
import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.core.utilities.results.Result;
import hrmsproject.hrms.core.utilities.results.SuccessDataResult;
import hrmsproject.hrms.core.utilities.results.SuccessResult;
import hrmsproject.hrms.dataAccess.abstracts.LetterOfApprovalDao;
import hrmsproject.hrms.entities.concretes.LetterOfApproval;

@Service
public class LetterOfApprovalManager implements LetterOfApprovalService{
	
	private LetterOfApprovalDao letterOfApprovalDao;
	
	@Autowired
	public LetterOfApprovalManager(LetterOfApprovalDao letterOfApprovalDao) {
		super();
		this.letterOfApprovalDao = letterOfApprovalDao;
	}

	@Override
	public Result add(LetterOfApproval letterOfApproval) {
		this.letterOfApprovalDao.save(letterOfApproval);
		return new SuccessResult(true,"Letter Added");
	}

	@Override
	public DataResult<List<LetterOfApproval>> getAll() {
		return new SuccessDataResult<List<LetterOfApproval>>(this.letterOfApprovalDao.findAll());
	}

	@Override
	public DataResult<List<LetterOfApproval>> getByCandidate(int candidateId) {
		return new SuccessDataResult<List<LetterOfApproval>>(this.letterOfApprovalDao.getByCandidate(candidateId));
	}

}
