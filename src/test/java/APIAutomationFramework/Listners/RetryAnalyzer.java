package APIAutomationFramework.Listners;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    public static int currentvalue=0;
    public static final int maxrun = 3;
    @Override
    public boolean retry(ITestResult iTestResult) {

        if(currentvalue<maxrun){
            currentvalue++;
            return true;
        }

        return false;
    }
}
