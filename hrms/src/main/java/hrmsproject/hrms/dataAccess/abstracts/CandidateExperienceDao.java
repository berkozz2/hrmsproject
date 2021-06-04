package hrmsproject.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsproject.hrms.entities.concretes.CandidateExperience;

public interface CandidateExperienceDao extends JpaRepository<CandidateExperience, Integer> {
	
	List<CandidateExperience> getByCandidate(int candidateId);
}
