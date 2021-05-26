package hrmsproject.hrms.core.utilities.results;

public class SuccessResult extends Result{
	
	public SuccessResult() {
		super(true);
	}

	public SuccessResult(boolean success, String message) {
		super(success, message);
	}

}
