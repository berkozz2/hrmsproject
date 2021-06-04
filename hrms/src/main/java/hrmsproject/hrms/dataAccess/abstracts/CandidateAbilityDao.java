package hrmsproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsproject.hrms.entities.concretes.CandidateAbility;

public interface CandidateAbilityDao extends JpaRepository<CandidateAbility, Integer>{

}
