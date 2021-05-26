package hrmsproject.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.EmployerService;
import hrmsproject.hrms.business.abstracts.UserService;
import hrmsproject.hrms.business.abstracts.VerificationCodeService;
import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.core.utilities.results.ErrorDataResult;
import hrmsproject.hrms.core.utilities.results.SuccessDataResult;
import hrmsproject.hrms.dataAccess.abstracts.EmployerDao;
import hrmsproject.hrms.entities.concretes.Employer;
import hrmsproject.hrms.entities.concretes.User;
import hrmsproject.hrms.entities.concretes.VerificationCode;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	private UserService userService;
	private VerificationCodeService verificationCodeService;
	
	
	public EmployerManager(EmployerDao employerDao, UserService userService,
			VerificationCodeService verificationCodeService) {
		super();
		this.employerDao = employerDao;
		this.userService = userService;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public DataResult<Employer> add(Employer employer) {
		if(!companyNameCheck(employer)) {
			return new ErrorDataResult<Employer>(null,"Şirket ismi boş bırakılamaz.");
		}else if(!webAddressCheck(employer)) {
			return new ErrorDataResult<Employer>(null,"Şirket web adresi boş bırakılamaz ve girilmesi zorunludur.");
		}else if(!phoneNumberCheck(employer)) {
			return new ErrorDataResult<Employer>(null,"Telefon numaranızı eksiksiz ve doğru giriniz.");
		}else if(!employerMailCheck(employer)) {
			return new ErrorDataResult<Employer>(null,"Geçerli bir e-posta adresi giriniz.");
		}else if(!employerRegister(employer)) {
			return new ErrorDataResult<Employer>(null,"Mail adresi daha önceden alınmıştır.");
		}else if(!passwordCheck(employer)) {
			return new ErrorDataResult<Employer>(null,"Geçersiz veya boş bırakılmış şifre. Tekrar Deneyiniz");
		}
		
		User saveUser = this.userService.add(employer);
		this.verificationCodeService.generatedCode(new VerificationCode(), saveUser.getId());
		return new SuccessDataResult<Employer>(this.employerDao.save(employer),"İş Verenler hesabına kayıt yaptırdınız. Onaylanması için mail adresinizi kontrol ediniz.");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İşverenler listesi başarıyla getirildi.");
	}
	
	
	private boolean companyNameCheck(Employer employer) {
		if(employer.getCompanyName().isEmpty()) {
			return false;
		}
		return true;
	}
	
	private boolean webAddressCheck(Employer employer) {
		if(employer.getWebAddress().isBlank() && employer.getWebAddress()==null) {
			return false;
		}
		return true;
	}
	
	private boolean phoneNumberCheck(Employer employer) {
		String patterns 
	      = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
		
		Pattern pattern = Pattern.compile(patterns);
		Matcher matcher = pattern.matcher(employer.getPhoneNumber());
		if(!matcher.matches()) {
			return false;
		}
		return true;
	}
	
	private boolean employerMailCheck(Employer employer) {
		String regex = "^(.+)@(.+)$";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(employer.getEmail());
	     if(!matcher.matches()) {
	    	 return false;
	     }
	     else if(!employer.getEmail().contains(employer.getWebAddress())) {
	    	return false; 
	     }
	     return true;
	}
	
	private boolean employerRegister(Employer employer) {
		if(employerDao.getAllByEmail(employer.getEmail()).stream().count() != 0) {
			return false;
		}
		return true;
	}
	
	private boolean passwordCheck(Employer employer) {
		if(employer.getPassword()==null && employer.getPassword().isEmpty()) {
			return false;
		}
		return true;
	}
	

}
