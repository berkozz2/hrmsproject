package hrmsproject.hrms.core.validationRules;



import hrmsproject.hrms.microService.FakeService;


public class MernisCheckManager {
	
	public static boolean isRealPerson(String tcNo) {
		FakeService fakeService = new FakeService();
		
		return FakeService.mernisCheck(tcNo);
	}

}
