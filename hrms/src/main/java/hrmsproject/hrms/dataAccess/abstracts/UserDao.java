package hrmsproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsproject.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User,Integer>{
	
}
