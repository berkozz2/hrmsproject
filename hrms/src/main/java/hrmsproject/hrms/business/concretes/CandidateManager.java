package hrmsproject.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.CandidateService;
import hrmsproject.hrms.business.abstracts.UserService;
import hrmsproject.hrms.business.abstracts.VerificationCodeService;
import hrmsproject.hrms.core.utilities.results.DataResult;
import hrmsproject.hrms.core.utilities.results.ErrorDataResult;
import hrmsproject.hrms.core.utilities.results.SuccessDataResult;
import hrmsproject.hrms.core.validationRules.MernisCheckManager;
import hrmsproject.hrms.dataAccess.abstracts.CandidateDao;
import hrmsproject.hrms.entities.concretes.Candidate;
import hrmsproject.hrms.entities.concretes.User;
import hrmsproject.hrms.entities.concretes.VerificationCode;

@Service
public class CandidateManager implements CandidateService {

	@Autowired
	private CandidateDao candidateDao;
	private VerificationCodeService verificationCodeService;
	private UserService userService;
	

	public CandidateManager(CandidateDao candidateDao,VerificationCodeService verificationCodeService,UserService userService) {
		super();
		this.candidateDao = candidateDao;
		this.verificationCodeService = verificationCodeService;
		this.userService = userService;
	}

	@Override
	public DataResult<Candidate> add(Candidate candidate) {
		
		if(!firstNameChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Ad Bilgisi Doldurulmak Zorundadır");
		}
		else if(!lastNameChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null,"SoyAdı Bilgisi Doldurulmak Zorundadır");
		}
		
		else if(!MernisCheckManager.isRealPerson(candidate.getIdendityNumber())) {
			return new ErrorDataResult<Candidate>(null,"Kimlik Doğrulanamadı");
		}
		else if(candidate.getIdendityNumber().isBlank()) {
			return new ErrorDataResult<Candidate>(null,"Tc Kimlik Bilgisi Boş Bırakılamaz");
		}
		
		else if(!birthDateChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Doğum Tarihi Bilgisi Doldurulmak Zorundadır");
		}
		
		else if(!emailNullChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Email Bilgisi Doldurulmak Zorundadır");
		}
		else if(!isRealEmail(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Email Adresiniz Yanlış");
		}
		
		else if(!passwordNullChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Şifre Bilgisi Doldurulmak Zorundadır");
		}
		
		else if(candidateDao.findAllByEmail(candidate.getEmail()).stream().count() != 0 ) {
			return new ErrorDataResult<Candidate>(null,"Email Zaten Kayıtlı");
		}
		else if(candidateDao.findAllByIdendityNumber(candidate.getIdendityNumber()).stream().count() != 0 ) {
			return new ErrorDataResult<Candidate>(null,"TC Numarası Zaten Kayıtlı");
		}
		User savedUser = this.userService.add(candidate);
		this.verificationCodeService.generatedCode(new VerificationCode(),savedUser.getId());
		return new SuccessDataResult<Candidate>(this.candidateDao.save(candidate),"İş Arayan Hesabı Eklendi , Doğrulama Kodu Gönderildi:"+candidate.getId());
			
		
		
	}
	
	private boolean firstNameChecker(Candidate candidate) {
		if(candidate.getFirstName().isBlank() || candidate.getFirstName().equals(null)) {
			return false;
		}
		return true;
	}
	
	private boolean lastNameChecker(Candidate candidate) {
		if(candidate.getLastName().isBlank() || candidate.getLastName().equals(null)) {
			return false;
		}
		return true;
	}
	
	private boolean birthDateChecker(Candidate candidate) {
		if(candidate.getBirthDate().equals(null)) {
			return false;
		}
		return true;
			
	}
	
	private boolean emailNullChecker(Candidate candidate) {
		if(candidate.getEmail().isBlank() || candidate.getEmail().equals(null)) {
			return false;
		}
		return true;
	}
	
	private boolean passwordNullChecker(Candidate candidate) {
		if(candidate.getPassword().isBlank() || candidate.getPassword().equals(null)) {
			return false;
		}
		return true;
	}
	
	private boolean isRealEmail(Candidate candidate) {
		 String regex = "^(.+)@(.+)$";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(candidate.getEmail());
	     if(!matcher.matches()) {
	    	 return false;
	     }
	     return true;
	     
	}
	
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"İş Arayanlar Listesi başarıyla getirildi.");
	}

	
	
	
}
