package hrmsproject.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import hrmsproject.hrms.business.abstracts.CandidateAbilityService;
import hrmsproject.hrms.business.abstracts.CandidateEducationService;
import hrmsproject.hrms.business.abstracts.CandidateExperienceService;
import hrmsproject.hrms.business.abstracts.CandidateLanguageService;
import hrmsproject.hrms.business.abstracts.CandidateLinkService;
import hrmsproject.hrms.business.abstracts.CandidateService;
import hrmsproject.hrms.business.abstracts.ImageService;
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
import hrmsproject.hrms.entities.dtos.CurriculumVitaeDto;

@Service
public class CandidateManager implements CandidateService {

	
	private CandidateDao candidateDao;
	private VerificationCodeService verificationCodeService;
	private UserService userService;
	private CandidateLanguageService candidateLanguageService;
	private CandidateExperienceService candidateExperienceService;
	private CandidateAbilityService candidateAbilityService;
	private CandidateEducationService candidateEducationService;
	private CandidateLinkService candidateLinkService;
	private ImageService imageService;
	
	

	@Autowired
	public CandidateManager(CandidateDao candidateDao, VerificationCodeService verificationCodeService,
			UserService userService, CandidateLanguageService candidateLanguageService,
			CandidateExperienceService candidateExperienceService, CandidateAbilityService candidateAbilityService,
			CandidateEducationService candidateEducationService, CandidateLinkService candidateLinkService,
			ImageService imageService) {
		super();
		this.candidateDao = candidateDao;
		this.verificationCodeService = verificationCodeService;
		this.userService = userService;
		this.candidateLanguageService = candidateLanguageService;
		this.candidateExperienceService = candidateExperienceService;
		this.candidateAbilityService = candidateAbilityService;
		this.candidateEducationService = candidateEducationService;
		this.candidateLinkService = candidateLinkService;
		this.imageService = imageService;
	}

	
	
	
	@Override
	public DataResult<Candidate> add(Candidate candidate) {
		
		if(!firstNameChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Ad Bilgisi Doldurulmak Zorundad??r");
		}
		else if(!lastNameChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null,"SoyAd?? Bilgisi Doldurulmak Zorundad??r");
		}
		
		else if(!MernisCheckManager.isRealPerson(candidate.getIdendityNumber())) {
			return new ErrorDataResult<Candidate>(null,"Kimlik Do??rulanamad??");
		}
		else if(candidate.getIdendityNumber().isBlank()) {
			return new ErrorDataResult<Candidate>(null,"Tc Kimlik Bilgisi Bo?? B??rak??lamaz");
		}
		
		else if(!birthDateChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Do??um Tarihi Bilgisi Doldurulmak Zorundad??r");
		}
		
		else if(!emailNullChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Email Bilgisi Doldurulmak Zorundad??r");
		}
		else if(!isRealEmail(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Email Adresiniz Yanl????");
		}
		
		else if(!passwordNullChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null,"??ifre Bilgisi Doldurulmak Zorundad??r");
		}
		
		else if(candidateDao.findAllByEmail(candidate.getEmail()).stream().count() != 0 ) {
			return new ErrorDataResult<Candidate>(null,"Email Zaten Kay??tl??");
		}
		else if(candidateDao.findAllByIdendityNumber(candidate.getIdendityNumber()).stream().count() != 0 ) {
			return new ErrorDataResult<Candidate>(null,"TC Numaras?? Zaten Kay??tl??");
		}
		User savedUser = this.userService.add(candidate);
		this.verificationCodeService.generatedCode(new VerificationCode(),savedUser.getId());
		return new SuccessDataResult<Candidate>(this.candidateDao.save(candidate),"???? Arayan Hesab?? Eklendi , Do??rulama Kodu G??nderildi:"+candidate.getId());
			
		
		
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
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"???? Arayanlar Listesi ba??ar??yla getirildi.");
	}

	@Override
	public DataResult<CurriculumVitaeDto> getByCurriculumVitaeDtoId(int id) {
		CurriculumVitaeDto cv = new CurriculumVitaeDto();
		
		cv.setAbilities(this.candidateAbilityService.getByCandidateId(id).getData());
		cv.setEducations(this.candidateEducationService.getByCandidate_Id(id).getData());
		cv.setExperiences(this.candidateExperienceService.getByCandidate_Id(id).getData());
		cv.setLanguages(this.candidateLanguageService.getByCandidate_Id(id).getData());
		cv.setLinks(this.candidateLinkService.getByCandidate_Id(id).getData());
		cv.setImage(this.imageService.getByCandidate_Id(id).getData());
		cv.setCandidate(this.candidateDao.getOne(id));
		
		return new SuccessDataResult<CurriculumVitaeDto>(cv,"CV listelendi.");
	}

	
	
	
}
