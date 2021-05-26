package hrmsproject.hrms.business.abstracts;

import hrmsproject.hrms.core.utilities.results.Result;
import hrmsproject.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
	void generatedCode(VerificationCode code, Integer id);
	Result verify(String validationCode,Integer id);
}
