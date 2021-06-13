package hrmsproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsproject.hrms.entities.concretes.WorkTime;

public interface WorkTimeDao extends JpaRepository<WorkTime, Integer> {

}
