package hrmsproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsproject.hrms.entities.concretes.CandidateLink;

public interface CandidateLinkDao extends JpaRepository<CandidateLink, Integer> {
	
}
