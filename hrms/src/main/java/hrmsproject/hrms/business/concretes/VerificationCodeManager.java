package hrmsproject.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsproject.hrms.business.abstracts.VerificationCodeService;
import hrmsproject.hrms.core.utilities.results.ErrorDataResult;
import hrmsproject.hrms.core.utilities.results.Result;
import hrmsproject.hrms.core.utilities.results.SuccessDataResult;
import hrmsproject.hrms.core.validationRules.RandomGenerateCode;
import hrmsproject.hrms.dataAccess.abstracts.VerificationCodeDao;
import hrmsproject.hrms.entities.concretes.VerificationCode;


@Service
public class VerificationCodeManager implements VerificationCodeService {

	private VerificationCodeDao verificationCodeDao;
	
	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}
	

	@Override
	public void generatedCode(VerificationCode code, Integer id) {
		VerificationCode codes = code;
		codes.setCode(null);
		codes.setVerified(false);
		if(codes.isVerified()==false) {
			RandomGenerateCode generator = new RandomGenerateCode();
			String code_create = generator.create();
			codes.setCode(code_create);
			codes.setUserId(id);
			
			verificationCodeDao.save(codes);
		}
		return;
	}

	@Override
	public Result verify(String validationCode, Integer id) {
		VerificationCode valid = verificationCodeDao.getOne(id);
		if(valid.getCode().equals(validationCode)) {
			valid.setVerified(true);
			return new SuccessDataResult<VerificationCode>(this.verificationCodeDao.save(valid),"Kayıt Başarılı");
		}
		
		return new ErrorDataResult<VerificationCode>(null,"Doğrulama kodu onaysız. Mailinizi kontrol ediniz.");
	}

}
