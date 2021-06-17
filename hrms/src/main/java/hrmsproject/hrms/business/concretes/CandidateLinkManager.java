package hrmsproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.CandidateLinkService;
import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.core.utilities.results.Result;
import hrmsproject.hrms.core.utilities.results.SuccessDataResult;
import hrmsproject.hrms.core.utilities.results.SuccessResult;
import hrmsproject.hrms.dataAccess.abstracts.CandidateLinkDao;
import hrmsproject.hrms.entities.concretes.CandidateLink;

@Service
public class CandidateLinkManager implements CandidateLinkService {
	
	private CandidateLinkDao candidateLinkDao;
	
	@Autowired
	public CandidateLinkManager(CandidateLinkDao candidateLinkDao) {
		super();
		this.candidateLinkDao = candidateLinkDao;
	}

	@Override
	public Result add(CandidateLink candidateLink) {
		this.candidateLinkDao.save(candidateLink);
		return new SuccessResult(true,"Link Address Added");
	}

	@Override
	public DataResult<List<CandidateLink>> getAll() {
		
		return new SuccessDataResult<List<CandidateLink>>(this.candidateLinkDao.findAll());
	}

	@Override
	public DataResult<List<CandidateLink>> getByCandidate_Id(int candidateId) {
		return new SuccessDataResult<List<CandidateLink>>(this.candidateLinkDao.getByCandidate_Id(candidateId));
	}

}
