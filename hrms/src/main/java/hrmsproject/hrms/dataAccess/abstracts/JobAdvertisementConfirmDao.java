package hrmsproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsproject.hrms.entities.concretes.JobAdvertisementConfirm;

public interface JobAdvertisementConfirmDao extends JpaRepository<JobAdvertisementConfirm, Integer> {
	JobAdvertisementConfirm getByJobAdvertisement_Id(int jobAdvertisements);
}
