package APIAutomationFramework.TestCases.SampleTCs;

import APIAutomationFramework.Listners.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryListnerTC {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void tc1(){
        Assert.assertTrue(false);
    }
}
