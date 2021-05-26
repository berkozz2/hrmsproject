package hrmsproject.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrmsproject.hrms.business.abstracts.VerificationCodeService;
import hrmsproject.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/verify")
public class VerificationCodesController {
	
	private VerificationCodeService verificationCodeService;
	
	
	@Autowired
	public VerificationCodesController(VerificationCodeService verificationCodeService) {
		super();
		this.verificationCodeService = verificationCodeService;
	}
	
	@PostMapping("/update/{verificationCode}/{id}")
		public Result verified(@RequestParam String validationCode, @RequestParam Integer id) {
		return verificationCodeService.verify(validationCode, id);
	}
	
	
	
}
