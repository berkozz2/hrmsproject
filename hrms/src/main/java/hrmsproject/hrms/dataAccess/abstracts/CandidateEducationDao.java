package hrmsproject.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsproject.hrms.entities.concretes.CandidateEducation;

public interface CandidateEducationDao extends JpaRepository<CandidateEducation, Integer>{
	List<CandidateEducation> getByCandidate(int candidateId);
}
