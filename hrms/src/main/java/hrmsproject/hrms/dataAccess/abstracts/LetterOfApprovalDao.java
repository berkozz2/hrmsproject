package hrmsproject.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsproject.hrms.entities.concretes.LetterOfApproval;

public interface LetterOfApprovalDao extends JpaRepository<LetterOfApproval, Integer>{
	List<LetterOfApproval> getByCandidate(int candidateId);
}
