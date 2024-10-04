package APIAutomationFramework.TestCases.SampleTCs;

import APIAutomationFramework.Utilities.ExcelReader;
import org.testng.annotations.Test;

public class DataProviderTC {

    @Test(dataProvider = "getData", dataProviderClass = ExcelReader.class)
    public void tc1(String name, String job){

        String name1 = name;
        String job1 = job;

        System.out.println(name1+"-->"+job1);
    }
}
