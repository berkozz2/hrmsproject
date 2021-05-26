package hrmsproject.hrms.business.abstracts;

import java.util.List;

import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.entities.concretes.User;

public interface UserService {
	DataResult<List<User>> getAll();
	User add(User user);
}
