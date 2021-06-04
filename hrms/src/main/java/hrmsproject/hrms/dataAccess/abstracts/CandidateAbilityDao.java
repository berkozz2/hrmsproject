package hrmsproject.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsproject.hrms.entities.concretes.CandidateAbility;

public interface CandidateAbilityDao extends JpaRepository<CandidateAbility, Integer>{
	List<CandidateAbility> getByCandidate(int candidateId);
}
