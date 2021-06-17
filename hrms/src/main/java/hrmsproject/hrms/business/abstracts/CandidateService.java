package hrmsproject.hrms.business.abstracts;

import java.util.List;

import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.entities.concretes.Candidate;
import hrmsproject.hrms.entities.dtos.CurriculumVitaeDto;

public interface CandidateService {
	DataResult<Candidate> add(Candidate candidate);
	
	DataResult<List<Candidate>>getAll();
	
	DataResult<CurriculumVitaeDto> getByCurriculumVitaeDtoId(int id);


}
