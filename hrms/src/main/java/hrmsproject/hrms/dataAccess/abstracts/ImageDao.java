package hrmsproject.hrms.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import hrmsproject.hrms.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer> {
	Image getByCandidate(int candidateId);
}	
