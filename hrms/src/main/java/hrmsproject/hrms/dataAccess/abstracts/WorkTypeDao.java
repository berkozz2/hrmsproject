package hrmsproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsproject.hrms.entities.concretes.WorkType;

public interface WorkTypeDao extends JpaRepository<WorkType, Integer> {

}
