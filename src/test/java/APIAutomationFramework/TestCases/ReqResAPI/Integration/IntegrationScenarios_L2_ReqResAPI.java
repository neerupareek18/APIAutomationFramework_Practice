package APIAutomationFramework.TestCases.ReqResAPI.Integration;

import APIAutomationFramework.BaseClass.BaseClassReqResAPI;
import APIAutomationFramework.Endpoints.ReqResAPI.ReqResAPIConstantsClass;
import APIAutomationFramework.Listners.RetryAnalyzer;
import APIAutomationFramework.Modules.PayloadManager_ReqRes;
import APIAutomationFramework.Pojos.ReqResAPI.CreateResponse;
import APIAutomationFramework.Pojos.ReqResAPI.DataResponse;
import APIAutomationFramework.Pojos.ReqResAPI.ListUsersResponse;
import APIAutomationFramework.Pojos.ReqResAPI.SingleUserResponse;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class IntegrationScenarios_L2_ReqResAPI extends BaseClassReqResAPI{

    public void registerUser(){

    }

}
