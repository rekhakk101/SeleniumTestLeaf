package week6;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTCs implements IRetryAnalyzer{

	int count = 0;
	public boolean retry(ITestResult result) {
		if(count<2) {
			return true;
		}else
		return false;
	}

}
