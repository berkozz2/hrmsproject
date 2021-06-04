package hrmsproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsproject.hrms.entities.concretes.LetterOfApproval;

public interface LetterOfApprovalDao extends JpaRepository<LetterOfApproval, Integer>{

}
