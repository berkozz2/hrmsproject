package hrmsproject.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.EmployeeService;
import hrmsproject.hrms.business.abstracts.UserService;
import hrmsproject.hrms.business.abstracts.VerificationCodeService;
import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.core.utilities.results.ErrorDataResult;
import hrmsproject.hrms.core.utilities.results.SuccessDataResult;
import hrmsproject.hrms.dataAccess.abstracts.EmployeeDao;
import hrmsproject.hrms.entities.concretes.Employee;
import hrmsproject.hrms.entities.concretes.User;
import hrmsproject.hrms.entities.concretes.VerificationCode;

@Service
public class EmployeeManager implements EmployeeService{
	
	private EmployeeDao employeeDao;
	private UserService userService;
	private VerificationCodeService verificationCodeService;
	
	public EmployeeManager(EmployeeDao employeeDao, UserService userService,VerificationCodeService verificationCodeService) {
		super();
		this.employeeDao = employeeDao;
		this.userService = userService;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public DataResult<Employee> add(Employee employee) {
		if(!firstNameCheck(employee)) {
			return new ErrorDataResult<Employee>(null,"Kullanıcı Adı Hatalı.");
		}else if(!lastNameCheck(employee)) {
			return new ErrorDataResult<Employee>(null,"Soyadı Hatalı.");
		}
		User saveUser = this.userService.add(employee);
		this.verificationCodeService.generatedCode(new VerificationCode(), saveUser.getId());
		return new SuccessDataResult<Employee>(this.employeeDao.save(employee),"Çalışan Listesine Eklendi.");
		
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Çalışanlar Listesi Başarıyla Getirildi.");
	}
	
	
	public boolean firstNameCheck(Employee employee) {
		if(employee.getFirstName().isEmpty() || employee.getFirstName().equals(null)) {
			return false;
		}
		return true;
	}
	
	public boolean lastNameCheck(Employee employee) {
		if(employee.getLastName().isEmpty() || employee.getLastName().equals(null)) {
			return false;
		}
		return true;
	}
}
